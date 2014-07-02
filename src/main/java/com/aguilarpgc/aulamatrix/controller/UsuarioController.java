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
import com.aguilarpgc.aulamatrix.model.Usuario;
import com.aguilarpgc.aulamatrix.repository.UsuarioRepository;
import com.aguilarpgc.aulamatrix.util.Caster;
import com.aguilarpgc.aulamatrix.view.UsuarioBean;

@Controller
@RequestMapping(value = "admin/usuario")
public class UsuarioController {

	@Autowired
	UsuarioLogic usuarioLogic;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String listUsuarios(ModelMap modelMap){
		List<Usuario> usuarios = usuarioLogic.listUsuario();
		List<UsuarioBean> usuariosBeans = new ArrayList<UsuarioBean>();
		
		for(Usuario usuario : usuarios) {
            if(usuario != null){
            	usuario = usuarioLogic.getUsuario(usuario.getId());
            	UsuarioBean bean = Caster.usuarioModelToBean(usuario);
            	usuariosBeans.add(bean);
            }
        }
        modelMap.addAttribute("usuarios", usuariosBeans);
		return "/usuario/list";
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public String prefilUsuario(ModelMap modelMap){

        String usuarioName = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario alumno = usuarioRepository.getUsuarioByUser(usuarioName);
		
        UsuarioBean bean = Caster.usuarioModelToBean(alumno);
        modelMap.addAttribute("usuario", bean);
		return "/usuario/perfil";
	}
	
}