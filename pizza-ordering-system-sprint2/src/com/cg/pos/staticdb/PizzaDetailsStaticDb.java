package com.cg.pos.staticdb;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.pos.dto.PizzaDetails;

public class PizzaDetailsStaticDb {

	private ArrayList<PizzaDetails> pizzaList = new ArrayList<PizzaDetails>();
	private ArrayList<PizzaDetails> pizzaList2 = new ArrayList<PizzaDetails>();
	@SuppressWarnings("rawtypes")
	private static HashMap<String, ArrayList> pizzaMap = new HashMap<String, ArrayList>();

	@SuppressWarnings("rawtypes")
	public static HashMap<String, ArrayList> getPizzaMap() {
		return pizzaMap;
	}

	PizzaDetails pizza = new PizzaDetails("rominos", 101, 100, 450);
	PizzaDetails pizza1 = new PizzaDetails("rominos", 102, 100, 102);
	PizzaDetails pizza2 = new PizzaDetails("pizzacap", 102, 100, 102);

	public void init() {

		pizzaList.add(pizza);
		pizzaList.add(pizza1);
		pizzaList2.add(pizza2);
		pizzaMap.put(pizza.getStoreName(), pizzaList);
		pizzaMap.put(pizza2.getStoreName(), pizzaList2);
	}
}
