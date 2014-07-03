package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Nota;

@Repository
@Transactional
public class NotaRepository extends HibernateRepository{
	
	public List<Nota> notasByUser(String username){

		Criteria criteria = getSession().createCriteria(Nota.class);
		criteria.add(Restrictions.eq("usuario", username));
		return criteria.list();
	}

}
