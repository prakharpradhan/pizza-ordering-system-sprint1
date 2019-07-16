package com.cg.pos.ui;

import java.util.Scanner;

import com.cg.pos.exceptions.InvalidCartException;
import com.cg.pos.exceptions.ItemIdException;
import com.cg.pos.exceptions.ItemQtyException;
import com.cg.pos.exceptions.NotFoundIdException;
import com.cg.pos.service.CartService;
import com.cg.pos.service.impl.CartServiceImpl;
import com.cg.pos.staticdb.CartDetailsStaticDb;
import com.cg.pos.utility.CartValidator;
import com.cg.pos.utility.ItemValidator;

public class AddToCartUi {
	public static void cart(String storeName) {
		String flag = "";
		int itemId = 0;
		int qty = 0;
		ItemValidator isValid = new ItemValidator();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		CartService cart = new CartServiceImpl();
		do {

			System.out.println("Press 1 to Add to Cart");
			System.out.println("Press 2 to Search again");
			flag = scanner.next();

			switch (flag) {

			case "1":

				for (int i = 1; i <= 3; i++) {
					try {
						String tempItemID = "";
						System.out.println("Enter Item Id To Add to Cart");
						tempItemID = scanner.next();
						isValid.itemIdValidation(tempItemID);
						itemId = Integer.parseInt(tempItemID);

						System.out.println("Enter Quantity");
						String tempQty = scanner.next();
						isValid.qtyValidaton(tempQty);
						qty = Integer.parseInt(tempQty);

						boolean counter = cart.addToCart(itemId, qty, storeName);
						if (counter) {
							System.out.println("Your Cart is :" + CartDetailsStaticDb.getCartList());
							break;
						} else {
							System.out.println("Not Found");
						}
					} catch (ItemIdException e) {
						System.out.println(e.getMessage());
					} catch (ItemQtyException e) {
						System.out.println(e.getMessage());
					} catch (NotFoundIdException e) {
						System.out.println(e.getMessage());
					}
				}
				String counter = "";
				System.out.println("Enter 1 to confirm order");
				System.out.println("Enter 2 to Delete Cart");
				System.out.println("Enter 3 to add More");
				counter = scanner.next();

				if (counter.equalsIgnoreCase("1")) {
					boolean order = cart.confirmOrder();
					if (order == true) {
						System.out.println("Order Confirmed ");
						PosMain.main(null);
						// System.out.println("Press ctrl+f11 to Reorder");
					} else {
						System.out.println(" sorry !! can't complete your request ");
						PosMain.main(null);
					}
				} else if (counter.equalsIgnoreCase("2")) {

					try {
						System.out.println("Enter Cart Id");
						String tempCartId = scanner.next();
						CartValidator valid = new CartValidator();
						valid.isCartIdValid(tempCartId);
						int cartId = Integer.parseInt(tempCartId);
						cart.removeItemFromCart(cartId);
						System.out.println("Cart Deleted");
						System.out.println(CartDetailsStaticDb.getCartList());
						PosMain.main(null);
					} catch (InvalidCartException e) {
						System.out.println(e.getMessage());
					} catch (NotFoundIdException e) {
						System.out.println(e.getMessage());
					}
				} else if (counter.equalsIgnoreCase("3")) {
					try {
						CartValidator valid = null;
						if (valid == null) {
							valid = new CartValidator();
						}
						ItemValidator isVali = null;
						if (isVali == null) {
							isVali = new ItemValidator();
						}

						System.out.println("Enter Quantity");
						String tempQty = scanner.next();
						isVali.qtyValidaton(tempQty);
						qty = Integer.parseInt(tempQty);
						System.out.println("Enter Cart Id to Add More: ");
						String tempId = scanner.next();
						valid.isCartIdValid(tempId);
						int id = Integer.parseInt(tempId);
						cart.addMore(id,qty);
						System.out.println(CartDetailsStaticDb.getCartList());
					} catch (InvalidCartException e) {
						System.out.println(e.getMessage());
					} catch (NotFoundIdException e) {
						System.out.println(e.getMessage());
					} catch (ItemQtyException e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("Invalid");
				}

				break;
			case "2":
				StoreInputUi.store();
				break;

			default:
				System.out.println("Incorrect Input");

				break;

			}
		} while (true);
	}
}
