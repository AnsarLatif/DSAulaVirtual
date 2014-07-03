package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Matricula;

@Repository
@Transactional
public class MatriculaRepository extends HibernateRepository{
	
	public void addOrUpdateMatricula(Matricula matricula){
        System.out.println("Guardando matricula ....");
        getSession().saveOrUpdate(matricula);
	}
	
	public Matricula getMatricula(Integer id){
		return (Matricula) getSession().get(Matricula.class, id);
	}
	
	public List<Matricula> getListMatricula(String id) {
		
		Criteria criteria = getSession().createCriteria(Matricula.class);
		criteria.add(Restrictions.eq("idUsuario", id));
		return criteria.list();
	}
	
	
	
}
