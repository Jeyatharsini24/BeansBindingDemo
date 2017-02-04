package com.jeya.beansbinding.sortingorder.data;

public class Unit {
	private String unitName;
	
	public Unit()
	{
		unitName = "";
	}
	
	public Unit(String unitName)
	{
		this.unitName = unitName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public String toString()
	{
		return unitName;
	}
}