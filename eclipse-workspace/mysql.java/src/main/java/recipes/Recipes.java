package recipes;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import recipes.entity.Category;
import recipes.entity.Ingredient;
import recipes.entity.Recipe;
import recipes.entity.Step;
import recipes.entity.Unit;
import recipes.exception.DbException;
import recipes.service.RecipeService;

public class Recipes {

	private Scanner scanner = new Scanner(System.in);
	private RecipeService recipeService = new RecipeService();
	private Recipe currRecipe;

	// List of menu options
	// @formatter:off
	private List<String> operations = List.of(
		"1) Create and populate all tables",
		"2) Add a recipe",
		"3) List recipes",
		"4) Select working recipe",
		"5) Add ingredient to current recipe",
		"6) Add step to current recipe",
		"7) Add category to current recipe",
		"8) Modify step in current recipe"
	);
	// @formatter:on

	public static void main(String[] args) {
		// Test getting a connection
//		DbConnection.getConnection();

		new Recipes().displayMenu();
	}

	private void displayMenu() {
		// Flag for when operation is finished
		boolean done = false;

		while (!done) {

			try {
				int operation = getOperation();

				switch (operation) {
				case -1:
					done = exitMenu(); // will return 'true'
					break;

				case 1:
					createTables();
					break;

				case 2:
					addRecipe();
					break;

				case 3:
					listRecipes();
					break;

				case 4:
					setCurrentRecipe();
					break;

				case 5:
					addIngredientToCurrentRecipe();
					break;

				case 6:
					addStepToCurrentRecipe();
					break;

				case 7:
					addCategoryToCurrentRecipe();
					break;
					
				case 8:
					modifyStepInCurrentRecipe();
					break;

				default:
					System.out.println("\n" + operation + " is not valid. Try again.");
					break;
				}
			} catch (Exception e) {
				System.out.println("\nError: " + e.toString() + " Try again.");
			}

		}
	}

	private void modifyStepInCurrentRecipe() {
		// Check if there is current recipe
		if (Objects.isNull(currRecipe)) {
			System.out.println("\nPlease select a recipe first.");
			return;
		}
		
		// Create list of Step to hold steps from db
		List<Step> steps = recipeService.fetchSteps(currRecipe.getRecipeId());
		// Print list of steps for user to choose from
		System.out.println("\nSteps for current recipe:");
		steps.forEach(step -> System.out.println("   " + step));
		
		// Get user input
		Integer stepId = getIntInput("Enter step ID of step to modify");
		
		if (Objects.nonNull(stepId)) {
			String stepText = getStringInput("Enter new step text");
			
			if (Objects.nonNull(stepText)) {
				Step step = new Step();
				
				step.setStepId(stepId);
				step.setStepText(stepText);
				
				recipeService.modifyStep(step);
				// Set currRecipe back to re-load the step
				currRecipe = recipeService.fetchRecipeById(currRecipe.getRecipeId());
			}
		}
	}

	private void addCategoryToCurrentRecipe() {
		// Check if there is current recipe
		if (Objects.isNull(currRecipe)) {
			System.out.println("\nPlease select a recipe first.");
			return;
		}

		// List the existing categories
		List<Category> categories = recipeService.fetchCategories();
		categories.forEach(category -> System.out.println("  " + category.getCategoryName()));

		String category = getStringInput("Enter the category to add");

		if (Objects.nonNull(category)) {
			recipeService.addCategoryToRecipe(currRecipe.getRecipeId(), category);
			currRecipe = recipeService.fetchRecipeById(currRecipe.getRecipeId());
		}
	}

	private void addStepToCurrentRecipe() {
		// Check if there is current recipe
		if (Objects.isNull(currRecipe)) {
			System.out.println("\nPlease select a recipe first.");
			return;
		}

		String stepText = getStringInput("Enter the step text");

		if (Objects.nonNull(stepText)) {
			Step step = new Step();

			step.setRecipeId(currRecipe.getRecipeId());
			step.setStepText(stepText);

			recipeService.addStep(step);
			currRecipe = recipeService.fetchRecipeById(step.getRecipeId());
		}
	}

