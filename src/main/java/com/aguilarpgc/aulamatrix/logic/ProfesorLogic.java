package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;
import com.aguilarpgc.aulamatrix.model.Usuario;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoTipoRepository;
import com.aguilarpgc.aulamatrix.repository.UsuarioRepository;

@Service
public class ProfesorLogic {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	CursoGrupoTipoRepository cursoGrupoTipoRepository;
	
	public List<CursoGrupoTipo> listCurso(){
        String usuarioName = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario profesor = usuarioRepository.getUsuarioByUser(usuarioName);
        
        System.out.println("ASDASD 1:"+profesor.getId()+" "+profesor.getNombre());
        List<CursoGrupoTipo> lista = cursoGrupoTipoRepository.listCursoByProfesor(profesor);
        System.out.println("ASDASD 2:"+profesor.getId()+" "+profesor.getNombre());

		return lista;
	}
	
}
