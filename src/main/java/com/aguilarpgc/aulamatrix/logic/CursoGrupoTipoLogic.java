package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;
import com.aguilarpgc.aulamatrix.model.Usuario;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoTipoRepository;

@Service
public class CursoGrupoTipoLogic {
	
	@Autowired
	CursoGrupoTipoRepository cursoGrupoTipoRepository;
	
	public List<CursoGrupoTipo> getCursoGrupoTipo(Usuario profesor){

		System.out.print("asd1");
		return cursoGrupoTipoRepository.listCursoByProfesor(profesor.getId());
	}
	
}
