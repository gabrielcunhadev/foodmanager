package com.gabrielcunha.foodmanager.util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

public class UtilMessages {
	
	public static void mensagem(String title, String header, String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initModality(Modality.WINDOW_MODAL);  // default
		alert.initStyle(StageStyle.UTILITY);  // remove �cone
        alert.setTitle(title);
        alert.setHeaderText(header);  // header pode ser null
        alert.setContentText(contentText);
        alert.showAndWait();
        alert.close();
    }

	public static boolean confirma(String title, String header, String contentText) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.initModality(Modality.WINDOW_MODAL);
		alert.initStyle(StageStyle.UTILITY);
        alert.setTitle(title);
        alert.setHeaderText(header);  // header pode ser null
        alert.setContentText(contentText);
        Optional<ButtonType> result = alert.showAndWait();
        alert.close();
        return result.get() == ButtonType.OK;
    }

	public static void alerta(String title, String header, String contentText) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.initModality(Modality.WINDOW_MODAL);  // default
		alert.initStyle(StageStyle.UTILITY);  // remove �cone
        alert.setTitle(title);
        alert.setHeaderText(header);  // header pode ser null
        alert.setContentText(contentText);
        alert.showAndWait();
        alert.close();
    }

	public static void erro(String title, String header, String contentText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.initModality(Modality.WINDOW_MODAL);  // default
		alert.initStyle(StageStyle.UTILITY);  // remove �cone
        alert.setTitle(title);
        alert.setHeaderText(header);  // header pode ser null
        alert.setContentText(contentText);
        alert.showAndWait();
        alert.close();
    }
	
	   

}
