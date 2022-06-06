package com.contenedor.contenido.dao;

import java.util.List;

import com.contenedor.contenido.models.Usuario;

public interface UsuarioDao {
	List<Usuario> getUsuarios();

	void eliminar(long id);

	void registrarUsuarios(Usuario usuario);

	Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

	

}
