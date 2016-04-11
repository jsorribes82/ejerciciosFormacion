package com.indra.formacio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

import junit.framework.TestCase;

public class SaleTest extends TestCase{
	
	public void testInsertSalewithProductAndCustomer(){
		
		Employee emp = new Employee();
		emp.setName("Nom empleat");
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(emp);		
		manager.getTransaction().commit();
		
		Customer cust = new Customer();
		cust.setName("Federico");
		cust.setSurname("Larcia Gorca");
		cust.setPercentProduct(2.4f);
		cust.setEmployee(emp);

		manager.getTransaction().begin();
		manager.persist(cust);		
		manager.getTransaction().commit();
		
		Product prod1=new Product();
		prod1.setName("Producto 1");
		prod1.setDescription("Descripcio produte 1");
		
		manager.getTransaction().begin();
		manager.persist(prod1);		
		manager.getTransaction().commit();
		
		Sale venta=new Sale(prod1,cust);
		
		manager.getTransaction().begin();
		manager.persist(venta);		
		manager.getTransaction().commit();
		
		List res = manager.createQuery(
		        "FROM Sale s where s.customer.name = :cliName")
		        .setParameter("cliName", "Federico")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		Sale ventaAux = (Sale) res.get(0);
		assertNotNull(ventaAux);
		assertEquals(venta.getCustomer().getName(), ventaAux.getCustomer().getName());
		assertEquals(venta.getProduct().getName(), ventaAux.getProduct().getName());
	}
		
		
	
}
