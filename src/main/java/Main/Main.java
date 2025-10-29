package Main;

import Controller.TelaCadastroController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
	
	String urlTelaLoginfxml ="/TelaLogin/TelaLogin.fxml";
	String urlTelaLogincss ="/TelaLogin/TelaLogin.css";
	String urlTelaCadastrofxml="/TelaCadastro/TelaCadastro.fxml";
	String urlTelaCadastrocss="/TelaCadastro/TelaCadastro.css";
	
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource(urlTelaLoginfxml));
        Scene TelaPrincipal = new Scene(root);
        TelaPrincipal.getStylesheets().add(getClass().getResource(urlTelaLogincss).toExternalForm());

        primaryStage.setMaxHeight(576);
        primaryStage.setMaxWidth(1024);

        primaryStage.setFullScreen(false);
	primaryStage.setResizable(false);
        primaryStage.setScene(TelaPrincipal);
        primaryStage.show();
    }

    public static void main(String[] args){
    launch(args);
    }

}
