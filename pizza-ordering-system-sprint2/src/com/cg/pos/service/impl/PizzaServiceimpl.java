package com.cg.pos.service.impl;

import java.util.ArrayList;

import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.StoreNameException;
import com.cg.pos.service.PizzaService;
import com.cg.pos.staticdb.PizzaDetailsStaticDb;
import com.cg.pos.staticdb.StoreDetailsStaticDb;
import com.cg.pos.utility.StoreNameValidatior;;;

/**
 * class to View pizza in a store
 * 
 * @author prakhar
 *
 */
public class PizzaServiceimpl implements PizzaService {

	@Override
	/*
	 * method to show pizza details of a store
	 * 
	 */
	public boolean viewPizza(String storeName) throws StoreNameException {

		StoreNameValidatior valid = new StoreNameValidatior();
		boolean flag = valid.isValidStoreName(storeName);
		if (flag == true) {

			if (PizzaDetailsStaticDb.getPizzaMap().containsKey(storeName)) {
				System.out.println(PizzaDetailsStaticDb.getPizzaMap().get(storeName));
				return true;
			} else {

				return false;
			}
		}
		return true;
	}

	/*
	 * database initialize
	 * 
	 */
	public void init() {

		PizzaDetailsStaticDb pizza = null;

		if (null == pizza) {
			pizza = new PizzaDetailsStaticDb();
		}
		pizza.init();
	}

	/*
	 * database initialize
	 * 
	 */
	public ArrayList<StoreDetails> initStore() {

		StoreDetailsStaticDb store = null;
		if (store == null) {
			store = new StoreDetailsStaticDb();
		}

		ArrayList<StoreDetails> storeList = new ArrayList<StoreDetails>();
		storeList = store.initStore();
		return storeList;
	}

	@Override
	public ArrayList<PizzaDetails> modifyName(int id, String name) {

		return null;
	}

	@Override
	public ArrayList<PizzaDetails> modifyQuantity(int id, int quantity) {

		return null;
	}

	@Override
	public ArrayList<PizzaDetails> modifyCost(int id, double cost) {

		return null;
	}

	@Override
	public String modifyAddOns(int id, String addOns) {

		return null;
	}

	@Override
	public ArrayList<PizzaDetails> deletePizzaDetails(int pizzaId) {

		return null;
	}

	@Override
	public String add(PizzaDetails pizza) {

		return null;
	}

}
