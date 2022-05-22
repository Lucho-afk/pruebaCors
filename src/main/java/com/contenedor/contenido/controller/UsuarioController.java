package com.contenedor.contenido.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contenedor.contenido.models.Usuario;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
public class UsuarioController {
	
	@RequestMapping(value = "usuario/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		Usuario usuario= new Usuario();
		usuario.setId(id);
		usuario.setNombre("Luciano");
		usuario.setApellido("Leone");
		usuario.setEmail("lucianoleone2011@hotmail.es");
		usuario.setTelefono("1164288026");
		return usuario;
	}
	
	@RequestMapping(value = "usuarios")
	public List<Usuario> getUsuarios() {
		
		List<Usuario> lstUsuarios= new ArrayList<>();
		
		Usuario usuario= new Usuario();
		usuario.setId(123);
		usuario.setNombre("Luciano");
		usuario.setApellido("Leone");
		usuario.setEmail("lucianoleone2011@hotmail.es");
		usuario.setTelefono("1164288026");
		
		Usuario usuario1= new Usuario();
		usuario1.setId(234);
		usuario1.setNombre("Sebastian");
		usuario1.setApellido("Midolo");
		usuario1.setEmail("seba@midolo.com");
		usuario1.setTelefono("1122334455");
		
		Usuario usuario2= new Usuario();
		usuario2.setId(345);
		usuario2.setNombre("Eric");
		usuario2.setApellido("Jimenez");
		usuario2.setEmail("eric@jimenez.com");
		usuario2.setTelefono("1199887766");
		
		lstUsuarios.add(usuario);
		lstUsuarios.add(usuario1);
		lstUsuarios.add(usuario2);
		
		return lstUsuarios;
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
	
	@RequestMapping(value = "usuario2")
	public Usuario eliminarUsuario() {
		Usuario usuario= new Usuario();
		usuario.setNombre("Luciano");
		usuario.setApellido("Leone");
		usuario.setEmail("lucianoleone2011@hotmail.es");
		usuario.setTelefono("1164288026");
		return usuario;
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
