package recipes.entity;

public class Step {
	private Integer stepId;
	private Integer recipeId;
	private Integer stepOrder;
	private String stepText;
	/**
	 * @return the stepId
	 */
	public Integer getStepId() {
		return stepId;
	}
	/**
	 * @param stepId the stepId to set
	 */
	public void setStepId(Integer stepId) {
		this.stepId = stepId;
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
	 * @return the stepOrder
	 */
	public Integer getStepOrder() {
		return stepOrder;
	}
	/**
	 * @param stepOrder the stepOrder to set
	 */
	public void setStepOrder(Integer stepOrder) {
		this.stepOrder = stepOrder;
	}
	/**
	 * @return the stepText
	 */
	public String getStepText() {
		return stepText;
	}
	/**
	 * @param stepText the stepText to set
	 */
	public void setStepText(String stepText) {
		this.stepText = stepText;
	}
	@Override
	public String toString() {
		return "ID=" + stepId + ", stepText=" + stepText;
	}

}
