package com.gabrielcunha.foodmanager.config;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Objects;

import org.slf4j.Logger;

import com.gabrielcunha.foodmanager.view.FxmlView;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author GABRIEL
 * Gerencia a troca de cenas no estágio primário.
 */
public class StageManager {
	
	private static final Logger LOG = getLogger(StageManager.class);
	private final Stage primaryStage;
	private final SpringFXMLLoader springFXMLLoader;
	
    public StageManager(SpringFXMLLoader springFXMLLoader, Stage stage) {
        this.springFXMLLoader = springFXMLLoader;
        this.primaryStage = stage;
    }
    
    public void switchScene(final FxmlView view) {
        Parent rootNode = loadViewNodeHierarchy(view.getFxmlFile());
        show(rootNode, view.getTitle());
    }
    
    public Parent getNodeRoot (final FxmlView pathView) {
    	return loadViewNodeHierarchy(pathView.getFxmlFile());
    }
    
    
    private void show(final Parent rootNode, String title) {
    	Scene scene = prepareScene(rootNode);
//    	scene.getStylesheets().add("/styles/Styles.css");
    	
//    	primaryStage.initStyle(StagesStyle.TRANSPARENT);
    	
    	if ("Dashboard".equals(title.trim())) {
    		primaryStage.setMaximized(true);
    		primaryStage.setTitle(title);
    		primaryStage.setScene(scene);
    	} else {
        	primaryStage.setTitle(title);
        	primaryStage.setScene(scene);
        	primaryStage.sizeToScene();
        	primaryStage.centerOnScreen();
    	}
    	
    	try {
    		primaryStage.show();
    	} catch (Exception e) {
    		logAndExit("Não é possível mostrar a cena para o título " + title + "." , e);
    	}
    }
    
    private Scene prepareScene(Parent rootnode){
        Scene scene = primaryStage.getScene();

        if (scene == null) {
            scene = new Scene(rootnode);
        }
        scene.setRoot(rootnode);
        return scene;
    }
    
	
    /*
     * Carrega a hierarquia de objetos de um documento 
     * FXML e retorna ao nó raiz dessa hierarquia.
     */
    private Parent loadViewNodeHierarchy(String fxmlFilePath) {
    	Parent rootNode = null;
    	try {
    		rootNode = springFXMLLoader.load(fxmlFilePath);
    		Objects.requireNonNull(rootNode, "Um nó FXML raiz não pode ser nulo");
    	} catch (Exception e) {
    		logAndExit("Não é possível carregar a visualização do arquivo FXML " + fxmlFilePath, e);
    	}
    	return rootNode; 
    }

	private void logAndExit(String msgErro, Exception e) {
		LOG.error(msgErro, e, e.getCause());
		Platform.exit();
	}
}
