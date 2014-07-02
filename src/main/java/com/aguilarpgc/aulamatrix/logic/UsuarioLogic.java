package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Usuario;
import com.aguilarpgc.aulamatrix.repository.UsuarioRepository;

@Service
public class UsuarioLogic {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario getUsuario(Integer id){
		return usuarioRepository.getUsuario(id);
	}
	
	public List<Usuario> listUsuario() {
      List<Usuario> listUsuario = usuarioRepository.listUsuario();

      return listUsuario;
   }	
	
	@Transactional
    public void updateContrasenia(String rawContrasenia) {

        String usuarioName = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = usuarioRepository.getUsuarioByUser(usuarioName);

        ShaPasswordEncoder pwdEncoder = new ShaPasswordEncoder();
        usuario.setContrasenia(pwdEncoder.encodePassword(rawContrasenia, null));

        usuarioRepository.updateUsuario(usuario);
    }
	
}
