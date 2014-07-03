package com.aguilarpgc.aulamatrix.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Curso;

@Repository
@Transactional
public class CursoRepository extends HibernateRepository{
	
	public Curso getCurso(Integer id){
		return (Curso)getSession().get(Curso.class, id);
	}

}
