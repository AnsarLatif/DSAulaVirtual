package com.aguilarpgc.aulamatrix.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aguilarpgc.aulamatrix.logic.PerfilLogic;
import com.aguilarpgc.aulamatrix.logic.UsuarioLogic;
import com.aguilarpgc.aulamatrix.model.Modulo;
import com.aguilarpgc.aulamatrix.model.Perfil;
import com.aguilarpgc.aulamatrix.view.UsuarioBean;
import com.aguilarpgc.aulamatrix.view.UsuarioSesionBean;

@Controller
@RequestMapping(value="/admin")
public class MasterController {

	@Autowired
	public UsuarioLogic usuarioLogic;
	
	@Autowired
	public PerfilLogic perfilLogic;
	
	@Autowired
	public UsuarioSesionBean usuarioSesionBean;
	
	@ModelAttribute("allModules")
	public List<Modulo> modulesByUser(){
		if(usuarioSesionBean!=null && usuarioSesionBean.getId()!=null){
			Perfil perfil = perfilLogic.getPerfil(usuarioLogic.getUsuario(usuarioSesionBean.getId().toString()).getPerfil().getId());
			return (List<Modulo>) perfil.getModulo();
		}
		return null;
	}
	
}
