package com.indra.formacio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SaleId implements Serializable {
	@Column (name="PRODUCT_ID")
	protected Long productid;
	@Column (name="CUSTOMER_ID")
	protected Long customerid;
	
	public SaleId(){
		
	}
	public SaleId(Product product, Customer customer) {
		this.productid = product.id;
		this.customerid = customer.id;
	}
	
	public Long getProduct_id() {
		return productid;
	}
	public void setProduct_id(Long product_id) {
		this.productid = product_id;
	}
	public Long getCustomer_id() {
		return customerid;
	}
	public void setCustomer_id(Long customer_id) {
		this.customerid = customer_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
		result = prime * result + ((productid == null) ? 0 : productid.hashCode());
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
		if (customerid == null) {
			if (other.customerid != null)
				return false;
		} else if (!customerid.equals(other.customerid))
			return false;
		if (productid == null) {
			if (other.productid != null)
				return false;
		} else if (!productid.equals(other.productid))
			return false;
		return true;
	}
	
	
}