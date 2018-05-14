package com.gabrielcunha.foodmanager.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gabrielcunha.foodmanager.model.Sanduiche;
import com.gabrielcunha.foodmanager.service.SanduicheService;
import com.gabrielcunha.foodmanager.util.UtilMessages;
import com.gabrielcunha.foodmanager.util.UtilObjetos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


@Controller
public class VendaController implements Initializable{

	@FXML
	private TextField txfCodigo;
	
	@FXML
	private TextField txfNomeSanduiche;
	
	@FXML
	private TextField txfTotal;
	
	@FXML
	private TableView<SanduicheTabela> tbvSanduiches;
	
	@FXML
	private TableColumn<SanduicheTabela, Long> colCodigo;
	
	@FXML
	private TableColumn<SanduicheTabela, String> colNome;
	
	@FXML
	private TableColumn<SanduicheTabela, Integer> colQuantidade;
	
	@FXML
	private TableColumn<SanduicheTabela, BigDecimal> colSubtotal;
	
	@FXML
	private Button btnAdicionarSanduiche;
	
	@FXML
	private TextField txfQuantidade;
	
	@FXML 
	private AnchorPane acpTelaPrincipal;
	
	@Autowired
	private SanduicheService sanduicheService;
	
	private ObservableList<SanduicheTabela> sanduichesTabela;
	
	private Double somaTotal = 0.0;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		associarColunasComPropriedade();
	}
	
	@FXML
	public void onActionAdicionarSanduicheTabela () {

		Long id = Long.valueOf(txfCodigo.getText());
		Sanduiche sanduicheSalvo = sanduicheService.pesquisarPorId(id);
		
		SanduicheTabela sanduicheTabela = new SanduicheTabela();
		sanduicheTabela.setId(sanduicheSalvo.getId());
		sanduicheTabela.setNome(sanduicheSalvo.getNome());
		
		Integer quantidadeSanduiche = Integer.valueOf(txfQuantidade.getText());
		BigDecimal quantidade = BigDecimal.valueOf(quantidadeSanduiche);
		BigDecimal valor = ! UtilObjetos.ehNuloOuVazio(sanduicheSalvo.getValor()) ? sanduicheSalvo.getValor() : BigDecimal.ZERO;
		BigDecimal subtotal =  quantidade.multiply(valor).setScale(BigDecimal.ROUND_DOWN);
		
		Double subSoma = subtotal.doubleValue();
		somaTotal += subSoma;
		
		sanduicheTabela.setQuantidadeSandduiche(quantidadeSanduiche);
		sanduicheTabela.setSubtotal(subtotal);
		
		
		if (UtilObjetos.ehNuloOuVazio(sanduichesTabela)) {
			sanduichesTabela = FXCollections.observableArrayList();
		}
			
		sanduichesTabela.add(sanduicheTabela);
		
		tbvSanduiches.setItems(sanduichesTabela);
			
		limparCamposSanduiche();
			
		txfCodigo.requestFocus();
	}
	
	private void limparCamposSanduiche() {
		txfCodigo.clear();
		txfNomeSanduiche.clear();
		txfTotal.clear();
		txfQuantidade.clear();
	}

	@FXML
	public void onActionFiinalizarVenda() {
		BigDecimal total = BigDecimal.ZERO;
		
		ObservableList<SanduicheTabela> sanduichesTabela = tbvSanduiches.getItems();
		
		for (SanduicheTabela sanduicheTabela : sanduichesTabela) {
			total  = total.add(sanduicheTabela.getSubtotal());
		}
		
		tbvSanduiches.getItems().clear();
		
		limparCamposSanduiche();
		
		txfTotal.clear();
		somaTotal = 0.0;
		
		UtilMessages.alerta("Fehchamento de venda", "Venda efetuada!", null);
	
	}
	
	@FXML
	protected void onKeyPressCarregaSanduiche(KeyEvent event) {
		
		if (event.getCode() == KeyCode.TAB || event.getCode() == KeyCode.ENTER) {
			Long id = Long.valueOf(txfCodigo.getText());
			Sanduiche sanduicheSalvo = sanduicheService.pesquisarPorId(id);
	    	
			txfNomeSanduiche.setText(sanduicheSalvo.getNome());
			txfQuantidade.requestFocus();
	        event.consume();
	    }

	}
	
	@FXML
	private void onActionSomar() {
		txfTotal.clear();
		txfTotal.setText(somaTotal.toString());
		
		
	}
	
	private void associarColunasComPropriedade() {
		colCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadeSandduiche"));
		colSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
	}
	
	
	public static class SanduicheTabela{
		private Long id;
		private String nome;
		private Integer quantidadeSandduiche;
		private BigDecimal subtotal;
		
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
		public Integer getQuantidadeSandduiche() {
			return quantidadeSandduiche;
		}
		public void setQuantidadeSandduiche(Integer quantidadeSandduiche) {
			this.quantidadeSandduiche = quantidadeSandduiche;
		}
		public BigDecimal getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(BigDecimal subtotal) {
			this.subtotal = subtotal;
		}
	}
	
	private Boolean ehSomenteNumeros(TextField campo) {
	    String text = campo.getText();
	  
	    if (text.matches("[0-9]*")) {
	        return true;
	    }
	    
	    return false;
	}
}
