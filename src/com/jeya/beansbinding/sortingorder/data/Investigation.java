package com.jeya.beansbinding.sortingorder.data;

public class Investigation {
	private String investigationName;
	private String unitName;
	
	public Investigation()
	{
		investigationName = "investigationName";
		unitName = "unitName";
	}
	
	public Investigation(String investigationName, String unitName)
	{
		this.investigationName = investigationName;
		this.unitName = unitName;
	}

	public String getInvestigationName() {
		return investigationName;
	}

	public void setInvestigationName(String investigationName) {
		this.investigationName = investigationName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
}
