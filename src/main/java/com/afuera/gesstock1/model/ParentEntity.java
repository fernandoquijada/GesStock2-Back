package com.afuera.gesstock1.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * 
 * 
 * 
 * 
 * TODO: esta clase en un ppio no se utiliza YA
 * 
 * 
 * 
 * @author Alberto
 *
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class ParentEntity implements Serializable {

	private static final long serialVersionUID = -1933847309458909903L;
	
	@Id
	//TODO generar ID automáticamente de manera incremental
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
