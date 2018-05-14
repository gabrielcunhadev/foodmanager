package com.gabrielcunha.foodmanager.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcunha.foodmanager.model.Ingrediente;
import com.gabrielcunha.foodmanager.model.Sanduiche;
import com.gabrielcunha.foodmanager.model.SanduicheXIngrediente;
import com.gabrielcunha.foodmanager.service.IngredienteService;
import com.gabrielcunha.foodmanager.service.SanduicheService;
import com.gabrielcunha.foodmanager.util.UtilMessages;
import com.gabrielcunha.foodmanager.util.UtilObjetos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * @author Gabriel Cunha
 * @since 01-05-2018
 */

@Service
public class CadastroSanduicheController implements Initializable{

	@FXML
	private TextField txfNome;
	
	@FXML
	private ComboBox<String> cbxTamanho;
	
	@FXML
	private ComboBox<String> cbxIngrediente;
	
	@FXML
	private TextField txfQuantidade;

	@FXML
	private TextField txfValor;
	
	@FXML
	private TableView<IngredienteTabela> tbvTabelaIngredientes;
	
	@FXML
	private TableColumn<IngredienteTabela, String>  colNomeIngrediente;

	@FXML
	private TableColumn<IngredienteTabela, Double>  colQuantidade;
	
	@FXML 
	private AnchorPane acpTelaPrincipal;
	
	@Autowired
	private IngredienteService ingredienteService;

	@Autowired
	private SanduicheService sanduicheService;
	
	private String nomeIngrediente;
	
	private Double quantidadeIngrediente;
	
	private ObservableList<IngredienteTabela> ingredientesTabela;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherComboboxIngredientes();
		preencherComboboxTamanho();
		associarColunasComPropriedade();
		txfNome.requestFocus();
	}


	@FXML
	private void onActionSalvarSanduba () {
		Sanduiche sanduiche = new Sanduiche();
		sanduiche.setNome(txfNome.getText());
		sanduiche.setTamanho(cbxTamanho.getValue());
		Double valor = Double.valueOf(txfValor.getText());
		sanduiche.setValor(new BigDecimal(valor));

		List<SanduicheXIngrediente> SanduichesXIngredientes = new ArrayList<>();
		
		ObservableList<IngredienteTabela> ingredientesAdicionadosTabela = tbvTabelaIngredientes.getItems();
		for (IngredienteTabela ingredienteTabela : ingredientesAdicionadosTabela) {
			if (! UtilObjetos.ehNuloOuVazio(ingredienteTabela)) {
				List<Ingrediente> ingredienteSalvo = ingredienteService.findByNomeLike(ingredienteTabela.getNome());
				
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setNome(ingredienteTabela.getNome());
				ingrediente.setId(ingredienteSalvo.get(0).getId());
				
				SanduicheXIngrediente sanduicheXIngrediente = new SanduicheXIngrediente();
				sanduicheXIngrediente.setQuantidadeIngrediente(ingredienteTabela.getQuantidadeIngrediente());
				sanduicheXIngrediente.setIngrediente(ingrediente);
				sanduicheXIngrediente.setSanduiche(sanduiche);
				
				SanduichesXIngredientes.add(sanduicheXIngrediente);
				limparTodosCampos();
				txfNome.requestFocus();
			}
		}
		sanduiche.getSanduichesXIngredientes().addAll(SanduichesXIngredientes);
		sanduicheService.salvar(sanduiche);
		tbvTabelaIngredientes.getItems().clear();
		
		UtilMessages.mensagem("Cadastro Sanduiche", "Cadastro Efetuado com sucesso!", null);
	}
	
	private void limparTodosCampos() {
		txfNome.clear();
		cbxTamanho.setValue(null);
		cbxIngrediente.setValue(null);
		txfQuantidade.clear();
		txfValor.clear();
	}


	@FXML
	private void onActionAdicionarIngrediente () {
		Boolean ehSomenteNumero = ehSomenteNumeros(txfQuantidade);

		if (UtilObjetos.ehNuloOuVazio(cbxIngrediente.getValue())) {
		
			UtilMessages.alerta("Erro de validação", "Campo INGREDIENTE não selecionado ou inválido!", "Selecione pelo menos um ingrediente.");
			cbxIngrediente.setValue(null);
			cbxIngrediente.requestFocus();

		} else if (! ehSomenteNumero || UtilObjetos.ehNuloOuVazio(txfQuantidade.getText())) {
			
			UtilMessages.alerta("Erro de validação", "Campo QUANTIDADE vazio ou com carateres inválidos!", "Campo quantidade só aceita números e não pode ser vazio . Preencha novamente.");
			txfQuantidade.clear();
			txfQuantidade.requestFocus();
			
		} else {
			pegaValoresView();
			
			IngredienteTabela ingredienteTabela = preencherIngredienteTabela();
			
			if (UtilObjetos.ehNuloOuVazio(ingredientesTabela)) {
				ingredientesTabela = FXCollections.observableArrayList();
			}
			
			ingredientesTabela.add(ingredienteTabela);
			
			tbvTabelaIngredientes.setItems(ingredientesTabela);
			
			limparCamposIngrediente();
			
			cbxIngrediente.requestFocus();
		}
	}


	private Boolean ehSomenteNumeros(TextField campo) {
	    String text = campo.getText();
	  
	    if (text.matches("[0-9]*")) {
	        return true;
	    }
	    
	    return false;
	}


	private void limparCamposIngrediente() {
		cbxIngrediente.setValue(null);
		txfQuantidade.clear();
	}


	private void pegaValoresView() {
		nomeIngrediente = cbxIngrediente.getValue();
		quantidadeIngrediente = Double.parseDouble(txfQuantidade.getText());
	}


	private IngredienteTabela preencherIngredienteTabela() {
		IngredienteTabela ingredienteTabela = new IngredienteTabela();
		ingredienteTabela.setNome(nomeIngrediente);
		ingredienteTabela.setQuantidadeIngrediente(quantidadeIngrediente);
		return ingredienteTabela;
	}




	private void associarColunasComPropriedade() {
		colNomeIngrediente.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadeIngrediente"));
	}


	private void preencherComboboxTamanho() {
		cbxTamanho.getItems().addAll("Super", "Grande", "Médio");
	}
	
	private void preencherComboboxIngredientes() {
		List<Ingrediente> ingredientes = FXCollections.observableArrayList();
		ingredientes = ingredienteService.listar();
		
		for (Ingrediente ingrediente : ingredientes ) {
			cbxIngrediente.getItems().add(ingrediente.getNome());
		}
	};
	
	
	public static class IngredienteTabela{
		private String nome;
		private Double quantidadeIngrediente;
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Double getQuantidadeIngrediente() {
			return quantidadeIngrediente;
		}
		public void setQuantidadeIngrediente(Double quantidadeIngrediente) {
			this.quantidadeIngrediente = quantidadeIngrediente;
		}
	}
	
}
