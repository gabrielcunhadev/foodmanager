package com.gabrielcunha.foodmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.gabrielcunha.foodmanager.config.StageManager;
import com.gabrielcunha.foodmanager.view.FxmlView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

@Controller
public class CadastrosController implements Initializable{
	
	@FXML 
	private AnchorPane acpTelaPrincipal;
	
	@FXML 
	private Label lbTituloTela;
	
    @Lazy
    @Autowired
    private StageManager stageManager;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		lbTituloTela.setText("Cadastros");
	}
	
	@FXML
	private void onActonAbrirCadastroIngrediente() {
		
		Parent rootNode = stageManager.getNodeRoot(FxmlView.CADASTRO_INGREDIENTE);
		
		acpTelaPrincipal.getChildren().clear();
		acpTelaPrincipal.getChildren().add(rootNode);		
	}
	
	@FXML
	private void onActionMontarSanduba() {
//		lbTituloTela.setText("Montar Sanduba Natureba");
		Parent rootNode = stageManager.getNodeRoot(FxmlView.CADASTRO_SANDUICHE);
		
		acpTelaPrincipal.getChildren().clear();
		acpTelaPrincipal.getChildren().add(rootNode);
	}
	

}
