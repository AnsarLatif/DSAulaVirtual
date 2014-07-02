package com.aguilarpgc.aulamatrix.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="NOTA")
public class Nota implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID_NOTA")
	private Integer id;

	@Column(name="NOTA")
	private Double nota;

	@Column(name="ID_DOCUMENTO")
	private Integer documento;

	@Column(name="ID_USUARIO")
	private String usuario;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


}
