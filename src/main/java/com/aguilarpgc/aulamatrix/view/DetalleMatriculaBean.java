package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;

public class DetalleMatriculaBean implements Serializable{

	private Integer idCurso;
	private Integer idGrupo;
	
	public DetalleMatriculaBean(){
		
	}
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	
	
}
