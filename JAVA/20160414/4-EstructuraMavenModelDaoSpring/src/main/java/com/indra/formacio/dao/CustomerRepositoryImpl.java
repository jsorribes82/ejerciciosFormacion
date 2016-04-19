package com.indra.formacio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

public class CustomerRepositoryImpl implements CustomerRepoMethods{
	
//	@PersistenceContext	//JPA annotation
	@Autowired	//Spring Annotation
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Customer> findBySurname(String surname){
		
		Query q = entityManager.createQuery("FROM Customer c WHERE c.surname = :sur");
		q.setParameter("sur", surname);
		return (ArrayList<Customer>)q.getResultList();
		
	};
	@SuppressWarnings("unchecked")
	public List<Customer> findCustomerListByEmployee(Employee employee){
		
		Query q = entityManager.createQuery("FROM Customer c WHERE c.employee = :empleado");
		q.setParameter("empleado", employee);
		return (List<Customer>)q.getResultList();
		
	};
	
	@SuppressWarnings("unchecked")
	public List<Customer> findListAllCustomer(){
		
		Query q = entityManager.createQuery("FROM Customer ");
		return (List<Customer>)q.getResultList();
		
	};
//	public Double actualizaPorcentagesClientes(Customer cust1){
//		Query q = entityManager.createQuery("select count(*) FROM Product");
//		Long totalProduct=(Long)q.getSingleResult();
//		Query q2 = entityManager.createQuery("select count(*) FROM Sale s where s.customer.id=:cliente");
//		q2.setParameter("cliente", cust1.getId());
//		Long totalProductPorCliente=(Long)q2.getSingleResult();
//		Double percentProduct=(double) ((totalProductPorCliente/totalProduct)*100);
//		return percentProduct;
//	}

}
