package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_CUSTOMER")
//@IdClass(SalePK.class)
public class Sale {
	
	@EmbeddedId
	protected SalePK key;
	
//	@ManyToOne
//	@Id
//	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
//	protected Customer customer;
	
//	@ManyToOne
//	@Id
//	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
//	protected Product product;
	
//	@ManyToOne
//	@Id
	@Column(name="CREATION_DATE")
	protected Date saleDate;
	@Column(name="CANTIDAD")
	protected Integer cantidad;
	
	public Sale(){
	}
	
	public Sale(SalePK salePk, int cantidadProductos){
//		customer.id=salePk.customer;
//		product.id=salePk.product;
		saleDate=new Date();
		cantidad=cantidadProductos;
		
	}
	public void setCantidad(Integer cantidad){
		this.cantidad=cantidad;
	}
	public int getCantidad(){
		return this.cantidad;
	}
	public void setProducto (Product product){
		this.key.product=product;
	}
	public Product getProducto(){
		return this.key.product;
	}
	public void setCustomer (Customer customer){
		this.key.customer=customer;
	}
	public Customer getCustomer(){
		return this.key.customer;
	}
}
