package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;

@Repository
@Transactional
public class CursoGrupoTipoRepository extends HibernateRepository{
	
	public List<CursoGrupoTipo> listCursoByProfesor(String usuario){
		Criteria criteria = getSession().createCriteria(CursoGrupoTipo.class);
		criteria.add(Restrictions.eq("idUsuario", usuario));
		return criteria.list();
	}
	
	public List<CursoGrupoTipo> listByCursoGrupo(Integer cursoGrupoId){
		Criteria criteria = getSession().createCriteria(CursoGrupoTipo.class);
		criteria.add(Restrictions.eq("idCursoGrupo", cursoGrupoId));
		return criteria.list();
	}
	
	public CursoGrupoTipo getCursoGrupoTipo(Integer id){
		return (CursoGrupoTipo) getSession().get(CursoGrupoTipo.class, id);
	}

}
