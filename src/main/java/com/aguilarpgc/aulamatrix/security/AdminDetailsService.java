package com.aguilarpgc.aulamatrix.security;

import com.aguilarpgc.aulamatrix.model.Administrator;
import com.aguilarpgc.aulamatrix.repository.AdminRepository;
import com.aguilarpgc.aulamatrix.model.Usuario;
import com.aguilarpgc.aulamatrix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabiosalasm on 16/03/14.
 */
@Service
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.getUsuarioByUser(username);

        if (usuario == null){
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"));

        User user = new User(usuario.getUsuario(), usuario.getContrasenia(), true, true, true, true, authorities);

        return user;
    }
}
