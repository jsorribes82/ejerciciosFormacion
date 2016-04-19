package com.indra.formacio.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.indra.formacio.model.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, Long> , CustomerRepoMethods{
	List<Customer> findByName(String name);
	
}
