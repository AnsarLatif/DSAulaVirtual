package com.aguilarpgc.aulamatrix.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Documento;
import com.aguilarpgc.aulamatrix.model.Trabajo;
import com.aguilarpgc.aulamatrix.repository.DocumentoRepository;
import com.aguilarpgc.aulamatrix.repository.TrabajoRepository;

@Service
public class DocumentoLogic {

	@Autowired
	DocumentoRepository documentoRepository;

	@Autowired
	TrabajoRepository trabajoRepository;

	public Documento getDocumento(Integer id){
		return documentoRepository.getDocumento(id);
	}
	

	public Trabajo getTrabajo(Documento documento){
		
		
		return trabajoRepository.getTrabajo(documento.getTrabajo());
	}
	
	
}
