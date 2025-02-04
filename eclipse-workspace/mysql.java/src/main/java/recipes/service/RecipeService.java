package recipes.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import recipes.dao.RecipeDao;
import recipes.entity.Category;
import recipes.entity.Ingredient;
import recipes.entity.Recipe;
import recipes.entity.Step;
import recipes.entity.Unit;
import recipes.exception.DbException;

public class RecipeService {
	private static final String SCHEMA_FILE = "recipe_schema.sql";
	private static final String DATA_FILE = "recipe_data.sql";

	private RecipeDao recipeDao = new RecipeDao();

	public Recipe fetchRecipeById(Integer recipeId) {
		return recipeDao.fetchRecipeById(recipeId)
				.orElseThrow(() -> new NoSuchElementException("Recipe with ID=" + recipeId + " does not exist."));
	}

	public void createAndPopulateTables() {
		loadFromFile(SCHEMA_FILE);
		loadFromFile(DATA_FILE);
	}

	private void loadFromFile(String fileName) {
		String content = readFileContent(fileName);
		List<String> sqlStatements = convertContentToSqlStatements(content);

		// Print each statement on its own line
//		sqlStatements.forEach(line -> System.out.println(line));

		recipeDao.executeBatch(sqlStatements);
	}

	private List<String> convertContentToSqlStatements(String content) {
		// Remove all SQL comments
		content = removeComments(content);
		// Remove multiple whitespace with single space
		content = replaceWhitespaceSequencesWithSingleSpace(content);

		// Extract all statements into a list
		return extractLinesFromContent(content);
	}

	private List<String> extractLinesFromContent(String content) {
		List<String> lines = new LinkedList<>();

		while (!content.isEmpty()) {
			int semicolon = content.indexOf(";");

			// If it's the last line...
			if (semicolon == -1) {
				// ...and if line is not blank
				if (!content.isBlank()) {
					lines.add(content);
				}

				// if the line is blank, exit the loop
				content = "";
			}

			// If a semicolon ";" is found
			else {
				// Add a substring starting from beginning of line, excluding semicolon, and
				// trimming any whitespace
				lines.add(content.substring(0, semicolon).trim());
				// Remove the above line from 'content' by setting content to remaining file
				// text
				content = content.substring(semicolon + 1);
			}
		}

		return lines;
	}

	private String replaceWhitespaceSequencesWithSingleSpace(String content) {
		// Use regex to find whitespace sequences; replace with single space
		return content.replaceAll("\\s+", " ");
	}

	private String removeComments(String content) {
		StringBuilder builder = new StringBuilder(content);
		// Counter to keep track of comment position
		int commentPosition = 0;

		// Look for "-- " and get position (index)
		while ((commentPosition = builder.indexOf("-- ", commentPosition)) != -1) {
			// Look for end of line and get position (index)
			int endOfLinePosition = builder.indexOf("\n", commentPosition + 1);

			if (endOfLinePosition == -1) {
				// If line is at the end of the file, i.e. does not end with a line feed (\n),
				// replace with nothing ("")
				builder.replace(commentPosition, builder.length(), "");
			} else {
				// Remove comment line including end of line feed (\n)
				builder.replace(commentPosition, endOfLinePosition + 1, "");
			}
		}

		return builder.toString();
	}

	private String readFileContent(String fileName) {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
			return Files.readString(path);

		} catch (Exception e) {
			throw new DbException(e);
		}
	}

	public Recipe addRecipe(Recipe recipe) {
		return recipeDao.insertRecipe(recipe);
	}

	public List<Recipe> fetchRecipes() {
		return recipeDao.fetchAllRecipes();
	}

	public List<Unit> fetchUnits() {
		return recipeDao.fetchAllUnits();
	}

	public void addIngredient(Ingredient ingredient) {
		recipeDao.addIngredientToRecipe(ingredient);
	}

	public void addStep(Step step) {
		recipeDao.addStepToRecipe(step);
	}

	public List<Category> fetchCategories() {
		return recipeDao.fetchAllCategories();
	}

}
