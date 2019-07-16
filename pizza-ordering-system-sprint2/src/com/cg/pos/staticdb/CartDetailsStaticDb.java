package com.cg.pos.staticdb;

import java.util.ArrayList;

import com.cg.pos.dto.CartDetails;

public class CartDetailsStaticDb {

	private static ArrayList<CartDetails> cartList = new ArrayList<CartDetails>();

	public static ArrayList<CartDetails> getCartList() {
		return cartList;
	}

}
