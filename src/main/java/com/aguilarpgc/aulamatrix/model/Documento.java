package com.aguilarpgc.aulamatrix.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="DOCUMENTO")
public class Documento implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID_DOCUMENTO")
	private Integer id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="RUTA")
	private String ruta;

	@Column(name="ID_TRABAJO")
	private Integer trabajo;

	@Column(name="ID_USUARIO")
	private String idUsuario;

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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Integer trabajo) {
		this.trabajo = trabajo;
	}

	public String getUsuario() {
		return idUsuario;
	}

	public void setUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}
