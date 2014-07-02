package com.aguilarpgc.aulamatrix.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CICLO")
public class Ciclo implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_CICLO")
	private Integer id;

	@Column(name="DESCRIPCION")
	private String descipcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescipcion() {
		return descipcion;
	}

	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
