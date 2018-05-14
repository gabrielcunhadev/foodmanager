package com.gabrielcunha.foodmanager;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.gabrielcunha.foodmanager.config.StageManager;
import com.gabrielcunha.foodmanager.view.FxmlView;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class Main extends Application{

    protected ConfigurableApplicationContext springContext;
    protected StageManager stageManager;
	
	
	@Override
	public void init() throws Exception {
		springContext = springBootApplicationContext();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
        stageManager = springContext.getBean(StageManager.class, stage);
        mostraCenaInicial();
        
	}
	
    @Override
    public void stop() throws Exception {
        springContext.close();
    }
	

	private ConfigurableApplicationContext springBootApplicationContext() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		return builder.run(args);
	}
	
	/*
	 * Útil para alternar sub-classes que desejam mudar a primeira
     * Cena a ser exibida na inicialização. 
	 * Exemplo: Testes funcionais em cenas diferentes.
	 */
    protected void mostraCenaInicial() {
        stageManager.switchScene(FxmlView.LOGIN); // FxmlView.LOGIN
    }

    
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
