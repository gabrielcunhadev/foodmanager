package com.gabrielcunha.foodmanager.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class UtilObjetos {

	/**
	 * Retorna true se a coleção for nula ou vazia
	 * @param collection
	 * @return true | false
	 */
	public static Boolean ehNuloOuVazio(Collection<?> colecao) {
			if (colecao == null || colecao.isEmpty() || colecao.size() == 0) {
				return true;
			} 
		return false;
	}

	/**
	 * Retorna true se a objeto for nulo ou vazio
	 * @param Object
	 * @return true | false
	 */
	public static Boolean ehNuloOuVazio(Object objeto) {
			if (objeto == null) {
				return true;
			} 
		return false;
	}
	
	/**
	 * Retorna true se um array de objeto for nulo ou vazio
	 * @param Object[]
	 * @return true | false
	 */
	public static Boolean ehNuloOuVazio(Object[] objeto) {
			if (objeto == null || objeto.length == 0){
				return true;
			} 
		return false;
	}
	
	/**
	 * Retorna true se a string for nulo ou vazio
	 * @param String
	 * @return true | false
	 */
	public static Boolean ehNuloOuVazio(String string) {
			if (string == null || string.isEmpty()) {
				return true;
			} 
		return false;
	}
	
	/**
	 * Retorna true se a inteiro for nulo ou vazio
	 * @param Integer
	 * @return true | false
	 */
	public static Boolean ehNuloOuVazio(Integer inteiro) {
			if (inteiro == null) {
				return true;
			} 
		return false;
	}
	
	/**
	 * Retorna true se a lista for nulo ou vazio
	 * @param List
	 * @return true | false
	 */
	public static Boolean ehNuloOuVazio(List<?> lista) {
			if (lista == null || lista.isEmpty()) {
				return true;
			} 
		return false;
	}
	
	/**
	 * Retorna true se o mapa for nulo ou vazio
	 * @param Map
	 * @return true | false
	 */
	public static Boolean ehNuloOuVazio(HashMap<?, ?> mapa) {
			if (mapa == null || mapa.isEmpty()) {
				return true;
			} 
		return false;
	}
	
}
