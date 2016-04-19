package com.indra.formacio.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Objects of this class represent an Employee
 * 
 * @author ealcalal
 *
 */
@Entity
public class Employee {
	@Id
	@SequenceGenerator(name="SEQ_EMPLOYEE",sequenceName="SEQ_EMPLOYEE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="SEQ_EMPLOYEE")	
	protected Long id;
	@Column
	protected String name;
	@Column
	protected String surname;
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	protected Date birthday;
	@Column(name="PERCENT_CUSTOMER")
	protected Double percentCustomers;
	@Column(name="PERCENT_DATE")
	protected Date percentDate;
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date bithday) {
		this.birthday = bithday;
	}
	public Double getPercentCustomers() {
		return percentCustomers;
	}
	public void setPercentCustomers(Double percentCustomers) {
		this.percentCustomers = percentCustomers;
	}
	public Date getPercentDate() {
		return percentDate;
	}
	public void setPercentDate(Date percentDate) {
		this.percentDate = percentDate;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(1, 31).
			       append(id).
			       append(name).
			       append(surname).
			       append(birthday).
			       append(percentDate).
			       append(percentCustomers).
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
		Employee c = (Employee) obj;
		return new EqualsBuilder()
				.append(id, c.getId())
				.append(name, c.getName())
				.append(surname, c.getSurname())
				.append(birthday, c.getBirthday())
				.append(percentDate, c.getPercentDate())
				.append(percentCustomers, c.getPercentCustomers())
				.isEquals();

	}
}
