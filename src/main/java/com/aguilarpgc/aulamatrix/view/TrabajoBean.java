package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;
import java.util.Date;

public class TrabajoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Integer id;
	String nombre;
	String ruta;
	Date fechaMax;
	Integer integrantesMax;
	String tipo;
	Integer cursoGrupoTipoId;
	


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
	public Date getFechaMax() {
		return fechaMax;
	}
	public void setFechaMax(Date fechaMax) {
		this.fechaMax = fechaMax;
	}
	public Integer getIntegrantesMax() {
		return integrantesMax;
	}
	public void setIntegrantesMax(Integer integrantesMax) {
		this.integrantesMax = integrantesMax;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getCursoGrupoTipoId() {
		return cursoGrupoTipoId;
	}
	public void setCursoGrupoTipoId(Integer cursoGrupoTipoId) {
		this.cursoGrupoTipoId = cursoGrupoTipoId;
	}
	
}
