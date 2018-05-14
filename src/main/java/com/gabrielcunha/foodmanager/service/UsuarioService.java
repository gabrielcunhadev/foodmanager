package com.gabrielcunha.foodmanager.service;

import com.gabrielcunha.foodmanager.generic.GenericService;
import com.gabrielcunha.foodmanager.model.Usuario;

public interface UsuarioService extends GenericService<Usuario>{
	
	boolean autenticar(String email, String senha);
	
	Usuario BuscarPorEmail(String email);

}
