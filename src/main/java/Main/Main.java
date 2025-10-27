package Main;

import Controller.TelaLoginController;
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
        Parent root = FXMLLoader.load(getClass().getResource("/TelaLogin/TelaLogin.fxml"));
        Scene TelaPrincipal = new Scene(root);
        TelaPrincipal.getStylesheets().add(getClass().getResource("/TelaLogin/TelaLogin.css").toExternalForm());

        primaryStage.setMaxHeight(576);
        primaryStage.setMaxWidth(1024);

        primaryStage.setFullScreen(true);
        primaryStage.setScene(TelaPrincipal);
        primaryStage.show();
    }

    public static void main(String[] args){
    launch(args);
    }

}
