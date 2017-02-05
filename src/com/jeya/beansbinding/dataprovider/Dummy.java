package com.jeya.beansbinding.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeya.beansbinding.sortingorder.data.Investigation;
import com.jeya.beansbinding.sortingorder.data.SortingOrder;
import com.jeya.beansbinding.sortingorder.data.Unit;

public class Dummy {
	private static List<Unit>units = new ArrayList();
	private static Map<String, List<SortingOrder>>sortingOrders = new HashMap();
	
	private static void setUnits()
	{
		for(int i = 0; i < 6; i++)
		{
			units.add(new Unit("Unit Name: " + i));
		}
	}
	
	public static List<Investigation> getInvestigations(String unitName)
	{
		List<Investigation>investigations = new ArrayList<Investigation>();
		List<SortingOrder>sortingOrderForAUnit = sortingOrders.get(unitName);
		for(int i = 0; i < sortingOrderForAUnit.size(); i++)
		{
			List<Investigation>investigationForASortingOrder = sortingOrderForAUnit.get(i).getInvestigationList();
			for(int j = 0; j < investigationForASortingOrder.size(); j++)
			{
				// can check for duplicate
				investigations.add(investigationForASortingOrder.get(j));
			}
		}
		return investigations;
	}

	public static List<Unit> getUnits()
	{
		setUnits();
		return units;
	}
	
	private static void setSortingOrders()
	{
		int l = 0;
		for(int i = 0; i < 6; i++)
		{
			List<SortingOrder>sortingOrderList = new ArrayList();
			for(int j = 0; j < 2; j++)
			{
				SortingOrder sortingOrder = new SortingOrder();
				List<Investigation>investigationList = new ArrayList();
				for(int k = 0; k < 3; k++)
				{
					investigationList.add(new Investigation("Investigation: " +i+l+k, "Unit Name: " + i));
				}
				sortingOrder.setSortingOrderName("Sorting Order: " + l);
				sortingOrder.setInvestigationList(investigationList);
				sortingOrder.setUnitName("Unit Name: " + i);
				sortingOrderList.add(sortingOrder);
				l++;
			}
			sortingOrders.put("Unit Name: " + i, sortingOrderList);
		}
	}
	
	public static List<SortingOrder> getSortingOrdersForUnit(String unitName)
	{
		setSortingOrders();
		return sortingOrders.get(unitName);
	}
}