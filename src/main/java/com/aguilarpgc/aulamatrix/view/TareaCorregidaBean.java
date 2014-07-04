package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;

public class TareaCorregidaBean implements Serializable{

	private Integer id;
	private String tarea;
	private String docente;
	private String nota;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	
	
}
