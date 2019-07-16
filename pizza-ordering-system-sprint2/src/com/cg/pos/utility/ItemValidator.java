package com.cg.pos.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.pos.exceptions.ItemIdException;
import com.cg.pos.exceptions.ItemQtyException;

public class ItemValidator {
	/**
	 * Validation of itemid
	 * 
	 * @param itemId
	 * @throws ItemIdException
	 */
	public void itemIdValidation(String itemId) throws ItemIdException {

		Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{2}");
		Matcher matcher = pattern.matcher(itemId);

		if (!(matcher.find()) || itemId.isEmpty()) {

			throw new ItemIdException("Invalid Item Id");

		}

	}

	public void qtyValidaton(String tempQty) throws ItemQtyException {
		/**
		 * validation of qty
		 */

		if (tempQty.matches("^[a-zA-Z]*$") || tempQty.isEmpty()) {

			throw new ItemQtyException("Invalid Qty");

		}

	}

}
