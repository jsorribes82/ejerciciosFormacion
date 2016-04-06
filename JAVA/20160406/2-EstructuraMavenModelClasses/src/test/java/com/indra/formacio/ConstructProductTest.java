package com.indra.formacio;

import java.text.ParseException;

import com.indra.formacio.model.Product;

import junit.framework.TestCase;

public class ConstructProductTest extends TestCase{
	public void testSettersAndGetters() throws ParseException {
		Product prod1=new Product(66l,"PRoducto 11");
		
		assertEquals("PRoducto 11", prod1.getName());
		
	}
}
