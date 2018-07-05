package com.bridgelabz.Junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvenNumberTest {

	@Test
	public void testIsEvenNumber() {
		EvenNumber even = new EvenNumber();
        assertTrue(even.isEvenNumber(4));
	}
}
