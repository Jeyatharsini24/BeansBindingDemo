package com.jeya.beansbinding.sortingorder.model;

import com.jeya.beansbinding.sortingorder.data.Unit;

public class SortingOrderSearchPanelModel extends AbstractModelObject{
	private Unit selectedUnit = new Unit("");
	private SortingOrderPanelModel parentModel;
	private SortingOrderTreeModel treeModel;
	
	public SortingOrderSearchPanelModel()
	{
		treeModel = new SortingOrderTreeModel(null);
	}
	
	public SortingOrderTreeModel getSortingOrderTreeModel()
	{
		return treeModel;
	}

	public Unit getSelectedUnit() {
		return selectedUnit;
	}

	//selectedUnit in parameter is used as newSelectedUnit. Otherwise, old value and new value will be same
	public void setSelectedUnit(Unit newSelectedUnit) {
		Unit oldValue = selectedUnit;
		this.selectedUnit = newSelectedUnit;
		buildTrees(selectedUnit);
		firePropertyChange("selectedUnit", oldValue, selectedUnit);
	}

	private void buildTrees(Unit selectedUnit) {
		treeModel.buildSortingOrderTree(selectedUnit);
	}

	public SortingOrderPanelModel getParentModel() {
		return parentModel;
	}

	public void setParentModel(SortingOrderPanelModel parentModel) {
		this.parentModel = parentModel;
	}
}