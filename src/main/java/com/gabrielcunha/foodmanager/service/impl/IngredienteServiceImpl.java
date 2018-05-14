package com.gabrielcunha.foodmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcunha.foodmanager.model.Ingrediente;
import com.gabrielcunha.foodmanager.repository.IngredienteRepository;
import com.gabrielcunha.foodmanager.service.IngredienteService;

@Service
public class IngredienteServiceImpl implements IngredienteService{

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public Ingrediente salvar(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}

	@Override
	public Ingrediente atualizar(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}

	@Override
	public void deletar(Ingrediente ingrediente) {
		ingredienteRepository.delete(ingrediente);
	}

	@Override
	public void deletar(Long id) {
		ingredienteRepository.delete(id);
	}

	@Override
	public void deletarEmLote(List<Ingrediente> ingredientes) {
		ingredienteRepository.deleteInBatch(ingredientes);
	}

	@Override
	public Ingrediente pesquisarPorId(Long id) {
		return ingredienteRepository.findOne(id);
	}

	@Override
	public List<Ingrediente> listar() {
		return ingredienteRepository.findAll();
	}

	@Override
	public List<Ingrediente> findByNomeLike(String nome) {
		return ingredienteRepository.findByNomeLike(nome);
	}

}
