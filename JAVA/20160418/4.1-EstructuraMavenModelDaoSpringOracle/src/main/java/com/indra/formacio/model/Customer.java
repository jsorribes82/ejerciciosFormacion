package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Objects of this class represents a Customer A Customer has one Employee
 * assigned.
 * 
 * @author ealcalal
 *
 */
@Entity
public class Customer {
	@Id
	@SequenceGenerator(name="SEQ_CUSTOMER",sequenceName="SEQ_CUSTOMER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CUSTOMER")	
	protected Long id;
	@Column
	protected String name;
	@Column
	protected String surname;
	@Column(name="PERCENT_PRODUCT")
	protected Double percentProduct;
	@Column(name="PERCENT_DATE")
	protected Date percentDate;
	@OneToOne
	protected Employee employee;

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

	public Double getPercentProduct() {
		return percentProduct;
	}

	public void setPercentProduct(Double percentProduct) {
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1, 31).
			       append(id).
			       append(name).
			       append(surname).
			       append(employee).
			       append(percentDate).
			       append(percentProduct).
			       toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Customer c = (Customer) obj;
		return new EqualsBuilder()
				.append(id, c.getId())
				.append(name, c.getName())
				.append(surname, c.getSurname())
				.append(percentDate, c.getPercentDate())
				.append(percentProduct, c.getPercentProduct())
				.append(employee, c.getEmployee())
				.isEquals();

	}
}
