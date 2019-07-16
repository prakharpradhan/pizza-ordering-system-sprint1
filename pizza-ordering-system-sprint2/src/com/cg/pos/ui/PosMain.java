package com.cg.pos.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.pos.dto.StoreDetails;
import com.cg.pos.service.PizzaService;
import com.cg.pos.service.impl.PizzaServiceimpl;

public class PosMain {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		PizzaService db = new PizzaServiceimpl();
		db.init();
		String flag = "";
		System.out.println("Press 1 to Order From a Store");
		System.out.println("Press 2 to Exit");
		do {
			flag = scanner.next();
			switch (flag) {
			case "1":
				System.out.println("PIZZA ORDERING SYSTEM");
				ArrayList<StoreDetails> storeList = db.initStore();
				System.out.println(storeList);
				StoreInputUi.store();
				break;
			case "2":
				System.out.println("Succesfully Exited");
				System.exit(0);
			default:
				System.out.println("Incorrect");
				PosMain.main(null);
				break;
			}
			
		} while (true);
		
	}
}
