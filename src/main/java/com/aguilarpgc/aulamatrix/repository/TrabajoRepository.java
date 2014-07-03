package com.aguilarpgc.aulamatrix.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Trabajo;

@Repository
@Transactional
public class TrabajoRepository extends HibernateRepository{
	
	public Trabajo getTrabajo(Integer id){
		
		return (Trabajo)getSession().get(Trabajo.class, id);
	}

}
