package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.indra.formacio.model.Employee;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
	
	private SimpleDateFormat sdf;
	
	public EmployeeTest() {
		sdf = new SimpleDateFormat("dd/mm/yyyy");	
	}
	
	public void testSettersAndGetters() throws ParseException {
				
		Employee a = new Employee();
		a.setName("Federico");
		a.setSurname("Larcia Gorca");
//		a.setPercentDate(sdf.parse("04/04/2016"));
//		a.setId((long) 999999999);
		a.setBirthday(sdf.parse("04/04/1991"));
		
		assertEquals("Federico", a.getName());
		assertEquals("Larcia Gorca", a.getSurname());
//		assertEquals(sdf.parse("04/04/2016"), a.getPercentDate());
//		assertSame(new Long(999999999), a.getId());
		assertEquals(sdf.parse("04/04/1991"), a.getBirthday());
		
	}
	
//	public void testCalculPercentatge(){
//		Employee a = new Employee();
//		a.setPercentCustomers(25f);
//		
//		assertEquals(a.getPercentCustomers(),100f/4);
//		
//	}
}
