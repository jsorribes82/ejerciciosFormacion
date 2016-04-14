package com.indra.formacio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.formacio.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findById (Long id);
	List<Product> findByName (String name);
	

}
