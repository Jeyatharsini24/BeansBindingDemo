package com.jeya.beansbinding.sortingorder.model;

import com.jeya.beansbinding.sortingorder.data.Unit;


public class InvestigationsPanelModel extends AbstractModelObject{
	private SortingOrderPanelModel parentPanel;
	private String searchedText = "";
	private InvestigationTreeModel treeModel;
	
	public InvestigationsPanelModel()
	{
		treeModel = new InvestigationTreeModel(null);
	}
	
	public InvestigationTreeModel getTreeModel() {
		return treeModel;
	}

	public SortingOrderPanelModel getParentPanel() {
		return parentPanel;
	}

	public void setParentPanel(SortingOrderPanelModel parentPanel) {
		this.parentPanel = parentPanel;
	}

	public String getSearchedText() {
		return searchedText;
	}

	public void setSearchedText(String newSearchedText) {
		String oldValue = searchedText;
		this.searchedText = newSearchedText;
		System.out.println(newSearchedText);
		buildFilteredInvestigationTree(newSearchedText);
		firePropertyChange("searchedText", oldValue, newSearchedText);
	}
	
	private void buildFilteredInvestigationTree(String newSearchedText) {
		treeModel.buildFilteredInvestigationTree(newSearchedText);
	}

	public void setInvestigationTreeBySelectedUnit(Unit selectedUnit) {
		buildInvestigationTree(selectedUnit);
	}

	private void buildInvestigationTree(Unit selectedUnit) {
		treeModel.buildInvestigationTree(selectedUnit);
	}
}