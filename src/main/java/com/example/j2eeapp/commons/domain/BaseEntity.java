package com.example.j2eeapp.commons.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base entity type to hold common Id property. To be extended.
 * 
 * @author Arthur Vin
 */

/**
 * 
 * @author IMRAN
 * @MappedSuperclass this annotation means that hibernate should not create table for class and this class will only be used in inheritance
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 568379222048217476L;

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}