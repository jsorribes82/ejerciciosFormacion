package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Employee;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
	public void testInsert() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Employee a = new Employee();
		a.setName("nombre empleado");
		a.setSurname("apellido empleado");
		a.setPercentDate(sdf.parse("04/04/2016"));
		
		EntityManager manager = Persistence.createEntityManagerFactory("customers").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(a);		
		manager.getTransaction().commit();
		
		
		List res = manager.createQuery(
		        "FROM Employee e where e.name = :emplName")
		        .setParameter("emplName", "nombre empleado")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		
		Employee b = (Employee) res.get(0);
		assertNotNull(b);
		assertEquals(a.getName(), b.getName());
		assertEquals(a.getId(), b.getId());
		
				
	}

}
