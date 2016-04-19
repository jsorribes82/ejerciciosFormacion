package com.indra.formacio.dao;

import org.springframework.data.repository.CrudRepository;

import com.indra.formacio.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	

}
