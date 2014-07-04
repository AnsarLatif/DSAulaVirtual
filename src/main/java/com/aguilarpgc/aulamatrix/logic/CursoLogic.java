package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.CursoGrupo;
import com.aguilarpgc.aulamatrix.model.Grupo;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoRepository;
import com.aguilarpgc.aulamatrix.repository.CursoRepository;
import com.aguilarpgc.aulamatrix.repository.GrupoRepository;

@Service
public class CursoLogic {

	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@Autowired
	CursoGrupoRepository cursoGrupoRepository;

	public Curso getCurso(Integer id){
		return cursoRepository.getCurso(id);
	}
	public List<Curso> listCurso() {
      List<Curso> listCurso = cursoRepository.listCurso();

      return listCurso;
	}
	
	public Grupo getGrupo(Integer id){
		return grupoRepository.getGrupo(id);
	}
	
	public List<Grupo> getGrupoByCurso(Integer id){
		return grupoRepository.listGruposByCurso(id);
	}
	
	public CursoGrupo getCursoGrupo(Integer idGrupo, Integer idCurso){
		return cursoGrupoRepository.getCursoGrupo(idGrupo, idCurso);
	}
	
	public CursoGrupo getCursoGrupo(Integer id){
		return cursoGrupoRepository.getCursoGrupo(id);
	}
	
}
