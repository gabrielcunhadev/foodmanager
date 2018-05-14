package com.gabrielcunha.foodmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcunha.foodmanager.model.Sanduiche;
import com.gabrielcunha.foodmanager.repository.SanduicheRepository;
import com.gabrielcunha.foodmanager.service.SanduicheService;

@Service
public class SanduicheServiceImpl implements SanduicheService{

	@Autowired
	private SanduicheRepository sanduicheRepository;
	
	@Override
	public Sanduiche salvar(Sanduiche sanduiche) {
		return sanduicheRepository.save(sanduiche);
	}

	@Override
	public Sanduiche atualizar(Sanduiche sanduiche) {
		return sanduicheRepository.save(sanduiche);
	}

	@Override
	public void deletar(Sanduiche sanduiche) {
		sanduicheRepository.delete(sanduiche);
	}

	@Override
	public void deletar(Long id) {
		sanduicheRepository.delete(id);
	}

	@Override
	public void deletarEmLote(List<Sanduiche> sanduiches) {
		sanduicheRepository.deleteInBatch(sanduiches);
	}

	@Override
	public Sanduiche pesquisarPorId(Long id) {
		return sanduicheRepository.findOne(id);
	}

	@Override
	public List<Sanduiche> listar() {
		return sanduicheRepository.findAll();
	}

	@Override
	public List<Sanduiche> findByNomeLike(String nome) {
		return sanduicheRepository.findByNomeLike(nome);
	}

	
}
