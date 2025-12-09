package Utility;

import Controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneSwitch {

    private Stage stage;

    public SceneSwitch(Stage stage) {
	this.stage = stage;
    }

    public void newSc(String fxmlUrl, String cssURL) {
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

    public void telaCadastro() {
	newSc("/TelaCadastro/TelaCadastro.fxml", "/TelaCadastro/TelaCadastro.css");
    }

    public void telaLogin() {
	newSc("/TelaLogin/TelaLogin.fxml", "/TelaLogin/TelaLogin.css");
    }

    public void telaPrincipal() {
	newSc("/TelaPrincipal/TelaPrincipal.fxml", "/TelaPrincipal/TelaPrincipal.css");
	stage.centerOnScreen();
	stage.setFullScreenExitHint("");
	stage.setFullScreen(true);
	stage.setResizable(true);
    }

    public void telaReciclagem() {
	newSc("/TelaReciclagem/TelaReciclagem.fxml", "/TelaReciclagem/TelaReciclagem.css");
	stage.centerOnScreen();
	stage.setFullScreenExitHint("");
	stage.setFullScreen(true);
	stage.setResizable(true);

    }
    
    public void telaAgendar(){
	newSc("/TelaMedicos/TelaMedicos.fxml", "/TelaMedicos/TelaMedicos.css");
	stage.centerOnScreen();
	stage.setFullScreenExitHint("");
	stage.setFullScreen(true);
	stage.setResizable(true);
    }

    public void telaSobrenos(){
	newSc("/TelaSobrenos/TelaSobrenos.fxml", "/TelaSobrenos/TelaSobrenos.css");
	stage.centerOnScreen();
	stage.setFullScreenExitHint("");
	stage.setFullScreen(true);
	stage.setResizable(true);
    }   
    
    public void telaProduto(){
	newSc("/TelaProduto/TelaProduto.fxml", "/TelaProduto/TelaProduto.css");
	stage.centerOnScreen();
	stage.setFullScreenExitHint("");
	stage.setFullScreen(true);
	stage.setResizable(true);
    }
    
    public void telaMedico(){
	newSc("/Medicos/Medicos.fxml", "/Medicos/Medicos.css");
	stage.centerOnScreen();
	stage.setFullScreenExitHint("");
	stage.setFullScreen(true);
	stage.setResizable(true);
    }
    
    public void telaFarmacia(){
	newSc("/Farmacias/Farmacias.fxml", "/Farmacias/Farmacias.css");
	stage.centerOnScreen();
	stage.setFullScreenExitHint("");
	stage.setFullScreen(true);
	stage.setResizable(true);
    }
    
    public void telaCarrinho(){
	newSc("/TelaCarrinho/TelaCarrinho.fxml", "/TelaCarrinho/TelaCarrinho.css");
	stage.centerOnScreen();
	stage.setFullScreenExitHint("");
	stage.setFullScreen(true);
	stage.setResizable(true);
    }
    
    
    
}
