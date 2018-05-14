package com.gabrielcunha.foodmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielcunha.foodmanager.model.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
	
	List<Ingrediente> findByNomeLike(String nome);
	
}
