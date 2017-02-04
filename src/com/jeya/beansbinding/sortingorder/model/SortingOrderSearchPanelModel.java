package com.jeya.beansbinding.sortingorder.model;

import com.jeya.beansbinding.sortingorder.data.Unit;

public class SortingOrderSearchPanelModel extends AbstractModelObject{
	private Unit selectedUnit = new Unit("");

	public Unit getSelectedUnit() {
		return selectedUnit;
	}

	public void setSelectedUnit(Unit newSelectedUnit) {
		Unit oldValue = selectedUnit;
		this.selectedUnit = newSelectedUnit;
		firePropertyChange("selectedUnit", oldValue, selectedUnit);
	}
}