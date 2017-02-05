package com.jeya.beansbinding.sortingorder.model;

public class SortingOrderPanelModel {
	private SortingOrderSearchPanelModel sortingOrderSearchPanelModel = new SortingOrderSearchPanelModel();
	private InvestigationsPanelModel investigationsPanelModel = new InvestigationsPanelModel();
	
	public SortingOrderPanelModel()
	{
		sortingOrderSearchPanelModel.setParentModel(this);
		investigationsPanelModel.setParentPanel(this);
	}

	public SortingOrderSearchPanelModel getSortingOrderSearchPanelModel() {
		return sortingOrderSearchPanelModel;
	}

	public InvestigationsPanelModel getInvestigationsPanelModel() {
		return investigationsPanelModel;
	}
}