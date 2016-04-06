package com.indra.formacio.model;

import java.util.Date;

/**
 * Objects of this class represents a Customer
 * A Customer has one Employee assigned.
 * @author ealcalal
 *
 */
public class Customer {
	protected Long id;
	protected String name;
	protected String surname;
	protected Float percentProduct;
	protected Date percentDate;
	protected Employee employee;
	
	public Customer(){
		
	}
	/**
	 * Constructor para Customer
	 * @param id de customer de tipo Long
	 * @param name de customer de tipo String
	 * @param surname de customer de tipo String
	 * @param employee de customer de tipo Employee
	 */
	public Customer(Long id, String name, String surname, Employee employee){
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.employee=employee;
		
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Float getPercentProduct() {
		return percentProduct;
	}
	public void setPercentProduct(Float percentProduct) {
		this.percentProduct = percentProduct;
	}
	public Date getPercentDate() {
		return percentDate;
	}
	public void setPercentDate(Date percentDate) {
		this.percentDate = percentDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
