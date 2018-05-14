package com.gabrielcunha.foodmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sanduiche_x_ingrediente")
public class SanduicheXIngrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "qtd_ingrediente")
    private Double quantidadeIngrediente;
   
    @ManyToOne
    @JoinColumn(name="sanduiche_id")
    private Sanduiche sanduiche;

	@ManyToOne
	@JoinColumn(name="ingrediente_id")
	private Ingrediente ingrediente;
      
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidadeIngrediente() {
		return quantidadeIngrediente;
	}

	public void setQuantidadeIngrediente(Double quantidadeIngrediente) {
		this.quantidadeIngrediente = quantidadeIngrediente;
	}

	public Sanduiche getSanduiche() {
		return sanduiche;
	}

	public void setSanduiche(Sanduiche sanduiche) {
		this.sanduiche = sanduiche;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

}
