package com.indra.formacio;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Product;

import junit.framework.TestCase;

public class ProductTest extends TestCase {
	public void testInsert() throws ParseException {
		
		Product a = new Product();
		a.setName("Producto 1");
		
		EntityManager manager = Persistence.createEntityManagerFactory("customers").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(a);		
		manager.getTransaction().commit();
		
		
		List res = manager.createQuery(
		        "FROM Product p where p.name = :prodName")
		        .setParameter("prodName", "Producto 1")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		
		Product b = (Product) res.get(0);
		assertNotNull(b);
		assertEquals(a.getName(), b.getName());
		assertEquals(a.getId(), b.getId());
		
				
	}
}
