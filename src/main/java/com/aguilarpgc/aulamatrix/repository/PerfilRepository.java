package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Perfil;

@Repository
@Transactional
public class PerfilRepository extends HibernateRepository{
	
	public Perfil getPerfil(Integer idPerfil){
		return (Perfil) getSession().get(Perfil.class, idPerfil);
	}
	
	public List<Perfil> listPerfil(){
		Criteria criteria = getSession().createCriteria(Perfil.class);
		return criteria.list();
	}	
}
