package recipes.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Recipe {
	private Integer recipeId;
	private String recipeName;
	private String notes;
	private Integer numServings;
	private LocalTime prepTime;
	private LocalTime cookTime;
	private LocalDateTime createdAt;

	private List<Ingredient> ingredients = new LinkedList<>();
	private List<Step> steps = new LinkedList<>();
	private List<Category> categories = new LinkedList<>();

	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
		String createTime = Objects.nonNull(createdAt) ? fmt.format(createdAt) : "(null)";

		String recipe = "";

		recipe += "\n    ID=" + recipeId;
		recipe += "\n    recipeName=" + recipeName;
		recipe += "\n    notes=" + notes;
		recipe += "\n    numServings=" + numServings;
		recipe += "\n    prepTime=" + prepTime;
		recipe += "\n    cookTime=" + cookTime;
		recipe += "\n    createdAt=" + createTime;

		recipe += "\n   Ingredients:";

		for (Ingredient ingredient : ingredients) {
			recipe += "\n      " + ingredient;
		}

		recipe += "\n   Steps:";

		for (Step step : steps) {
			recipe += "\n      " + step;
		}

		recipe += "\n   Categories:";

		for (Category category : categories) {
			recipe += "\n      " + category;
		}

		return recipe;
	}

	/**
	 * @return the recipeId
	 */
	public Integer getRecipeId() {
		return recipeId;
	}

	/**
	 * @param recipeId the recipeId to set
	 */
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	/**
	 * @return the recipeName
	 */
	public String getRecipeName() {
		return recipeName;
	}

	/**
	 * @param recipeName the recipeName to set
	 */
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the numServings
	 */
	public Integer getNumServings() {
		return numServings;
	}

	/**
	 * @param numServings the numServings to set
	 */
	public void setNumServings(Integer numServings) {
		this.numServings = numServings;
	}

	/**
	 * @return the prepTime
	 */
	public LocalTime getPrepTime() {
		return prepTime;
	}

	/**
	 * @param prepTime the prepTime to set
	 */
	public void setPrepTime(LocalTime prepTime) {
		this.prepTime = prepTime;
	}

	/**
	 * @return the cookTime
	 */
	public LocalTime getCookTime() {
		return cookTime;
	}

	/**
	 * @param cookTime the cookTime to set
	 */
	public void setCookTime(LocalTime cookTime) {
		this.cookTime = cookTime;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the steps
	 */
	public List<Step> getSteps() {
		return steps;
	}

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

}
