package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;

public class UsuarioSesionBean implements Serializable{

	private String id;
	private String nombre;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
