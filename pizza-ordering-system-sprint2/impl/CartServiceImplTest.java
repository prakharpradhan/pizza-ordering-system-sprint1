package com.cg.pos.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cg.pos.exceptions.InvalidCartException;
import com.cg.pos.exceptions.NotFoundIdException;

public class CartServiceImplTest {
	private CartServiceImpl cart;

	@Before
	public void setUp() throws Exception {
		cart= new CartServiceImpl();
	}
	/**
	 * TestCase to check Whether cart id taken by user exists or not
	 */
	@Test
	public void testReomoveItemFromCartIdNotFound() throws  NotFoundIdException, InvalidCartException{
		boolean test= cart.removeItemFromCart(109);
		assertEquals(false, test);
	}

	

}
