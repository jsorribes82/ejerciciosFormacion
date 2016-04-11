package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sale {
	@ManyToOne
	@Id
	protected Product product;
	@ManyToOne
	@Id
	protected Customer customer;
	@Column
	protected Date saleDate;
	
	public Sale(Product product, Customer customer) {
		this.product = product;
		this.customer = customer;
		this.saleDate = new Date();
	}
	
	public Product getProduct() {
		return product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Date getSaleDate() {
		return saleDate;
	}
}
