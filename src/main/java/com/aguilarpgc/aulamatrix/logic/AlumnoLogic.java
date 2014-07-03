package com.aguilarpgc.aulamatrix.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.CursoGrupo;
import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;
import com.aguilarpgc.aulamatrix.model.Matricula;
import com.aguilarpgc.aulamatrix.model.Nota;
import com.aguilarpgc.aulamatrix.model.Trabajo;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoRepository;
import com.aguilarpgc.aulamatrix.repository.CursoGrupoTipoRepository;
import com.aguilarpgc.aulamatrix.repository.CursoRepository;
import com.aguilarpgc.aulamatrix.repository.MatriculaRepository;
import com.aguilarpgc.aulamatrix.repository.NotaRepository;
import com.aguilarpgc.aulamatrix.repository.TrabajoRepository;
import com.aguilarpgc.aulamatrix.repository.UsuarioRepository;

@Service
public class AlumnoLogic {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	MatriculaRepository matriculaRepository;
	
	@Autowired
	CursoGrupoTipoRepository cursoGrupoTipoRepository;

	@Autowired
	CursoGrupoRepository cursoGrupoRepository;

	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	NotaRepository notaRepository;
	
	@Autowired
	TrabajoRepository trabajoRepository;
	
	public List<Trabajo> listTrabajos(){

		List<Trabajo> trabajos = new ArrayList<Trabajo>();
		
		for(Matricula matricula : matriculaRepository.getListMatricula
				 (usuarioRepository.getCurrentUser().getId())){
			
			CursoGrupo cursoGrupo = cursoGrupoRepository.getCursoGrupo(matricula.getIdCursoGrupo());
			for(CursoGrupoTipo cgt : cursoGrupoTipoRepository.listByCursoGrupo(cursoGrupo.getId())){
				trabajos.addAll(trabajoRepository.listTrabajoByCursoGrupoTipo(cgt.getId()));
			}
		}
		
		return trabajos;
	}
	
	public List<Curso> listCursosMatriculados(){
		
		List<Curso> cursosList = new ArrayList<Curso>();
		
		for(Matricula matricula : matriculaRepository.getListMatricula
			 (usuarioRepository.getCurrentUser().getId())){
			
			CursoGrupo cursoGrupo = cursoGrupoRepository.getCursoGrupo(matricula.getIdCursoGrupo());
			if(cursoGrupo != null){
				Curso curso = new Curso();
				curso = cursoRepository.getCurso(cursoGrupo.getIdCurso());
				cursosList.add(curso);
			}
		}
		
		return cursosList;
	}
	
	public Boolean isMatriculado(Curso token){
		
		Boolean matriculado = false;
		for(Curso curso : listCursosMatriculados()){
			if(token.getId() == curso.getId())
				matriculado = true;
		}
		
		return matriculado;
	}
	
	public List<Nota> listNotasTrabajo(){
		
		return notaRepository.notasByUser(usuarioRepository.getCurrentUser().getId());
	}
	
}
