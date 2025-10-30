package Utility;

import Controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;


public class SceneSwitch {
    private Stage stage;
    
    public SceneSwitch(Stage stage){
	this.stage = stage;
    }

    public void newSc(String fxmlUrl, String cssURL){
	try {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlUrl));
	Parent root = loader.load();
	
	Object controller = loader.getController();
	if (controller instanceof BaseController) {
	    ((BaseController) controller).setSceneSwitch(this);
	}
	
	Scene scene = new Scene(root);
	
	scene.getStylesheets().add(getClass().getResource(cssURL).toExternalForm());
	
	stage.setScene(scene);
	
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}

	
    }
    
    public void telaCadastro(){
	newSc("/TelaCadastro/TelaCadastro.fxml", "/TelaCadastro/TelaCadastro.css");
    }
    
    public void telaLogin(){
	newSc("/TelaLogin/TelaLogin.fxml", "/TelaLogin/TelaLogin.css");
    }
    
    public void telaPrincipal(){
	newSc("/TelaPrincipal/TelaPrincipal.fxml", "/TelaPrincipal/TelaPrincipal.css");
    }
    
    
}
