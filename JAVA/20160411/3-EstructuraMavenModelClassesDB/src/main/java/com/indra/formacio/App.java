package com.indra.formacio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
		Employee emp = new Employee();
		emp.setName("Empleat 1");
		emp.setSurname("Cognom 1");
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(emp);
		manager.getTransaction().commit();
		
		Customer c;
		
		manager.getTransaction().begin();
		for (int i = 0; i < 5; i++){
			c = new Customer();
			c.setName("Nom client "+i);
			c.setSurname("Cognom client "+i);
			c.setEmployee(emp);
			manager.persist(c);
		}
		manager.getTransaction().commit();
		
		manager.refresh(emp);

		List<Customer> clients = emp.getCustomers();
		
		System.out.println("L'empleat "+emp.getName()+" té els següents clients");
		
		for (Customer customer : clients) {
			System.out.println(customer.toString());
		}
    	
    }
}
