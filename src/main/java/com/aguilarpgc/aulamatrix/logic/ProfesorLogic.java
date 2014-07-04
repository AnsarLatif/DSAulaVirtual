package com.aguilarpgc.aulamatrix.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.CursoGrupo;
import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;
import com.aguilarpgc.aulamatrix.model.Trabajo;
import com.aguilarpgc.aulamatrix.model.Usuario;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoRepository;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoTipoRepository;
import com.aguilarpgc.aulamatrix.repository.CursoRepository;
import com.aguilarpgc.aulamatrix.repository.TrabajoRepository;
import com.aguilarpgc.aulamatrix.repository.UsuarioRepository;

@Service
public class ProfesorLogic {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	CursoGrupoRepository cursoGrupoRepository;
	
	@Autowired
	CursoGrupoTipoRepository cursoGrupoTipoRepository;

	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	TrabajoRepository trabajoRepository;
	
	public List<CursoGrupoTipo> listCursoGrupoTipo(){
        Usuario profesor = usuarioRepository.getCurrentUser();

        List<CursoGrupoTipo> lista = cursoGrupoTipoRepository.listCursoByProfesor(profesor.getId());
        
        
		return lista;
	}
	
	public List<Curso> listCursos(){
        Usuario profesor = usuarioRepository.getCurrentUser();

        List<CursoGrupoTipo> lista = cursoGrupoTipoRepository.listCursoByProfesor(profesor.getId());
        // Initialize list
        List<Curso> cursoLista = new ArrayList<Curso>();
        for(CursoGrupoTipo cgt : lista){
        	// Add curso
        	cursoLista.add(cursoRepository.getCurso(
        			cursoGrupoRepository.getCursoGrupo(cgt.getIdCursoGrupo()).getIdCurso()));
        }
        
        HashSet hs = new HashSet();
        hs.addAll(cursoLista);
        cursoLista.clear();
        cursoLista.addAll(hs);
        
		return cursoLista;
	}
	
	public List<Trabajo> listTrabajos(){
        Usuario profesor = usuarioRepository.getCurrentUser();
        
        List<CursoGrupoTipo> lista = cursoGrupoTipoRepository.listCursoByProfesor(profesor.getId());
        List<Trabajo> trabajos = new ArrayList<Trabajo>();
        
        for(CursoGrupoTipo cgt : lista){
        	
            trabajos.addAll(trabajoRepository.listTrabajoByCursoGrupoTipo(cgt.getId()));
        }
        
		return trabajos;
	}
	
	public Boolean isAsignado(CursoGrupoTipo token){
		Boolean asignado = false;
		
		for(CursoGrupoTipo cursoGrupoTipo : listCursoGrupoTipo()){
			if(token.getId() == cursoGrupoTipo.getId())
				asignado = true;
		}
		
		return asignado;
	}
	
}
