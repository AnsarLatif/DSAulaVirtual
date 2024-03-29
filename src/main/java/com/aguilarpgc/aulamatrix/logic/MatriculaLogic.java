package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Matricula;
import com.aguilarpgc.aulamatrix.repository.MatriculaRepository;

@Service
public class MatriculaLogic {
	
	@Autowired
	MatriculaRepository matriculaRepository;
	
	/*public List<Curso> getCursosByMatricula(Integer id){

		Matricula matricula = matriculaRepository.getMatricula(id);

		
	}*/
	
	public void addMatricula(Matricula matricula){
		
		
		matriculaRepository.addOrUpdateMatricula(matricula);
	}
	
	public List<Matricula> getMatriculaByAlumno(String id){
		
		return matriculaRepository.getListMatricula(id);
	}

}
