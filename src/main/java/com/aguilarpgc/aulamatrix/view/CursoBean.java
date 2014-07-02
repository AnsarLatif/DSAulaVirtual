package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;

public class CursoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private Integer idCiclo;

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

	public Integer getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(Integer idCiclo) {
		this.idCiclo = idCiclo;
	}

}
