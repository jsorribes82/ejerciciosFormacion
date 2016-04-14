package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity (name="PRODUCT_CUSTOMER")
public class Sale  { 
	@EmbeddedId
	protected SaleId saleId;
	@Column (name="CREATION_DATE")
	protected Date saleDate;
	
//	public Sale(Product product, Customer customer) {
//		this.product_id = product.getId();
//		this.customer_id = customer.getId();
//		this.saleDate = new Date();
//	}
	public Sale(SaleId saleId){
		this.saleId=saleId;
	}
	
	public Date getSaleDate() {
		return saleDate;
	}
	
	
}
