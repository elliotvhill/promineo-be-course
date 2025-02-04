package recipes.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import provided.util.DaoBase;
import recipes.entity.Category;
import recipes.entity.Ingredient;
import recipes.entity.Recipe;
import recipes.entity.Step;
import recipes.entity.Unit;
import recipes.exception.DbException;

public class RecipeDao extends DaoBase {

	private static final String CATEGORY_TABLE = "category";
	private static final String INGREDIENT_TABLE = "ingredient";
	private static final String RECIPE_TABLE = "recipe";
	private static final String RECIPE_CATEGORY_TABLE = "recipe_category";
	private static final String STEP_TABLE = "step";
	private static final String UNIT_TABLE = "unit";

	public Recipe insertRecipe(Recipe recipe) {
		// @formatter:off
		String sql = ""
				+ "INSERT INTO " + RECIPE_TABLE + " "
				+ "(recipe_name, notes, num_servings, prep_time, cook_time) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?)"; // '?' are placeholders 
		// @formatter:on

		// Obtain connection
		try (Connection conn = DbConnection.getConnection()) {
			startTransaction(conn);

			// Create a PreparedStatement
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				// Set the parameters -- reminder: params are 1-based
				setParameter(stmt, 1, recipe.getRecipeName(), String.class);
				setParameter(stmt, 2, recipe.getNotes(), String.class);
				setParameter(stmt, 3, recipe.getNumServings(), Integer.class);
				setParameter(stmt, 4, recipe.getPrepTime(), LocalTime.class);
				setParameter(stmt, 5, recipe.getCookTime(), LocalTime.class);

				// Call the executeUpdate method on the Statement to do the INSERT
				stmt.executeUpdate();
				Integer recipeId = getLastInsertId(conn, RECIPE_TABLE);

				commitTransaction(conn);

				recipe.setRecipeId(recipeId);
				return recipe;
			} catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
			}
		} catch (SQLException e) {
			throw new DbException(e);
		}

	}

	public List<Recipe> fetchAllRecipes() {
		String sql = "SELECT * FROM " + RECIPE_TABLE + " ORDER BY recipe_name";

		try (Connection conn = DbConnection.getConnection()) {
			startTransaction(conn);

			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				try (ResultSet rs = stmt.executeQuery()) {
					List<Recipe> recipes = new LinkedList<>();

					while (rs.next()) {
						recipes.add(extract(rs, Recipe.class));
					}

					return recipes;
				}
			} catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
			}

		} catch (SQLException e) {
			throw new DbException(e);
		}
	}

	public Optional<Recipe> fetchRecipeById(Integer recipeId) {
		String sql = "SELECT * FROM " + RECIPE_TABLE + " WHERE recipe_id = ?";

		try (Connection conn = DbConnection.getConnection()) {
			startTransaction(conn);

			try {
				Recipe recipe = null;

				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					setParameter(stmt, 1, recipeId, Integer.class);

					try (ResultSet rs = stmt.executeQuery()) {
						if (rs.next()) {
							recipe = extract(rs, Recipe.class);
						}
					}
				}
				// If recipe is found i.e. not null
				if (Objects.nonNull(recipe)) {

					// Get ingredients
					recipe.getIngredients().addAll(fetchRecipeIngredients(conn, recipeId));

					// Get steps
					recipe.getSteps().addAll(fetchRecipeSteps(conn, recipeId));

					// Get categories
					recipe.getCategories().addAll(fetchRecipeCategories(conn, recipeId));
				}

				return Optional.ofNullable(recipe);
			} catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
			}

		} catch (SQLException e) {
			throw new DbException(e);
		}
	}

	private List<Category> fetchRecipeCategories(Connection conn, Integer recipeId) throws SQLException {
		// @formatter:off
		String sql = ""
				+ "SELECT c.* "
				+ "FROM " + RECIPE_CATEGORY_TABLE + " rc "
				+ "JOIN " + CATEGORY_TABLE + " c USING (category_id) "
				+ "WHERE recipe_id = ? "
				+ "ORDER BY c.category_name";
		// @formatter:on

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			setParameter(stmt, 1, recipeId, Integer.class);

			try (ResultSet rs = stmt.executeQuery()) {
				List<Category> categories = new LinkedList<>();

				while (rs.next()) {
					categories.add(extract(rs, Category.class));
				}

				return categories;
			}
		}
	}

	private List<Step> fetchRecipeSteps(Connection conn, Integer recipeId) throws SQLException {
		String sql = "SELECT * FROM " + STEP_TABLE + " s WHERE s.recipe_id = ?";

		// Don't need another connection because still using the same connection and
		// transaction created earlier
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			setParameter(stmt, 1, recipeId, Integer.class);

			try (ResultSet rs = stmt.executeQuery()) {
				List<Step> steps = new LinkedList<>();

				// While there is a row, fetch all steps
				while (rs.next()) {
					steps.add(extract(rs, Step.class));
				}

				return steps;
			}
		}
	}

	private List<Ingredient> fetchRecipeIngredients(Connection conn, Integer recipeId) throws SQLException {
		// @formatter:off
		String sql = ""
				+ "SELECT i.*, u.unit_name_singular, u.unit_name_plural "
				+ "FROM " + INGREDIENT_TABLE + " i"
				+ " LEFT JOIN " + UNIT_TABLE + " u USING (unit_id) "
				+ "WHERE recipe_id = ? "
				+ "ORDER BY i.ingredient_order";
		// @formatter:on

		// Don't need another connection because still using the same connection created
		// earlier
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			setParameter(stmt, 1, recipeId, Integer.class);

			try (ResultSet rs = stmt.executeQuery()) {
				List<Ingredient> ingredients = new LinkedList<>();

				while (rs.next()) {
					// Get ingredient
					Ingredient ingredient = extract(rs, Ingredient.class);
					// Get ingredient unit
					Unit unit = extract(rs, Unit.class);

					// Add the unit to the ingredient
					ingredient.setUnit(unit);
					// Add the ingredient with the unit to the list
					ingredients.add(ingredient);
				}

				return ingredients;
			}
		}

	}

	public void executeBatch(List<String> sqlBatch) {
		try (Connection conn = DbConnection.getConnection()) {
			startTransaction(conn);

			try (Statement stmt = conn.createStatement()) {
				for (String sql : sqlBatch) {
					stmt.addBatch(sql);
				}

				stmt.executeBatch();
				commitTransaction(conn);
			} catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
			}
		} catch (SQLException e) {
			throw new DbException(e);
		}
	}

	public List<Unit> fetchAllUnits() {
		String sql = "SELECT * FROM " + UNIT_TABLE + " ORDER BY unit_name_singular";

		try (Connection conn = DbConnection.getConnection()) {
			startTransaction(conn);

			try (PreparedStatement stmt = conn.prepareStatement(sql)) {

				try (ResultSet rs = stmt.executeQuery()) {
					List<Unit> units = new LinkedList<>();

					while (rs.next()) {
						units.add(extract(rs, Unit.class));
					}
					return units;
				}
			} catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
			}

		} catch (SQLException e) {
			throw new DbException(e);
		}
	}

	public void addIngredientToRecipe(Ingredient ingredient) {

		String sql = "INSERT INTO " + INGREDIENT_TABLE
				+ " (recipe_id, unit_id, ingredient_name, instruction, ingredient_order, amount) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = DbConnection.getConnection()) {
			startTransaction(conn);

			// Count the number of child (ingredient) rows and return one
			// If count is 0, return 1, indicating the ingredient should be in order
			// position 1
			try {
				// Convenience method from base class to get next insertion order position
				Integer order = getNextSequenceNumber(conn, ingredient.getRecipeId(), INGREDIENT_TABLE, "recipe_id");
				
				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					setParameter(stmt, 1, ingredient.getRecipeId(), Integer.class);
					setParameter(stmt, 2, ingredient.getUnit().getUnitId(), Integer.class);
					setParameter(stmt, 3, ingredient.getIngredientName(), String.class);
					setParameter(stmt, 4, ingredient.getInstruction(), String.class);
					setParameter(stmt, 5, order, Integer.class);
					setParameter(stmt, 6, ingredient.getAmount(), BigDecimal.class);
					
					stmt.executeUpdate();
					commitTransaction(conn);
				}
			} catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
			}
		} catch (SQLException e) {
			throw new DbException(e);
		}
	}
}
