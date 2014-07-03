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
        Usuario profesor = usuarioRepository.getCurrentUser();
        
        List<CursoGrupoTipo> lista = cursoGrupoTipoRepository.listCursoByProfesor(profesor);
        System.out.println("Profesor :"+profesor.getId()+" "+profesor.getNombre());

        
        for(CursoGrupoTipo cgt : lista){
            System.out.println("CGT :"+cgt.getId()+" "+cgt.getIdCursoGrupo());
        }
        
		return lista;
	}
	
}
