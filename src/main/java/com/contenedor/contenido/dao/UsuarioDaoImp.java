package com.contenedor.contenido.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contenedor.contenido.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Usuario> getUsuarios() {
		String query="from Usuario";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void eliminar(long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
	}

	@Override
	public void registrarUsuarios(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean verificarEmailPassword(Usuario usuario) {
		String query="from Usuario WHERE email= :email ";
		List<Usuario> lista = entityManager.createQuery(query)
				.setParameter("email", usuario.getEmail())
				.getResultList();
		
		if (lista.isEmpty()) {
			return false;
		}
		
		String passwordHashed= lista.get(0).getPassword();
		Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		
		return argon2.verify(passwordHashed, usuario.getPassword());
		
	}


}
