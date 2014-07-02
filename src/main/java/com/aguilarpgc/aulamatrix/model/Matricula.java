package com.aguilarpgc.aulamatrix.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MATRICULA")
public class Matricula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID_MATRICULA")
	Integer id;

	@Column(name="ID_CURSO_GRUPO")
	Integer idCursoGrupo;
	
	@Column(name="ID_USUARIO")
	String idUsuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCursoGrupo() {
		return idCursoGrupo;
	}

	public void setIdCursoGrupo(Integer idCursoGrupo) {
		this.idCursoGrupo = idCursoGrupo;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	

}
