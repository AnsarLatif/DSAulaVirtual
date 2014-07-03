package com.aguilarpgc.aulamatrix.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.Matricula;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoRepository;
import com.aguilarpgc.aulamatrix.repository.MatriculaRepository;
import com.aguilarpgc.aulamatrix.repository.UsuarioRepository;

@Service
public class AlumnoLogic {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	MatriculaRepository matriculaRepository;
	
	@Autowired
	CursoGrupoRepository cursoGrupoRepository;

	public List<Curso> listCursosMatriculados(){
		
		List<Curso> cursosList = new ArrayList<Curso>();
		
		for(Matricula matricula : matriculaRepository.getListMatricula
			 (usuarioRepository.getCurrentUser().getId())){

			Curso curso = new Curso();
			System.out.println("IOS: "+ cursoGrupoRepository.getCursoGrupo(matricula.getIdCursoGrupo()).getIdCurso());
			
			if(curso != null)
				cursosList.add(curso);
			
		}
		
		return cursosList;
		
	}
	
}
