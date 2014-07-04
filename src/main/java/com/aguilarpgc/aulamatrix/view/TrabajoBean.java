package com.aguilarpgc.aulamatrix.view;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class TrabajoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	@NotNull(message = "Debe ingresar un nombre")
	@Size(min=5, max=60, message="El nombre es obligatorio, minimo 5 caracteres")
	String nombre;
	
	String ruta;
	
	@NotNull(message = "debe ingresar una fecha maxima")
	@DateTimeFormat(pattern="dd/mm/yyyy")
	@Future(message = "La fecha debe ser mayor a la actual")
	Date fechaMaxima;

	@NotNull(message = "Debe ingresar un numero valido")
	@Min(value=1, message = "Debe ingresar un numero valido, maximo es 5")
	@Max(5)
	Integer integrantesMaximo;
	
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
	public Date getFechaMaxima() {
		return fechaMaxima;
	}
	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}
	public Integer getIntegrantesMaximo() {
		return integrantesMaximo;
	}
	public void setIntegrantesMaximo(Integer integrantesMaximo) {
		this.integrantesMaximo = integrantesMaximo;
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
