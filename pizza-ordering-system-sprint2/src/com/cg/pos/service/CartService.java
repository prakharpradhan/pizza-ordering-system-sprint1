package com.cg.pos.service;

import com.cg.pos.exceptions.InvalidCartException;
import com.cg.pos.exceptions.ItemIdException;
import com.cg.pos.exceptions.NotFoundIdException;

public interface CartService {
	/*
	 * Cart Service Method
	 */
	public boolean addToCart(int itemId, int qty, String storeName) throws ItemIdException, NotFoundIdException;

	public boolean confirmOrder();

	public boolean removeItemFromCart(int cartID) throws InvalidCartException, NotFoundIdException;

	public boolean addMore(int id, int qty) throws NotFoundIdException;
}
