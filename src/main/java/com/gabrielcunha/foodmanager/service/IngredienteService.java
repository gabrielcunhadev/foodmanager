package com.gabrielcunha.foodmanager.service;

import java.util.List;

import com.gabrielcunha.foodmanager.generic.GenericService;
import com.gabrielcunha.foodmanager.model.Ingrediente;

public interface IngredienteService extends GenericService<Ingrediente>{

	List<Ingrediente> findByNomeLike(String nome);
	
}
