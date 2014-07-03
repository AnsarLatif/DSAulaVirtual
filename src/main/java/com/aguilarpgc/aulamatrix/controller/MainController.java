package com.aguilarpgc.aulamatrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aguilarpgc.aulamatrix.logic.UsuarioLogic;
import com.aguilarpgc.aulamatrix.logic.PerfilLogic;
import com.aguilarpgc.aulamatrix.model.Modulo;
import com.aguilarpgc.aulamatrix.model.Perfil;
import com.aguilarpgc.aulamatrix.model.Usuario;

@Controller
@RequestMapping(value="/admin")	
public class MainController {

	@Autowired
	UsuarioLogic usuarioLogic;
	
	@Autowired
	PerfilLogic perfilLogic;
	
	@RequestMapping(value="/index", method= RequestMethod.GET)
    public String dashboard(ModelMap modelMap) {

        String usuarioName = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario profesor = usuarioLogic.getUsuarioByUsername(usuarioName);

		Perfil perfil = perfilLogic.getPerfil(profesor.getPerfil().getId());
		
		/*List<Modulo> modulos = new ArrayList<Modulo>();
		
		for(Modulo modulo : perfil.getModulo()){
			modulos.add(modulo);
		}*/
		
		System.out.println("END");
		System.out.println("******************");
		
		modelMap.addAttribute("modulos", perfil.getModulo());
		
		return "index";
    }
	
}
