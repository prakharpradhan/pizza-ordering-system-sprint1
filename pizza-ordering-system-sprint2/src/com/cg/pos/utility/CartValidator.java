package com.cg.pos.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.pos.exceptions.InvalidCartException;

public class CartValidator {
	/**
	 * validaton of cart id
	 * @param cartId
	 * @throws InvalidCartException
	 */
	public void isCartIdValid(String cartId) throws InvalidCartException {
		Pattern pattern = Pattern.compile("[1-9]{1}");
		Matcher matcher = pattern.matcher(cartId);

		if (!(matcher.find()) || cartId.isEmpty()) {

			throw new InvalidCartException("Invalid Cart");

		}
	}
}
