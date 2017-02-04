package com.jeya.beansbinding.sortingorder.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.jeya.beansbinding.sortingorder.model.SortingOrderPanelModel;

public class SortingOrderPanel extends JPanel {
	private SortingOrderSearchPanel sortingOrderSearchPanel;
	private InvestigationsPanel investigationsPanel;
	private SortingOrderEditorPanel sortingOrderEditorPanel;
	private SortingOrderPanelModel sortingOrderPanelModel;
	public SortingOrderPanel() {
		addComponents();
		addModels();
		initBindings();
	}

	private void initBindings() {
		sortingOrderSearchPanel.initBinding();
		investigationsPanel.initBinding();
	}

	private void addModels() {
		sortingOrderPanelModel = new SortingOrderPanelModel();
		sortingOrderSearchPanel.setModel(sortingOrderPanelModel.getSortingOrderSearchPanelModel());
		investigationsPanel.setModel(sortingOrderPanelModel.getInvestigationsPanelModel());
	}

	private void addComponents() {
		setBackground(Color.ORANGE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		sortingOrderSearchPanel = new SortingOrderSearchPanel();
		GridBagConstraints gbc_sortingOrderSearchPanel = new GridBagConstraints();
		gbc_sortingOrderSearchPanel.gridwidth = 4;
		gbc_sortingOrderSearchPanel.weightx = 0.3;
		gbc_sortingOrderSearchPanel.gridheight = 0;
		gbc_sortingOrderSearchPanel.weighty = 1.0;
		gbc_sortingOrderSearchPanel.gridy = 0;
		gbc_sortingOrderSearchPanel.gridx = 0;
		gbc_sortingOrderSearchPanel.fill = GridBagConstraints.BOTH;
		gbc_sortingOrderSearchPanel.anchor = GridBagConstraints.WEST;
		add(sortingOrderSearchPanel, gbc_sortingOrderSearchPanel);
		
		investigationsPanel = new InvestigationsPanel();
		GridBagConstraints gbc_investigationsPanel = new GridBagConstraints();
		gbc_investigationsPanel.gridwidth = 7;
		gbc_investigationsPanel.anchor = GridBagConstraints.WEST;
		gbc_investigationsPanel.weightx = 0.5;
		gbc_investigationsPanel.gridheight = 0;
		gbc_investigationsPanel.weighty = 1.0;
		gbc_investigationsPanel.gridy = 0;
		gbc_investigationsPanel.gridx = 4;
		gbc_investigationsPanel.fill = GridBagConstraints.BOTH;
		add(investigationsPanel, gbc_investigationsPanel);
		
		sortingOrderEditorPanel = new SortingOrderEditorPanel();
		GridBagConstraints gbc_sortingOrderEditorPanel = new GridBagConstraints();
		gbc_sortingOrderEditorPanel.gridwidth = 4;
		gbc_sortingOrderEditorPanel.anchor = GridBagConstraints.WEST;
		gbc_sortingOrderEditorPanel.weightx = 0.2;
		gbc_sortingOrderEditorPanel.gridheight = 0;
		gbc_sortingOrderEditorPanel.weighty = 1.0;
		gbc_sortingOrderEditorPanel.gridy = 0;
		gbc_sortingOrderEditorPanel.gridx = 11;
		gbc_sortingOrderEditorPanel.fill = GridBagConstraints.BOTH;
		add(sortingOrderEditorPanel, gbc_sortingOrderEditorPanel);
	}
}
