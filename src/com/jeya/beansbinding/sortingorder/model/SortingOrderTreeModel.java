package com.jeya.beansbinding.sortingorder.model;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.jeya.beansbinding.dataprovider.Dummy;
import com.jeya.beansbinding.sortingorder.data.SortingOrder;
import com.jeya.beansbinding.sortingorder.data.Unit;

public class SortingOrderTreeModel extends DefaultTreeModel{
	private List<SortingOrder>sortingOrders;
	
	public SortingOrderTreeModel(TreeNode root) {
		super(root);
	}
	public void buildSortingOrderTree(Unit selectedUnit) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Sorting Orders");
		sortingOrders = Dummy.getSortingOrdersForUnit(selectedUnit.getUnitName());
		if(sortingOrders.size() > 0)
		{
			for(int i = 0; i < sortingOrders.size(); i++)
			{
				root.add(new DefaultMutableTreeNode(sortingOrders.get(i)));
			}
			setRoot(root);
		}
		else
		{
			setRoot(new DefaultMutableTreeNode("No Sorting Orders"));
		}
	}
}
