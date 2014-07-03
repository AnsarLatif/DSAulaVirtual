package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;

	String id;
	String usuario;
	@NotNull
    @Size(min = 3, max = 12, message = "La clave ingresada debe tener un máximo de 12 caracteres.")
	String contrasenia;
	
	String nombre;
	String apPaterno;
	String apMaterno;
	String estado;
	String perfil;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
}
