package com.gabrielcunha.foodmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielcunha.foodmanager.model.Sanduiche;

@Repository
public interface SanduicheRepository extends JpaRepository<Sanduiche, Long>{
	
	List<Sanduiche> findByNomeLike(String nome);

}
