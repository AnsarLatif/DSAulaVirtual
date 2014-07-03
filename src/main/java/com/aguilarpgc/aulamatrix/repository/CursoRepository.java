package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Curso;

@Repository
@Transactional
public class CursoRepository extends HibernateRepository{

	public List<Curso> listCurso(){
		Criteria criteria = getSession().createCriteria(Curso.class);
		return criteria.list();
	}
	
	public void addOrUpdateCurso(Curso curso){
		getSession().saveOrUpdate(curso);
	}
	
	public void updateCurso(Curso curso){
		getSession().update(curso);
	}
	
	public Curso getCurso(Integer idCurso){
		return (Curso) getSession().get(Curso.class, idCurso);
	}
}