	private void addIngredientToCurrentRecipe() {
		// Check if there is current recipe
		if (Objects.isNull(currRecipe)) {
			System.out.println("\nPlease select a recipe first.");
			return;
		}

		String name = getStringInput("Enter the ingredient name");
		String instruction = getStringInput("Enter an instruction, if any (e.g. \"finely chopped\")");
		Double inputAmount = getDoubleInput("Enter the ingredient amount (e.g. .25)");

		// Get available units
		List<Unit> units = recipeService.fetchUnits();

		// Convert Double input amount to BigDecimal
		BigDecimal amount = Objects.isNull(inputAmount) ? null : new BigDecimal(inputAmount).setScale(2);

		// Print units
		System.out.println("Units:");
		units.forEach(unit -> System.out.println(
				"   " + unit.getUnitId() + ": " + unit.getUnitNameSingular() + " (" + unit.getUnitNamePlural() + ")"));

		// Get user input for unit ID
		Integer unitId = getIntInput("Enter a unit ID (press Enter for none)");

		// Set ingredient fields
		Unit unit = new Unit();
		unit.setUnitId(unitId);

		Ingredient ingredient = new Ingredient();

		ingredient.setRecipeId(currRecipe.getRecipeId());
		ingredient.setUnit(unit);
		ingredient.setIngredientName(name);
		ingredient.setInstruction(instruction);
		ingredient.setAmount(amount);

		// Call recipeService to add ingredient
		recipeService.addIngredient(ingredient);
		currRecipe = recipeService.fetchRecipeById(ingredient.getRecipeId());
	}

	private void setCurrentRecipe() {
		// List recipes so user can select a recipe ID
		List<Recipe> recipes = listRecipes();

		// Get user input
		Integer recipeId = getIntInput("Select a recipe ID");

		// Un-select any current recipe
		currRecipe = null;

		// Loop through list to find matching recipe
		for (Recipe recipe : recipes) {
			if (recipe.getRecipeId().equals(recipeId)) {
				currRecipe = recipeService.fetchRecipeById(recipeId);
				break;
			}
		}

		// If no match is found
		if (Objects.isNull(currRecipe)) {
			System.out.println("\nInvalid recipe selected.");
		}
	}

	private void addRecipe() {
		String name = getStringInput("Enter the recipe name");
		String notes = getStringInput("Enter recipe notes");
		Integer numServings = getIntInput("Enter number of servings");
		Integer prepMinutes = getIntInput("Enter prep time in minutes");
		Integer cookMinutes = getIntInput("Enter cook time in minutes");

		// Convert prep and cook times to local time objects:
		LocalTime prepTime = minutesToLocalTime(prepMinutes);
		LocalTime cookTime = minutesToLocalTime(cookMinutes);

		Recipe recipe = new Recipe();

		recipe.setRecipeName(name);
		recipe.setNotes(notes);
		recipe.setNumServings(numServings);
		recipe.setPrepTime(prepTime);
		recipe.setCookTime(cookTime);

		Recipe dbRecipe = recipeService.addRecipe(recipe);
		System.out.println("You added this recipe:\n" + dbRecipe);

		currRecipe = recipeService.fetchRecipeById(dbRecipe.getRecipeId());
	}

	private List<Recipe> listRecipes() {
		List<Recipe> recipes = recipeService.fetchRecipes();

		System.out.println("\nRecipes:");

		recipes.forEach(recipe -> System.out.println("    " + recipe.getRecipeId() + ": " + recipe.getRecipeName()));

		return recipes;
	}

	private LocalTime minutesToLocalTime(Integer numMinutes) {
		int min = Objects.isNull(numMinutes) ? 0 : numMinutes;
		int hours = min / 60;
		int minutes = min % 60;

		return LocalTime.of(hours, minutes);
	}

	private void createTables() {
		recipeService.createAndPopulateTables();
		System.out.println("\nTables created and populated!");
	}

	private boolean exitMenu() {
		System.out.println("\nExiting the menu.");
		return true;
	}

	private int getOperation() {
		printOperations();
		Integer operation = getIntInput("\nEnter an operation number (press Enter to quit)");

		return Objects.isNull(operation) ? -1 : operation;
	}

	private void printOperations() {
		System.out.println();
		System.out.println("Here's what you can do:");

		operations.forEach(operation -> System.out.println("\t" + operation));

		if (Objects.isNull(currRecipe)) {
			System.out.println("\nYou are not working with a recipe.");
		} else {
			System.out.println("\nYou are working with recipe " + currRecipe);
		}
	}

	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);

		if (Objects.isNull(input)) {
			return null; // Can return `null` because used `Integer` (Object) instead of `int`(primitive)
		}

		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
	}

	@SuppressWarnings("unused")
	private Double getDoubleInput(String prompt) {
		String input = getStringInput(prompt);

		if (Objects.isNull(input)) {
			return null; // Can return `null` because used `Double` (Object) instead of `double`
							// (primitive)
		}

		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
	}

	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String line = scanner.nextLine();

		return line.isBlank() ? null : line.trim();
	}

}
