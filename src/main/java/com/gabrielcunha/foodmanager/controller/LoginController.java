package com.gabrielcunha.foodmanager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.gabrielcunha.foodmanager.config.StageManager;
import com.gabrielcunha.foodmanager.service.UsuarioService;
import com.gabrielcunha.foodmanager.util.UtilMessages;
import com.gabrielcunha.foodmanager.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Controller
public class LoginController implements Initializable{

	@Autowired
	private UsuarioService usuarioService;

	@FXML
    private Button btnEntrar;

    @FXML
    private PasswordField pwfSenha;

    @FXML
    private TextField txfUsuario;

    @FXML
    private Label lblLogin; 
   
    @Lazy
    @Autowired
    private StageManager stageManager;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
    private void onActionEntrar(ActionEvent event) throws IOException{
    	if(usuarioService.autenticar(getUsuario(), getSenha())){
    		stageManager.switchScene(FxmlView.DASHBOARD);
    	}else{
    		UtilMessages.alerta("Erro de Login", "Confira seu usuario ou senha e tente novamente", null);
    		stageManager.switchScene(FxmlView.LOGIN);
    	}
    }
	
	public String getSenha() {
		return pwfSenha.getText();
	}
	
	public String getUsuario() {
		return txfUsuario.getText();
	}
	
}
