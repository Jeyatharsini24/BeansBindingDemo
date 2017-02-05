package com.jeya.beansbinding.sortingorder.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTree;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;

import com.jeya.beansbinding.sortingorder.data.Unit;
import com.jeya.beansbinding.sortingorder.model.InvestigationsPanelModel;
import com.jeya.beansbinding.sortingorder.model.SortingOrderPanelModel;
import com.jeya.beansbinding.sortingorder.model.SortingOrderSearchPanelModel;

public class InvestigationsPanel extends JPanel {
	private SearchInvestigationPanel searchInvestigationPanel;
	private InvestigationsPanelModel investigationsPanelModel;
	private JTree tree = new JTree();

	public InvestigationsPanel() {
		init();
	}

	private SearchInvestigationPanel getSearchInvestigationPanel() {
		if (searchInvestigationPanel == null) {
			searchInvestigationPanel = new SearchInvestigationPanel();
		}
		return searchInvestigationPanel;
	}

	private void init() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);
		GridBagConstraints gbc_searchInvestigationPanel = new GridBagConstraints();
		gbc_searchInvestigationPanel.weightx = 1.0;
		gbc_searchInvestigationPanel.insets = new Insets(0, 0, 5, 0);
		gbc_searchInvestigationPanel.gridwidth = 0;
		gbc_searchInvestigationPanel.anchor = GridBagConstraints.WEST;
		gbc_searchInvestigationPanel.gridy = 0;
		gbc_searchInvestigationPanel.gridx = 0;
		gbc_searchInvestigationPanel.fill = GridBagConstraints.HORIZONTAL;
		add(getSearchInvestigationPanel(), gbc_searchInvestigationPanel);

		JButton btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAdd.gridwidth = 0;
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 4;
		add(btnAdd, gbc_btnAdd);

		JButton btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.anchor = GridBagConstraints.EAST;
		gbc_btnRemove.gridwidth = 0;
		gbc_btnRemove.gridx = 4;
		gbc_btnRemove.gridy = 5;
		add(btnRemove, gbc_btnRemove);

		tree.setBackground(Color.ORANGE);
		tree.setRootVisible(false);
		tree.setCellRenderer(new InvestigationCellRenderer());
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.gridwidth = 0;
		gbc_tree.weightx = 0.7;
		gbc_tree.anchor = GridBagConstraints.WEST;
		gbc_tree.gridheight = 10;
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 1;
		add(tree, gbc_tree);
	}

	public void setModel(InvestigationsPanelModel investigationsPanelModel) {
		this.investigationsPanelModel = investigationsPanelModel;
		tree.setModel(investigationsPanelModel.getTreeModel());
	}

	public void initBinding() {
		// bind selected unit with tree
		BeanProperty<SortingOrderSearchPanelModel, Unit> sortingOrderSearchPanelModelSelectedUnitProperty = BeanProperty
				.create("selectedUnit");
		BeanProperty<InvestigationsPanelModel, Unit> investigationsPanelModelSelectedUnitProperty = BeanProperty
				.create("investigationTreeBySelectedUnit");
		AutoBinding<SortingOrderSearchPanelModel, Unit, InvestigationsPanelModel, Unit> selUnitInvTreeBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ,
						investigationsPanelModel.getParentPanel()
								.getSortingOrderSearchPanelModel(),
						sortingOrderSearchPanelModelSelectedUnitProperty,
						investigationsPanelModel,
						investigationsPanelModelSelectedUnitProperty);
		selUnitInvTreeBinding.bind();
		
		// bind searched text with tree
		BeanProperty<SearchInvestigationPanel, String> SearchInvestigationPanelSearchedTextProperty = BeanProperty
				.create("text");
		BeanProperty<InvestigationsPanelModel, String> investigationsPanelModelSearchedTextProperty = BeanProperty
				.create("searchedText");
		AutoBinding<SearchInvestigationPanel, String, InvestigationsPanelModel, String> filteredTextInvTreeBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ,
						getSearchInvestigationPanel(),
						SearchInvestigationPanelSearchedTextProperty,
						investigationsPanelModel,
						investigationsPanelModelSearchedTextProperty);
		filteredTextInvTreeBinding.bind();
	}
}