package com.aguilarpgc.aulamatrix.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Documento;

@Repository
@Transactional
public class DocumentoRepository extends HibernateRepository{
	
	public Documento getDocumento(Integer id){
	
		return (Documento)getSession().get(Documento.class, id);
	}

}
