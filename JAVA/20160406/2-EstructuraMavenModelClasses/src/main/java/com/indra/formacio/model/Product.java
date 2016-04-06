package com.indra.formacio.model;

/**
 * Objects of this class represents a Product of the companys portfolio.
 * 
 * @author ealcalal
 *
 */
public class Product {
	protected Long id;
	protected String name;
	protected String description;
	
	public Product(){
		
	}
	/**
	 * Constructor Product
	 * @param id del product tipo Long
	 * @param name del product tipo String
	 */
	public Product(Long id, String name){
		this.id=id;
		this.name=name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
