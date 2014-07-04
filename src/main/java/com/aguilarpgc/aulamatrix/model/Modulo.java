package com.aguilarpgc.aulamatrix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MODULO")
public class Modulo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_MODULO")
	private Integer id;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="URL")
	private String url;
	
	@Column(name="ICONO")
	private String icono;
	
	@ManyToMany(mappedBy = "modulo")
	private Collection<Perfil> perfil = new ArrayList<Perfil>();
	/*@OneToMany(targetEntity=Permiso.class, mappedBy="modulo")
	private List<Permiso> permisos = new ArrayList<Permiso>(0);*/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(ArrayList<Perfil> perfil) {
		this.perfil = perfil;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	/*public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}*/
	
	
	
}
