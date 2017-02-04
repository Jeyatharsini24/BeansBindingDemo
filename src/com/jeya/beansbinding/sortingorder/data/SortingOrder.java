package com.jeya.beansbinding.sortingorder.data;

import java.util.ArrayList;
import java.util.List;

public class SortingOrder{
	private	List<Investigation>investigationList;
	private String unitName;
	private String sortingOrderName;
	
	public SortingOrder()
	{
		investigationList = new ArrayList();
		unitName = "unitName";
	}
	
	public SortingOrder(String sortingOrderName, List<Investigation>investigationList, String unitName)
	{
		this.sortingOrderName = sortingOrderName;
		this.investigationList = investigationList;
		this.unitName = unitName;
	}
	
	public String getSortingOrderName() {
		return sortingOrderName;
	}

	public void setSortingOrderName(String sortingOrderName) {
		this.sortingOrderName = sortingOrderName;
	}

	public List<Investigation> getInvestigationList() {
		return investigationList;
	}

	public void setInvestigationList(List<Investigation> investigationList) {
		this.investigationList = investigationList;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
}