package com.aguilarpgc.aulamatrix.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="GRUPO")
public class Grupo implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_GRUPO")
	private Integer id;
	
	@Column(name="NOMBRE")
	private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
