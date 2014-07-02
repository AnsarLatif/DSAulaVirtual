package com.aguilarpgc.aulamatrix.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CURSO")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_CURSO")
	private Integer id;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="ID_CICLO")
	private Integer idCiclo;
	
	public Integer getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(Integer idCiclo) {
		this.idCiclo = idCiclo;
	}

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
