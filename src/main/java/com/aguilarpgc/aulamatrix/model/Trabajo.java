package com.aguilarpgc.aulamatrix.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TRABAJO")
public class Trabajo implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_TRABAJO")
	private Integer id;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="FEC_MAX")
	private String fechaMaxima;

	@Column(name="RUTA")
	private String ruta;

	@Column(name="INTEGRANTES_MAX")
	private Integer integrantesMaximo;

	@Column(name="TIPO")
	private String tipo;

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

	public String getFechaMaxima() {
		return fechaMaxima;
	}

	public void setFechaMaxima(String fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Integer getIntegrantesMaximo() {
		return integrantesMaximo;
	}

	public void setIntegrantesMaximo(Integer integrantesMaximo) {
		this.integrantesMaximo = integrantesMaximo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
