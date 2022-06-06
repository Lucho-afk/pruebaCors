package com.contenedor.contenido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contenedor.contenido.dao.UsuarioDao;
import com.contenedor.contenido.models.Usuario;
import com.contenedor.contenido.utils.JWTUtil;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class AuthController {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value = "api/login", method = RequestMethod.POST)
	public String login(@RequestBody Usuario usuario) {
		
		Usuario usuarioLog =usuarioDao.obtenerUsuarioPorCredenciales(usuario);
		
		if (usuarioLog!=null){
			
			String tokenJwt =jwtUtil.create((String.valueOf(usuarioLog.getId())) ,usuarioLog.getEmail());
			
			return tokenJwt;
		}
		return "FAIL";
	}

	
	
}
