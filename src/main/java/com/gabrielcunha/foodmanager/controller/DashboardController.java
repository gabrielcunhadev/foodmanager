package com.gabrielcunha.foodmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.gabrielcunha.foodmanager.config.StageManager;
import com.gabrielcunha.foodmanager.util.UtilMessages;
import com.gabrielcunha.foodmanager.view.FxmlView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * @author Gabriel Cunha
 * @since 01-05-2018
 */

@Controller
public class DashboardController implements Initializable{
	
	@FXML 
	private Button btnInicio;
	
	@FXML 
	private Button btnCadastrar;
	
	@FXML 
	private Button btnVender;
	
	@FXML 
	private Button btnSair;	
	
	@FXML 
	private AnchorPane acpTelaPrincipal;
	
	@FXML 
	private Pane barraSuperiorDasboard;
	
	@FXML 
	private Label lbTituloTela;
	
    @Lazy
    @Autowired
    private StageManager stageManager;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	public void onActionInicio () {
		acpTelaPrincipal.getChildren().clear();
		lbTituloTela.setText("Dashboard");
    }
	
	@FXML
	private void onActionAbrirCadastros () {
		lbTituloTela.setText("Cadastros");
		
		Parent rootNode = stageManager.getNodeRoot(FxmlView.CADASTROS);
		
		acpTelaPrincipal.getChildren().clear();
		acpTelaPrincipal.getChildren().add(rootNode);
	}

	
	@FXML
	private void onActionSair() {
	   if (UtilMessages.confirma("Mensagem", "Finalizar o aplicativo?", "")) {
	       	 System.exit(0);
	    }
	}
	
	@FXML
	private void onActionAbrirTelaVenda() {
		lbTituloTela.setText("Vender Sanduiches");
		
		Parent rootNode = stageManager.getNodeRoot(FxmlView.VENDER_SANDUICHE);
		
		acpTelaPrincipal.getChildren().clear();
		acpTelaPrincipal.getChildren().add(rootNode);
	}

}
