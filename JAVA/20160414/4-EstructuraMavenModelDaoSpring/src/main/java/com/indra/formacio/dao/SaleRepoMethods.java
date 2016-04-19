package com.indra.formacio.dao;

import java.util.List;

import com.indra.formacio.model.Customer;

public interface SaleRepoMethods  {
	Double actualizaPorcentagesClientes(Customer cust1);
	Customer clienteMasProductos(List <Customer> custList);
	
}
