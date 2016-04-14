package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
//import com.indra.formacio.model.SaleId;
@Entity
@IdClass (SaleId.class)
public class Sale  { 
	@Id  
	@Column
	@ManyToOne
	protected Product product;
	@Id  
	@Column
	@ManyToOne
	protected Customer customer;
	@Column
	protected Date saleDate;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	
	
}
