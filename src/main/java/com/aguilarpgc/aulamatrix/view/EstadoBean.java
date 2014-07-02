package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;

public class EstadoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Integer id;
	String descripcion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
