package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatriculaBean implements Serializable{

	private List<DetalleMatriculaBean> rows;
	
	public MatriculaBean(){
		rows = new ArrayList<DetalleMatriculaBean>();
	}

	public List<DetalleMatriculaBean> getRows() {
		return rows;
	}

	public void setRows(List<DetalleMatriculaBean> rows) {
		this.rows = rows;
	}
	
	
	
}
