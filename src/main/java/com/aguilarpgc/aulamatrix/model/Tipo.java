package com.aguilarpgc.aulamatrix.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TIPO")
public class Tipo implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_TIPO")
	private Integer id;

	@Column(name="DESCRIPCION")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
