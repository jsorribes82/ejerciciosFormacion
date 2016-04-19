package com.indra.formacio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Objects of this class represents a Product of the companys portfolio.
 * 
 * @author ealcalal
 *
 */
@Entity
public class Product {
	@Id
	@SequenceGenerator(name="SEQ_PRODUCT",sequenceName="SEQ_PRODUCT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="SEQ_PRODUCT")	
	protected Long id;
	@Column
	protected String name;
	@Column
	protected String description;
	
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
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(1, 31).
			       append(id).
			       append(name).
			       append(description).
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
		Product c = (Product) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj))
				.append(id, c.getId())
				.append(name, c.getName())
				.append(description, c.getDescription())
				.isEquals();

	}
}
