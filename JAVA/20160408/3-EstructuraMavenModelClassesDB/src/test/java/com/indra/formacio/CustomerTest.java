package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import com.indra.formacio.model.Customer;

public class CustomerTest extends TestCase {

	public CustomerTest() {}
	
	public void testSettersAndGetters() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Customer a = new Customer();
		a.setName("Federico");
		a.setSurname("Larcia Gorca");
		a.setPercentDate(sdf.parse("04/04/2016"));
		a.setPercentProduct(2.4f);
		
		assertEquals("Federico", a.getName());
		assertEquals("Larcia Gorca", a.getSurname());
		assertEquals(sdf.parse("04/04/2016"), a.getPercentDate());
		assertEquals(2.4f, a.getPercentProduct());
	}
	
	public void testInsert() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Customer a = new Customer();
		a.setName("Federico");
		a.setSurname("Larcia Gorca");
		a.setPercentDate(sdf.parse("04/04/2016"));
		a.setPercentProduct(2.4f);
		
		EntityManager manager = Persistence.createEntityManagerFactory("customers").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(a);		
		manager.getTransaction().commit();
		
		
		List res = manager.createQuery(
		        "FROM Customer c where c.name = :custName")
		        .setParameter("custName", "Federico")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		
		Customer b = (Customer) res.get(0);
		assertNotNull(b);
		assertEquals(a.getName(), b.getName());
		assertEquals(a.getId(), b.getId());
		
				
	}
}
