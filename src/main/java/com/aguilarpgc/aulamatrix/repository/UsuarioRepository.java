package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import com.aguilarpgc.aulamatrix.model.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository{

    @Autowired
    private SessionFactory sessionFactory;

	public Usuario getUsuarioByUser(String user) {
		Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Usuario a where a.usuario = :usuario");
	    query.setParameter("usuario", user);
	    Usuario usuario = (Usuario) query.uniqueResult();

	    return usuario;
	}
	
	public void updateUsuario(Usuario usuario) {
	    Session session = sessionFactory.getCurrentSession();

	    session.saveOrUpdate(usuario);
    }

	public Usuario getUsuario(Integer idUsuario){
		Session session = sessionFactory.getCurrentSession();
		
		return (Usuario) session.get(Usuario.class, idUsuario);
	}
	    
	public List<Usuario> listUsuario(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		return criteria.list();
	}
	
}
