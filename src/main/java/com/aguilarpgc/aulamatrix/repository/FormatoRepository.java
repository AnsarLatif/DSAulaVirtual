package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Formato;

@Repository
@Transactional
public class FormatoRepository extends HibernateRepository{
	
	
	public Formato getFormato(Integer id){
		
		return (Formato) getSession().get(Formato.class, id);
	}
	
	public List<Formato> list(){
		Criteria criteria = getSession().createCriteria(Formato.class);
		return criteria.list();
	}
}
