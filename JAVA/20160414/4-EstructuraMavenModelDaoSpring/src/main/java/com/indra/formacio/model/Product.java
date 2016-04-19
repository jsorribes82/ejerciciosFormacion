package com.indra.formacio.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Objects of this class represents a Product of the companys portfolio.
 * 
 * @author ealcalal
 *
 */
@Entity
public class Product {
	@Id
    @GeneratedValue
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
