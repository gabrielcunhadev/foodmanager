package com.gabrielcunha.foodmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcunha.foodmanager.model.Usuario;
import com.gabrielcunha.foodmanager.repository.UsuarioRepository;
import com.gabrielcunha.foodmanager.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario atualizar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deletar(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	@Override
	public void deletar(Long id) {
		usuarioRepository.delete(id);
	}

	@Override
	public void deletarEmLote(List<Usuario> usuarios) {
		usuarioRepository.deleteInBatch(usuarios);
	}

	@Override
	public Usuario pesquisarPorId(Long id) {
		return usuarioRepository.findOne(id);
	}

	@Override
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@Override
	public boolean autenticar(String email, String senha) {
		Usuario usuario = this.BuscarPorEmail(email);
		
		if (usuario == null) {
			return false;
		} else {
			if (senha.equals(usuario.getSenha()) ) {
				return true;
			} else {
				return false;
			}
		}
		
	}

	@Override
	public Usuario BuscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public List<Usuario> findByNomeLike(String nome) {
		return usuarioRepository.findByNomeLike(nome);
	}

}
