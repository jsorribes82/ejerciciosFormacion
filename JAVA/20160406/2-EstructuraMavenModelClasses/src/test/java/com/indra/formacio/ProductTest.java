package com.indra.formacio;

import java.text.ParseException;
import com.indra.formacio.model.Product;
import junit.framework.TestCase;

public class ProductTest extends TestCase{
	
	public void testSettersAndGetters() throws ParseException {
		Product a= new Product();
		a.setName("Product 1");
		a.setDescription("Description product 1");
		
		assertEquals("Product 1", a.getName());
		assertEquals("Description product 1", a.getDescription());
		
	}
}
