package com.jeya.beansbinding.sortingorder.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.jeya.beansbinding.dataprovider.Dummy;
import com.jeya.beansbinding.sortingorder.data.Investigation;
import com.jeya.beansbinding.sortingorder.data.Unit;

public class InvestigationTreeModel extends DefaultTreeModel{
	private List<Investigation>investigations;

	public InvestigationTreeModel(TreeNode root) {
		super(root);
	}
	
	private void buildInvestigationTree(List<Investigation>investigations)
	{
		this.investigations = investigations;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Investigations");
		if(investigations.size() > 0)
		{
			for(int i = 0; i < investigations.size(); i++)
			{
				root.add(new DefaultMutableTreeNode(investigations.get(i)));
			}
			setRoot(root);
		}
		else
		{
			setRoot(new DefaultMutableTreeNode("No investigations"));
		}
	}

	public void buildInvestigationTree(Unit selectedUnit) {
		buildInvestigationTree(Dummy.getInvestigations(selectedUnit.getUnitName()));
	}

	public void buildFilteredInvestigationTree(String newSearchedText) {
		buildInvestigationTree(filterInvestigations(newSearchedText));
	}

	private List<Investigation> filterInvestigations(String newSearchedText) {
		List<Investigation>filteredInvestigations = new ArrayList<Investigation>();
		for(int i = 0; i < investigations.size(); i++)
		{
			if(investigations.get(i).getInvestigationName().contains(newSearchedText))
			{
				filteredInvestigations.add(investigations.get(i));
			}
		}
		return filteredInvestigations;
	}
}
