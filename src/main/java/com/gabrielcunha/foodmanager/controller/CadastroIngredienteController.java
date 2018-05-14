package com.gabrielcunha.foodmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gabrielcunha.foodmanager.model.Ingrediente;
import com.gabrielcunha.foodmanager.service.IngredienteService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

@Controller
public class CadastroIngredienteController implements Initializable{

	@FXML
	private TextField txfNome;

	@Autowired
	private IngredienteService ingredienteService;
	
	private Ingrediente ingrediente;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		inicializaObjetos();
	}
	

	@FXML
	private void onActionSalvar () {
		ingrediente = new Ingrediente();
		ingrediente.setNome(txfNome.getText());
		
		ingredienteService.salvar(ingrediente);
		
		txfNome.setText("");
		txfNome.requestFocus();
	}

	private void inicializaObjetos() {
		
	}
	
	
}
