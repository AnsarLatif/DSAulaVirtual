package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Perfil;
import com.aguilarpgc.aulamatrix.repository.PerfilRepository;

@Service
public class PerfilLogic {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	public Perfil getPerfil(Integer id){
		return perfilRepository.getPerfil(id);
	}
	
	public List<Perfil> listPerfil() {
      List<Perfil> listPerfil = perfilRepository.listPerfil();

      return listPerfil;
  }	
}
