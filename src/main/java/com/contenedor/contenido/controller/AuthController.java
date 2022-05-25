package com.contenedor.contenido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contenedor.contenido.dao.UsuarioDao;
import com.contenedor.contenido.models.Usuario;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class AuthController {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@RequestMapping(value = "api/login", method = RequestMethod.POST)
	public String login(@RequestBody Usuario usuario) {
		
		if (usuarioDao.verificarEmailPassword(usuario)){
			return "OK";
		}
		return "FAIL";
	}

	
	
}
