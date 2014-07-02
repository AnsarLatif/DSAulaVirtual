package com.aguilarpgc.aulamatrix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="PERFIL")
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_PERFIL")
	private Integer id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;

	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="PERMISO", joinColumns={
			@JoinColumn(name = "ID_PERFIL")},
			inverseJoinColumns = {
			@JoinColumn(name = "ID_MODULO")})
	private Collection<Modulo> modulo = new ArrayList<Modulo>();

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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<Modulo> getModulo() {
		return modulo;
	}

	public void setModulo(ArrayList<Modulo> modulo) {
		this.modulo = modulo;
	}


}
