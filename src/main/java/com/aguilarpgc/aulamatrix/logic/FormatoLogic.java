package com.aguilarpgc.aulamatrix.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Formato;
import com.aguilarpgc.aulamatrix.repository.FormatoRepository;


@Service
public class FormatoLogic {

	@Autowired
	FormatoRepository formatoRepository;
	
	public boolean isValid(String token){
		
		for(Formato formato : formatoRepository.list()){
			if(formato.getFormato().equals(token))
				return false;
		}
		return true;
	}
	
}
