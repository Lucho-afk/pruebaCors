package com.contenedor.contenido.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contenedor.contenido.dao.UsuarioDao;
import com.contenedor.contenido.models.Usuario;
import com.contenedor.contenido.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@RequestMapping(value = "api/usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		
		Usuario usuario= new Usuario();
		usuario.setId(id);
		usuario.setNombre("Luciano");
		usuario.setApellido("Leone");
		usuario.setEmail("lucianoleone2011@hotmail.es");
		usuario.setTelefono("1164288026");
		
		return usuario;
	}
	
	@RequestMapping(value = "api/usuarios" , method = RequestMethod.GET)
	public List<Usuario> getUsuarios(@RequestHeader(value = "authorization")String token) {
		
		String usuarioid = jwtUtil.getKey(token);
		if(usuarioid == null) {
			return new ArrayList<Usuario>();
		}
		return usuarioDao.getUsuarios();
	}
	
	@RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
	public void registrarUsuarios(@RequestBody Usuario usuario) {
		
		Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash=argon2.hash(1, 1024, 1, usuario.getPassword());
		usuario.setPassword(hash);
		usuarioDao.registrarUsuarios(usuario);
	}
	
	
	@RequestMapping(value = "usuario1")
	public Usuario editarUsuario() {
		Usuario usuario= new Usuario();
		usuario.setNombre("Luciano");
		usuario.setApellido("Leone");
		usuario.setEmail("lucianoleone2011@hotmail.es");
		usuario.setTelefono("1164288026");
		return usuario;
	}
	
	@RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable long id ) {
		usuarioDao.eliminar(id);
	}
	
	@RequestMapping(value = "usuario3")
	public Usuario buscarUsuario() {
		Usuario usuario= new Usuario();
		usuario.setNombre("Luciano");
		usuario.setApellido("Leone");
		usuario.setEmail("lucianoleone2011@hotmail.es");
		usuario.setTelefono("1164288026");
		return usuario;
	}
	
}
