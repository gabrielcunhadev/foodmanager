package com.gabrielcunha.foodmanager.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gabrielcunha.foodmanager.util.UtilObjetos;

@Entity
@Table(name = "sanduiche")
public class Sanduiche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String tamanho;
	
	private BigDecimal valor;
	
    @OneToMany(mappedBy="sanduiche", cascade = CascadeType.ALL)
	private List<SanduicheXIngrediente> sanduichesXIngredientes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public List<SanduicheXIngrediente> getSanduichesXIngredientes() {
		if (UtilObjetos.ehNuloOuVazio(this.sanduichesXIngredientes)) {
			this.sanduichesXIngredientes = new ArrayList<>();
		}
		return sanduichesXIngredientes;
	}

	public void setSanduichesXIngredientes(List<SanduicheXIngrediente> sanduichesXIngredientes) {
		this.sanduichesXIngredientes = sanduichesXIngredientes;
	}
	
}
