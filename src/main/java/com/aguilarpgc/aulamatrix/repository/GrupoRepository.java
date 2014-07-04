package com.aguilarpgc.aulamatrix.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.CursoGrupo;
import com.aguilarpgc.aulamatrix.model.Grupo;

@Repository
@Transactional
public class GrupoRepository extends HibernateRepository{

	public List<Grupo> listGruposByCurso(Integer idCurso){
		Criteria criteria = getSession().createCriteria(CursoGrupo.class);
		criteria.add(Restrictions.eq("idCurso", idCurso));
		
		List<CursoGrupo> cursoGrupos = criteria.list();
		List<Grupo> grupos = new ArrayList<Grupo>();
		
		for(CursoGrupo cursoGrupo : cursoGrupos){
			Grupo grupo = (Grupo) getSession().get(Grupo.class, cursoGrupo.getIdGrupo());
			if(grupo!=null && grupo.getNombre()!=null){
				grupos.add(grupo);
			}
		}
		
		
		return grupos;
	}
	
	public Grupo getGrupo(Integer id){
		return (Grupo) getSession().get(Grupo.class, id);
	}
	
}
