package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Trabajo;

@Repository
@Transactional
public class TrabajoRepository extends HibernateRepository{
	
	public Trabajo getTrabajo(Integer id){
		
		return (Trabajo)getSession().get(Trabajo.class, id);
	}
	
	public List<Trabajo> listTrabajoByCursoGrupoTipo(Integer id){

		Criteria criteria = getSession().createCriteria(Trabajo.class);
		criteria.add(Restrictions.eq("idCursoGrupoTipo", id));
		return criteria.list();
		
	}

}
