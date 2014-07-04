package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.CursoGrupo;

@Repository
@Transactional
public class CursoGrupoRepository extends HibernateRepository{
	
	public CursoGrupo getCursoGrupo(Integer id){
		
		return (CursoGrupo)getSession().get(CursoGrupo.class, id);
	}
	
	public CursoGrupo getCursoGrupo(Integer idGrupo, Integer idCurso){
		CursoGrupo cursoGrupo = null;
		Criteria filter = getSession().createCriteria(CursoGrupo.class);
		filter.add(Restrictions.eq("idGrupo", idGrupo))
				.add(Restrictions.eq("idCurso", idCurso));
		List<CursoGrupo> cursosgrupos = filter.list();
		if(cursosgrupos!=null && cursosgrupos.size()>0){
			cursoGrupo = cursosgrupos.get(0);
		}
		return cursoGrupo;
	}
	
}
