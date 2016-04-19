package com.indra.formacio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.model.Customer;

public class SaleRepositoryImpl implements SaleRepoMethods {

	@Autowired	//Spring Annotation
	protected EntityManager entityManager;
	
	public Double actualizaPorcentagesClientes(Customer cust1){
		Query q = entityManager.createQuery("select count(*) FROM Product");
		Long totalProduct=(Long)q.getSingleResult();
		Query q2 = entityManager.createQuery("select count(s) FROM Sale s where s.key.customer=:cliente");
		q2.setParameter("cliente", cust1.getId());
		Long totalProductPorCliente=(Long)q2.getSingleResult();
		Double percentProduct= (double)((((double)totalProductPorCliente)/totalProduct)*100);
		return percentProduct;
	}
	public Customer clienteMasProductos(List <Customer> custList){
		
		Query q = entityManager.createQuery("select s.key.customer.id FROM Sale s group by s.key.product.id, s.key.customer.id, s.cantidad having s.cantidad = (select max(s.cantidad) FROM Sale s )");
		Long idCustomerQuery=(Long)q.getSingleResult();
		for (int i = 0; i < custList.size(); i++) {
			if(idCustomerQuery==custList.get(i).getId()){
				return custList.get(i);
			}
		}
		return null;
	}
	

}
