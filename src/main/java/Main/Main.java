package Main;

import Controller.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaPrincipal.fxml"));
        Scene TelaPrincipal = new Scene(root);
        TelaPrincipal.getStylesheets().add(getClass().getResource("/View/TelaPrincipal.css").toExternalForm());

        primaryStage.setFullScreen(true);
        primaryStage.setScene(TelaPrincipal);
        primaryStage.show();
    }

    public static void main (String[] args){
    launch(args);

    }

}
