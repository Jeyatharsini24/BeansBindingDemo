package com.jeya.beansbinding.sortingorder.view;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.jeya.beansbinding.sortingorder.data.SortingOrder;

public class SortingOrderCellRenderer extends DefaultTreeCellRenderer {

	public SortingOrderCellRenderer() {
		// Icon initialization
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, selected, expanded,
				leaf, row, hasFocus);

		DefaultMutableTreeNode nodeToRender = (DefaultMutableTreeNode) (value);
		Object nodeObject = nodeToRender.getUserObject();

		if (nodeObject instanceof SortingOrder) {
			SortingOrder data = (SortingOrder) nodeObject;
			setText(data.getSortingOrderName());
		}
		/*if (!((DefaultMutableTreeNode) value).isRoot()) {
			this.setIcon(<icon>);
		} else {
			this.setIcon(<icon>);
		}*/
		return this;
	}
}
