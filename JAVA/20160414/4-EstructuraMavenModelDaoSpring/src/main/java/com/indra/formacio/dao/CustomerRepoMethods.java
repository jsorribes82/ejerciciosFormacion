package com.indra.formacio.dao;

import java.util.List;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

public interface CustomerRepoMethods{

	List<Customer> findBySurname(String surname);
	List<Customer> findCustomerListByEmployee(Employee employee);
	List<Customer> findListAllCustomer();
//	Double actualizaPorcentagesClientes(Customer cust1);
}
