package com.cg.pos.staticdb;

import java.util.ArrayList;

import com.cg.pos.dto.StoreDetails;

public class StoreDetailsStaticDb {
	private  ArrayList<StoreDetails> storeList = new ArrayList<StoreDetails>();

	public  ArrayList<StoreDetails> getCartList() {
		return storeList;
	}

	public ArrayList<StoreDetails> initStore() {
		storeList.add(new StoreDetails(101, "rominos", "navi mumbai", "9414585108", "sagar"));
		storeList.add(new StoreDetails(101, "pizzacap", "mumbai", "1234567890", "nagar"));
		return storeList;
	}

}
//https://dzone.com/articles/building-simple-data-access-layer-using-jdbc