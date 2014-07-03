package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Matricula;
import com.aguilarpgc.aulamatrix.repository.MatriculaRepository;
import com.aguilarpgc.aulamatrix.repository.UsuarioRepository;

@Service
public class AlumnoLogic {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	MatriculaRepository matriculaRepository;

	public List<Matricula> listCursosMatriculados(){
		
		return matriculaRepository.getListMatricula(usuarioRepository.getCurrentUser().getId());
		
	}
	
}
