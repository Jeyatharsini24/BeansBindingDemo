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

public class SortingOrderSearchPanel extends JPanel {
	private JComboBox<Unit> comboBox;
	private SortingOrderSearchPanelModel sortingOrderSearchPanelModel;
	private JTree tree = new JTree();

	public SortingOrderSearchPanel() {
		init();
	}

	public void initBinding() {
		/* It binds the list of units to comboBox.
		 Unit's toString() value will be shown in comboBox.
		 So toString() method of Object class has been overridden in Unit class in order to show the unit name.*/
		JComboBoxBinding<Unit, List<Unit>, JComboBox> jComboBinding = SwingBindings
				.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ,
						Dummy.getUnits(), getComboBox());
		jComboBinding.bind();

		/**
		   (Based on the property name framework create method name and it invokes method using reflection)
		   It works as follows:
		   
		   JComboBox's selectedItem is bound with SortingOrderSearchPanelModel's selectedUnit
		   Source: JComboBox
		   Target: SortingOrderSearchPanelModel
		   Source Property: JComboBox's selectedItem
		   Target Property: SortingOrderSearchPanelModel's selectedUnit
		   
		   Beans Binding invokes JComboBox's getSelectedItem() method to get the value to bind.
		   The method to invoke is found by property name and Java naming convention for getter methods.
		   Since property name is "selectedItem", it looks for getSelectedItem()
		   inside JComboBox class.
		   
		   (Note: 
		   1. Property name should not start with capital letter.
		   2. Attribute name of class can be some other name: it can differ from property name. But getter method should be
		    get<Property name starts with capital letter>() to be identified by binding.
		   3. Value from source is assigned to value to target. So it should be a valid assignment.
		    Otherwise ClassCastException will occur in run time)
		   
		   value from getSelectedItem() will be bound with SortingOrderSearchPanelModel's Unit.
		   Binding invokes setSelectedUnit() method from SortingOrderSearchPanelModel class since property name is
		   "selectedUnit".
		 */
		// BeanProperty<Source type, Object type to be bound from Source type>
		// comboBoxSelectedItemProperty = BeanProperty.create(<property to be bound>);
		BeanProperty<JComboBox, Unit> comboBoxSelectedItemProperty = BeanProperty
				.create("selectedItem");
		
		//	BeanProperty<Target type, Object type to be bound from Target type>
		//	sortingOrderSearchPanelModelSelectedUnitProperty = BeanProperty
		//		.create(<property to be bound>);
		BeanProperty<SortingOrderSearchPanelModel, Unit> sortingOrderSearchPanelModelSelectedUnitProperty = BeanProperty
				.create("selectedUnit");
		//	AutoBinding<Source type, Object type to be bound from Source type, 
		// Target type, Object type to be bound from Target type>
		// autoBinding = Bindings
		// .createAutoBinding(AutoBinding.UpdateStrategy.READ, getComboBox(),
		// comboBoxSelectedItemProperty, sortingOrderSearchPanelModel,
		// sortingOrderSearchPanelModelSelectedUnitProperty);
		AutoBinding<JComboBox, Unit, SortingOrderSearchPanelModel, Unit> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ,
						getComboBox(), comboBoxSelectedItemProperty,
						sortingOrderSearchPanelModel,
						sortingOrderSearchPanelModelSelectedUnitProperty);
		autoBinding.bind();
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
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

		tree.setBackground(Color.PINK);
		tree.setCellRenderer(new SortingOrderCellRenderer());
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
		tree.setModel(sortingOrderSearchPanelModel.getSortingOrderTreeModel());
	}
}
