package com.cg.pos.service;

import java.util.ArrayList;

import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.StoreNameException;

public interface PizzaService {
	/*
	 * Pizza Service Method
	 */
	public boolean viewPizza(String storeName) throws StoreNameException;
	ArrayList<PizzaDetails> modifyName(int id,String name) ;
	ArrayList<PizzaDetails> modifyQuantity(int id,int quantity) ;
	ArrayList<PizzaDetails> modifyCost(int id,double cost);
	String modifyAddOns(int id,String addOns) ;
	ArrayList<PizzaDetails> deletePizzaDetails(int pizzaId) ;
	String add(PizzaDetails pizza) ;
	public void init();
	public ArrayList<StoreDetails> initStore();
	}
