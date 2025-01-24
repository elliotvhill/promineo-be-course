package recipes.entity;

public class Unit {
	private Integer unitId;
	private String unitNameSingular;
	private String unitNamePlural;

	/**
	 * @return the unitId
	 */
	public Integer getUnitId() {
		return unitId;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return the unitNameSingular
	 */
	public String getUnitNameSingular() {
		return unitNameSingular;
	}

	/**
	 * @param unitNameSingular the unitNameSingular to set
	 */
	public void setUnitNameSingular(String unitNameSingular) {
		this.unitNameSingular = unitNameSingular;
	}

	/**
	 * @return the unitNamePlural
	 */
	public String getUnitNamePlural() {
		return unitNamePlural;
	}

	/**
	 * @param unitNamePlural the unitNamePlural to set
	 */
	public void setUnitNamePlural(String unitNamePlural) {
		this.unitNamePlural = unitNamePlural;
	}

	@Override
	public String toString() {
		return "Unit [unitID=" + unitId + ", unitNameSingular=" + unitNameSingular + ", unitNamePlural="
				+ unitNamePlural + "]";
	}

}
