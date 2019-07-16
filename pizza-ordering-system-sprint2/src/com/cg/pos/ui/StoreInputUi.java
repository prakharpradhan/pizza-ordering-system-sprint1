package com.cg.pos.ui;

import java.util.Scanner;

import com.cg.pos.exceptions.StoreNameException;
import com.cg.pos.service.PizzaService;
import com.cg.pos.service.impl.PizzaServiceimpl;

public class StoreInputUi {
	@SuppressWarnings("resource")
	public static void store() {
		String flag = "";
		String storeName = "";
		Scanner scanner = new Scanner(System.in);
		PizzaService pizzaService = new PizzaServiceimpl();
		do {
			System.out.println("Press 1 To Search Store By Name");

			System.out.println("Press 2 To Exit");
			flag = scanner.next();
			switch (flag) {

			case "1":
				for (int i = 1; i <= 3; i++) {
					System.out.println("Please Enter The Store Name");

					storeName = scanner.next();
					try {
						boolean counter = pizzaService.viewPizza(storeName);
						if (counter == true) {
							AddToCartUi.cart(storeName);
						}
						else {
							System.out.println("Not Found");
						}
					} catch (StoreNameException e) {
						System.out.println(e.getMessage());
					}

				}
				break;

			case "2":
				System.exit(0);
			default:
				System.out.println("Incorrect Input");
				
				break;
			}

		} while (true);
	}
}
