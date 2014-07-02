package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.repository.CursoRepositoy;

@Service
public class CursoLogic {

	@Autowired
	CursoRepositoy cursoRepository;
	
	public Curso getCurso(Integer id){
		return cursoRepository.getCurso(id);
	}
	public List<Curso> listCurso() {
      List<Curso> listCurso = cursoRepository.listCurso();

      return listCurso;
  }	
}
