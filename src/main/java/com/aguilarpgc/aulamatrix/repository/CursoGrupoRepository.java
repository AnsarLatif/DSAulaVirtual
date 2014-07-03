package com.aguilarpgc.aulamatrix.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.CursoGrupo;

@Repository
@Transactional
public class CursoGrupoRepository extends HibernateRepository{
	
	public CursoGrupo getCursoGrupo(Integer id){
		
		return (CursoGrupo)getSession().get(CursoGrupo.class, id);
	}
	
}
