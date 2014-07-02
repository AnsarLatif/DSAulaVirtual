package com.aguilarpgc.aulamatrix.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_USUARIO")
	private Integer id;

	@Column(name="USUARIO")
	private String usuario;

	@Column(name="CONTRASENIA")
	private String contrasenia;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="APE_PATERNO")
	private String apellidoPaterno;

	@Column(name="APE_MATERNO")
	private String apellidoMaterno;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	Estado estado;

	@ManyToOne
	@JoinColumn(name="ID_PERFIL")
	Perfil perfil;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
