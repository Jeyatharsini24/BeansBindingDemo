package com.jeya.beansbinding.sortingorder.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Color;

public class SortingOrderEditorPanel extends JPanel {
	public SortingOrderEditorPanel() {
		init();
	}

	private void init() {
		setBackground(new Color(175, 238, 238));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE,
				0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.gridheight = 4;
		gbc_textPane.gridwidth = 6;
		gbc_textPane.anchor = GridBagConstraints.NORTH;
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 0;
		add(textPane, gbc_textPane);

		JButton btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 4;
		add(btnAdd, gbc_btnAdd);

		JButton btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.anchor = GridBagConstraints.EAST;
		gbc_btnRemove.gridwidth = 0;
		gbc_btnRemove.gridx = 3;
		gbc_btnRemove.gridy = 4;
		add(btnRemove, gbc_btnRemove);
	}
}
