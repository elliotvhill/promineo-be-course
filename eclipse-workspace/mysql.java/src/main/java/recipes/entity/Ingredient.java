package recipes.entity;

import java.math.BigDecimal;
import java.util.Objects;

import provided.entity.EntityBase;

public class Ingredient extends EntityBase {
	private Integer ingredientId;
	private Integer recipeId;
	private Unit unit;
	private String ingredientName;
	private String instruction;
	private Integer ingredientOrder;
	private BigDecimal amount;

	/**
	 * @return the ingredientId
	 */
	public Integer getIngredientId() {
		return ingredientId;
	}

	/**
	 * @param ingredientId the ingredientId to set
	 */
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
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
	 * @return the unitId
	 */
	public Unit getUnitId() {
		return unit;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(Unit unitId) {
		this.unit = unitId;
	}

	/**
	 * @return the ingredientName
	 */
	public String getIngredientName() {
		return ingredientName;
	}

	/**
	 * @param ingredientName the ingredientName to set
	 */
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	/**
	 * @return the ingredientOrder
	 */
	public Integer getIngredientOrder() {
		return ingredientOrder;
	}

	/**
	 * @param ingredientOrder the ingredientOrder to set
	 */
	public void setIngredientOrder(Integer ingredientOrder) {
		this.ingredientOrder = ingredientOrder;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/*
	 * Print something like: ID=5 1/4 cup carrots, thinly sliced.
	 */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();

		b.append("ID=").append(ingredientId).append(": ");
		b.append(toFraction(amount));

		if (Objects.nonNull(unit) && Objects.nonNull(unit.getUnitId())) {
			String singular = unit.getUnitNameSingular();
			String plural = unit.getUnitNamePlural();

			// Select either singular or plural unit name by comparing BigDecimal with 1
			String word = amount.compareTo(BigDecimal.ONE) > 0 ? plural : singular;
			b.append(word).append(" ");
		}

		b.append(ingredientName);

		if (Objects.nonNull(instruction)) {
			b.append(", ").append(instruction);
		}

		return b.toString();
	}

}
