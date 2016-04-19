package com.indra.formacio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;
import com.indra.formacio.model.SalePK;

public interface SaleRepository extends CrudRepository<Sale, SalePK>,SaleRepoMethods {
	List<Sale> findByKey_ProductOrderByCantidadDesc(Product product);
	
}
