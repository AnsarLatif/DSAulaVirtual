package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;
import com.aguilarpgc.aulamatrix.model.Usuario;

@Repository
@Transactional
public class CursoGrupoTipoRepository extends HibernateRepository{
	
	public List<CursoGrupoTipo> listCursoByProfesor(Usuario usuario){
		Criteria criteria = getSession().createCriteria(CursoGrupoTipo.class);
		criteria.add(Restrictions.eq("idUsuario", usuario.getId()));
		return criteria.list();
	}

}
