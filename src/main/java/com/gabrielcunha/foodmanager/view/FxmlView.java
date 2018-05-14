package com.gabrielcunha.foodmanager.view;

import java.util.ResourceBundle;

public enum FxmlView {
	
	LOGIN {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },
	DASHBOARD {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Dashboard.fxml";
        }
    },
	CADASTRO_SANDUICHE {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("cadastro.sanduiche");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/CadastroSanduiche.fxml";
        }
    },
	CADASTRO_INGREDIENTE {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("cadastro.ingrediente");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/CadastroIngrediente.fxml";
        }
    },
	CADASTROS {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("cadastros");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Cadastros.fxml";
        }
    },
	VENDER_SANDUICHE {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("sanduiche.vender");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Venda.fxml";
        }
    };
	
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
