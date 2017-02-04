package com.jeya.beansbinding.sortingorder.model;

import com.jeya.beansbinding.sortingorder.data.Unit;

public class SortingOrderSearchPanelModel extends AbstractModelObject{
	private Unit selectedUnit = new Unit("");
	
	public SortingOrderSearchPanelModel()
	{
		
	}

	public Unit getSelectedUnit() {
		return selectedUnit;
	}

	//selectedUnit in parameter is used as newSelectedUnit. Otherwise, old value and new value will be same
	public void setSelectedUnit(Unit newSelectedUnit) {
		Unit oldValue = selectedUnit;
		this.selectedUnit = newSelectedUnit;
		System.out.println(newSelectedUnit);
		firePropertyChange("selectedUnit", oldValue, selectedUnit);
	}
}