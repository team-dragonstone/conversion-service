package com.training.microservices.currencyconversionservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SaiTestTests {

	@Test
	void testStringTest() {
		SaiTest test = new SaiTest();
		assertEquals("testing", test.stringTest());
	}

	@Test
	void testBadPracticeString() {
		SaiTest test = new SaiTest();
		assertEquals("1234567891011121314151617181920", test.badPracticeString());
	}

	@Test
	void testGoodPracticeString() {
		SaiTest test = new SaiTest();
		assertEquals("1234567891011121314151617181920", test.goodPracticeString());
	}

	@Test
	void testAddition() {
		SaiTest test = new SaiTest();
		assertEquals(7, test.addition(5, 2));
	}

}
