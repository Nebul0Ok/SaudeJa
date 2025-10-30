package Main;

import Controller.TelaCadastroController;
import Utility.SceneSwitch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
	
	SceneSwitch sceneSwitch = new SceneSwitch(primaryStage);
	
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setFullScreen(false);
	primaryStage.setResizable(false);

	sceneSwitch.telaLogin();
	
        primaryStage.show();
    }

    public static void main(String[] args){
    launch(args);
    }

}
