package com.aguilarpgc.aulamatrix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aguilarpgc.aulamatrix.logic.PerfilLogic;
import com.aguilarpgc.aulamatrix.logic.UsuarioLogic;
import com.aguilarpgc.aulamatrix.model.Modulo;
import com.aguilarpgc.aulamatrix.model.Perfil;

@Controller
@RequestMapping(value="/admin")
public class MasterController {

	@Autowired
	UsuarioLogic usuarioLogic;
	
	@Autowired
	PerfilLogic perfilLogic;
	
	@ModelAttribute("allModules")
	public List<Modulo> modulesByUser(){
		Perfil perfil = perfilLogic.getPerfil(usuarioLogic.getUsuario("1").getPerfil().getId());
		return (List<Modulo>) perfil.getModulo();
	}
	
}
