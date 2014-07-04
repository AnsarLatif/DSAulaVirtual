package com.aguilarpgc.aulamatrix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aguilarpgc.aulamatrix.logic.CursoGrupoTipoLogic;
import com.aguilarpgc.aulamatrix.logic.UsuarioLogic;
import com.aguilarpgc.aulamatrix.logic.PerfilLogic;
import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;
import com.aguilarpgc.aulamatrix.model.Modulo;
import com.aguilarpgc.aulamatrix.model.Perfil;
import com.aguilarpgc.aulamatrix.model.Usuario;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoTipoRepository;
import com.aguilarpgc.aulamatrix.view.UsuarioBean;
import com.aguilarpgc.aulamatrix.view.UsuarioSesionBean;

@Controller
@RequestMapping(value="/admin")
@SessionAttributes("usuario")
public class MainController{

	@Autowired
	UsuarioLogic usuarioLogic;
	
	@Autowired
	PerfilLogic perfilLogic;
	
	@Autowired
	public UsuarioSesionBean usuarioSesionBean;

	@Autowired
	CursoGrupoTipoLogic cursoGrupoTipoLogic;
	
	@RequestMapping(value="/index", method= RequestMethod.GET)
    public String dashboard(ModelMap modelMap) {

        String usuarioName = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario profesor = usuarioLogic.getUsuarioByUsername(usuarioName);

		Perfil perfil = perfilLogic.getPerfil(profesor.getPerfil().getId());
		
		/*List<Modulo> modulos = new ArrayList<Modulo>();
		
		for(Modulo modulo : perfil.getModulo()){
			modulos.add(modulo);
		}*/
		
		System.out.println("* Usuario : "+profesor.getId()+" "+profesor.getUsuario());
		
//		usuarioBean = new UsuarioBean();
		usuarioSesionBean.setId(profesor.getId());
		usuarioSesionBean.setNombre(profesor.getUsuario());

		System.out.println("END");
		System.out.println("******************");
		
		modelMap.addAttribute("allModules", perfil.getModulo());
		return "index";
    }
	
}
