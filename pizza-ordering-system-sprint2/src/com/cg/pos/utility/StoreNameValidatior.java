package com.cg.pos.utility;

import com.cg.pos.exceptions.StoreNameException;

public class StoreNameValidatior {
	public boolean isValidStoreName(String storeName) throws StoreNameException {
		if ((!storeName.matches("^[a-zA-Z]*$") || storeName.isEmpty())) {
			throw new StoreNameException("Invalid Store Name");

		} else {
			return true;
		}
	}
}
