package com.indra.formacio.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class SaleId implements Serializable {
	@ManyToOne
	protected Product product;
	@ManyToOne
	protected Customer customer;
//	protected Date saleDate;
	public SaleId(){
		
	}
	public SaleId(Product product, Customer customer) {
		this.product = product;
		this.customer = customer;
//		this.saleDate = new Date();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleId other = (SaleId) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
	
}