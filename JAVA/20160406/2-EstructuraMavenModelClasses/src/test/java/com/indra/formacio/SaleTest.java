package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

import junit.framework.TestCase;

public class SaleTest extends TestCase{
	
	private SimpleDateFormat sdf;
	
	public SaleTest() {
		sdf = new SimpleDateFormat("dd/mm/yyyy");	
	}
	public void testSettersAndGetters() throws ParseException {
		Product prod1=new Product();
		Customer cust1=new Customer();
		Sale venta1=new Sale(prod1,cust1);
		
		venta1.getProduct().setName("Producto 123");
		venta1.getProduct().setDescription("Producto 123 Descripcionn");
		
		venta1.getCustomer().setName("Federico");
		venta1.getCustomer().setSurname("Larcia Gorca");
		venta1.getCustomer().setPercentDate(sdf.parse("04/04/2016"));
		venta1.getCustomer().setPercentProduct(2.4f);
		
		assertEquals("Producto 123", venta1.getProduct().getName());
		assertEquals("Producto 123 Descripcionn", venta1.getProduct().getDescription());
		
		assertEquals("Federico", venta1.getCustomer().getName());
		assertEquals("Larcia Gorca", venta1.getCustomer().getSurname());
		assertEquals(sdf.parse("04/04/2016"), venta1.getCustomer().getPercentDate());
		assertEquals(2.4f, venta1.getCustomer().getPercentProduct());
		
		
		
	}
		
		
}
