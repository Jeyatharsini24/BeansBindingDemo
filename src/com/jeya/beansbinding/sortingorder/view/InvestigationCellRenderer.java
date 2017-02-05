package com.jeya.beansbinding.sortingorder.view;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.jeya.beansbinding.sortingorder.data.Investigation;

public class InvestigationCellRenderer extends DefaultTreeCellRenderer {
	public InvestigationCellRenderer() {
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, selected, expanded,
				leaf, row, hasFocus);

		DefaultMutableTreeNode nodeToRender = (DefaultMutableTreeNode) (value);
		Object nodeObject = nodeToRender.getUserObject();

		if (nodeObject instanceof Investigation) {
			Investigation data = (Investigation) nodeObject;
			setText(data.getInvestigationName());
		}
		return this;
	}
}
