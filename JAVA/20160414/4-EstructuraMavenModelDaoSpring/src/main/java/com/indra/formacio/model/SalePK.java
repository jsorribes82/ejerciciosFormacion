package com.indra.formacio.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class SalePK implements Serializable {

//	@Column(name="CUSTOMER_ID",insertable=false,updatable=false)
//	protected Long customer;
//	
//	@Column(name="PRODUCT_ID",insertable=false,updatable=false)
//	protected Long product;	
	
//unaltra manera sense referencies
	@ManyToOne
	protected Customer customer;
	@ManyToOne
	protected Product product;

	public SalePK(Customer customer, Product product){
		this.customer=customer;
		this.product=product;
//		saleDate=;
	}
	
	public SalePK(){
		
	}
	
}
