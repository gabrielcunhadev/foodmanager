package com.gabrielcunha.foodmanager.generic;

import java.util.List;

/**
 * @author Gabriel Cunha
 * @since 30-04-2018
 */
public interface GenericService<T extends Object> {

		T salvar(T entidade);
		
		T atualizar(T entidade);
		
		void deletar(T entidade);
		
		void deletar(Long id);
		
		void deletarEmLote(List<T> entidades);
		
		T pesquisarPorId(Long id);
		
		List<T> listar();
		
		List<T> findByNomeLike(String nome);
}
