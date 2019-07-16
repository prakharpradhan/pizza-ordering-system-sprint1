package com.cg.pos.service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import com.cg.pos.dto.CartDetails;
import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.exceptions.InvalidCartException;
import com.cg.pos.exceptions.NotFoundIdException;
import com.cg.pos.service.CartService;
import com.cg.pos.staticdb.CartDetailsStaticDb;
import com.cg.pos.staticdb.PizzaDetailsStaticDb;
import com.cg.pos.utility.CartValidator;

/**
 * cart service add to cart remove cart and confirm order
 * 
 * @author Prakhar
 *
 */
public class CartServiceImpl implements CartService {
	/*
	 * Method to add Item to Cart
	 * 
	 */
	@Override
	public boolean addToCart(int itemId, int qty, String storeName) throws NotFoundIdException {

		double price = 0;
		CartDetails cart = new CartDetails();
		cart.setCartId(cart.getCartId() + 1);
		cart.setDelievryCharges(50);
		cart.setQuantity(qty);
		ArrayList<?> list;
		list = PizzaDetailsStaticDb.getPizzaMap().get(storeName);
		Iterator<?> i = list.iterator();
		while (i.hasNext()) {
			PizzaDetails pdo = (PizzaDetails) i.next();
			if (pdo.getItemId() == itemId) {
				price = pdo.getPrice();
			}
			cart.setRestCharges(qty * price);
			cart.setTotal(cart.getRestCharges() + cart.getDelievryCharges());
			IsIdAvailableValidation(storeName, itemId);
			CartDetailsStaticDb.getCartList().add(cart);
			return true;
		}

		return false;

	}

	/*
	 * Database Check
	 * 
	 */
	public void IsIdAvailableValidation(String storeName, int itemId) throws NotFoundIdException {

		ArrayList<?> list;
		list = PizzaDetailsStaticDb.getPizzaMap().get(storeName);
		Iterator<?> i = list.iterator();
		boolean flag = true;
		while (i.hasNext()) {
			flag = true;
			PizzaDetails pdo = (PizzaDetails) i.next();
			if (pdo.getItemId() == itemId) {
				flag = true;
				break;
			} else {
				flag = false;

			}
		}
		if (!flag) {
			throw new NotFoundIdException("Not Present");
		}

	}

	@Override
	public boolean confirmOrder() {

		return true;
	}

	/*
	 * Method to remove item fSrom cart
	 * 
	 */
	public boolean removeItemFromCart(int cartID) throws InvalidCartException, NotFoundIdException {

		boolean counter = isCartIdAvailable(cartID);
		if (counter) {
			ArrayList<?> list = null;
			list = CartDetailsStaticDb.getCartList();
			Iterator<?> i = list.iterator();

			while (i.hasNext()) {

				CartDetails pdo = (CartDetails) i.next();

				if (pdo.getCartId() == cartID) {

					i.remove();

					break;

				}

			}
		}
		return false;
	}

	/**
	 * Method to add more item to existing cart
	 * 
	 * @throws NotFoundIdException
	 */
	@Override
	public boolean addMore(int id, int qty) throws NotFoundIdException {
		boolean check = isCartIdAvailable(id);
		if (check) {
			ArrayList<?> list = null;

			list = CartDetailsStaticDb.getCartList();
			Iterator<?> i = list.iterator();
			while (i.hasNext()) {
				CartDetails pdo = (CartDetails) i.next();

				if (pdo.getCartId() == id) {
					pdo.setQuantity(pdo.getQuantity() + qty);
					pdo.setRestCharges(pdo.getRestCharges() + (pdo.getQuantity() * pdo.getRestCharges()));
					pdo.setTotal(pdo.getTotal() + pdo.getDelievryCharges() + pdo.getRestCharges());
				}
			}
		}
		return true;
	}

	/*
	 * Database check
	 * 
	 */
	public boolean isCartIdAvailable(int cartId) throws NotFoundIdException {

		ArrayList<?> list = null;

		list = CartDetailsStaticDb.getCartList();
		Iterator<?> i = list.iterator();

		boolean flag = true;
		while (i.hasNext()) {
			flag = true;
			CartDetails pdo = (CartDetails) i.next();

			if (pdo.getCartId() == cartId) {

				flag = true;
				break;

			} else {
				flag = false;

			}
		}
		if (!flag) {
			throw new NotFoundIdException("Not Present");
		} else
			return true;
	}

}
