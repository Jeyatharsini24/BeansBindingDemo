package com.jeya.beansbinding.sortingorder.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Color;

public class SearchInvestigationPanel extends JPanel {
	private JTextField textField;
	public SearchInvestigationPanel() {
		init();
	}

	public String getText()
	{
		return (textField != null)? textField.getText() : "";
	}
	
	private void init() {
		setBackground(Color.ORANGE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSearch = new JLabel("Search");
		GridBagConstraints gbc_lblSearch = new GridBagConstraints();
		gbc_lblSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSearch.insets = new Insets(0, 0, 0, 5);
		gbc_lblSearch.anchor = GridBagConstraints.WEST;
		gbc_lblSearch.gridx = 0;
		gbc_lblSearch.gridy = 0;
		add(lblSearch, gbc_lblSearch);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 5, 0, 0);
		gbc_textField.gridwidth = 6;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
	}
}