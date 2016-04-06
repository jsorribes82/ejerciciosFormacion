package com.indra.formacio;

import java.text.ParseException;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

import junit.framework.TestCase;

public class ContructCustomerTest extends TestCase {
	public void testSettersAndGetters() throws ParseException {
		Employee emp1=new Employee();
		Customer cust1=new Customer(44l, "Federico", "Perico Delgado", emp1);
		
		assertEquals("Federico", cust1.getName());
		//assertEquals(44l, cust1.getId());
		assertEquals("Perico Delgado", cust1.getSurname());
		assertEquals(emp1, cust1.getEmployee());
		
		
	}
}
