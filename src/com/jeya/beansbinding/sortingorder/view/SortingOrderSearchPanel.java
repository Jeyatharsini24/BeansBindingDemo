package com.jeya.beansbinding.sortingorder.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

import com.jeya.beansbinding.dataprovider.Dummy;
import com.jeya.beansbinding.sortingorder.data.Unit;
import com.jeya.beansbinding.sortingorder.model.SortingOrderSearchPanelModel;

public class SortingOrderSearchPanel extends JPanel{
	private JComboBox<Unit> comboBox;
	private SortingOrderSearchPanelModel sortingOrderSearchPanelModel;
	public SortingOrderSearchPanel() {
		init();
	}
	
	public void initBinding()
	{
		// It binds the list of units to comboBox : Bind View to Model ??
		// Unit's toString() value will be shown in comboBox
		JComboBoxBinding<Unit, List<Unit>, JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, Dummy.getUnits(), getComboBox());
		jComboBinding.bind();
		
		BeanProperty<JComboBox<Unit>, Unit> comboBoxSelectedItemProperty = BeanProperty.create("selectedItem");
		BeanProperty<SortingOrderSearchPanelModel, Unit> sortingOrderSearchPanelModelSelectedUnitProperty = BeanProperty.create("selectedUnit");
		AutoBinding<JComboBox<Unit>, Unit, SortingOrderSearchPanelModel, Unit> autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, getComboBox(), comboBoxSelectedItemProperty, sortingOrderSearchPanelModel.getSelectedUnit(), sortingOrderSearchPanelModelSelectedUnitProperty);
		autoBinding.bind();
	}

	private JComboBox<Unit> getComboBox() {
		if(comboBox == null)
		{
			comboBox = new JComboBox<Unit>();
		}
		return comboBox;
	}

	private void init() {
		setBackground(Color.PINK);
		setLayout(new GridBagLayout());
		
		JLabel lblUnit = new JLabel("Unit");
		GridBagConstraints gbc_lblUnit = new GridBagConstraints();
		gbc_lblUnit.weightx = 0.3;
		gbc_lblUnit.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUnit.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit.anchor = GridBagConstraints.WEST;
		gbc_lblUnit.gridx = 0;
		gbc_lblUnit.gridy = 0;
		add(lblUnit, gbc_lblUnit);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.anchor = GridBagConstraints.EAST;
		gbc_comboBox.weightx = 0.7;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		add(getComboBox(), gbc_comboBox);
		
		JTree tree = new JTree();
		tree.setBackground(Color.PINK);
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.gridwidth = 3;
		gbc_tree.weightx = 1.0;
		gbc_tree.weighty = 1.0;
		gbc_tree.gridheight = 0;
		gbc_tree.anchor = GridBagConstraints.WEST;
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 1;
		add(tree, gbc_tree);
	}

	public void setModel(
			SortingOrderSearchPanelModel sortingOrderSearchPanelModel) {
		this.sortingOrderSearchPanelModel = sortingOrderSearchPanelModel;
	}
}