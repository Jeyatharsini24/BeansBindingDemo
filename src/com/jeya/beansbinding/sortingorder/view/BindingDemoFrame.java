package com.jeya.beansbinding.sortingorder.view;

import javax.swing.JFrame;

public class BindingDemoFrame extends JFrame{
	public BindingDemoFrame()
	{
		super("Binding Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		SortingOrderPanel sortingOrderPanel = new SortingOrderPanel();
		getContentPane().add(sortingOrderPanel);
		setVisible(true);
	}
}