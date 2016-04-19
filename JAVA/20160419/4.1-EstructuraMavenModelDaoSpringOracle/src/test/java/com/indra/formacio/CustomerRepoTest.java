package com.indra.formacio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import junit.framework.TestCase;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/applicationContext.xml" })
@ContextConfiguration(locations = { "/applicationContextTest.xml" })
public class CustomerRepoTest extends TestCase {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	@Autowired
	CustomerRepository crepo;
	@Autowired
	EmployeeRepository erepo;
	
	@Test
	public void testCrud() throws ParseException {
		Employee e = erepo.findOne(1L);
		
		Customer a = new Customer();
		a.setName("Federico");
		a.setSurname("Larcia Gorca");
		a.setPercentDate(sdf.parse("04/04/2016"));
		a.setPercentProduct(2.4d);		
		a.setEmployee(e);
		
		crepo.save(a);
		assertNotNull(a.getId());
		
		List<Customer> res = crepo.findByName("Federico");
		assertFalse(res.isEmpty());
		
		Customer b = res.get(0);
		
		assertEquals(a.getId(), b.getId());
		assertEquals(a.getName(), b.getName());
		assertEquals(a.getSurname(), b.getSurname());
		assertEquals(a.getPercentDate(), b.getPercentDate());
		assertEquals(a.getPercentProduct(), b.getPercentProduct());
		assertEquals(a.getEmployee().getId(), b.getEmployee().getId());
		System.out.println(a.getEmployee().equals( b.getEmployee()));
		assertEquals(a.getEmployee(), b.getEmployee());
		assertEquals(a.hashCode(), b.hashCode());
		assertEquals(a,b);
	}
	
	@Test
	public void testFileInsertedData() {
		List<Customer> res = crepo.findByName("Client 1.1");
		assertFalse(res.isEmpty());
	}
}
