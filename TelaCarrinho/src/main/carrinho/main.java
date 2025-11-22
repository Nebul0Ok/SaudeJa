package com.example.carrinho;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
@Override
public void start(Stage stage) throws Exception {
FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/carrinho.fxml"));
Parent root = loader.load();
Scene scene = new Scene(root);
scene.getStylesheets().add(getClass().getResource("/css/carrinho.css").toExternalForm());
stage.setTitle("Saúde Já - Carrinho");
stage.setScene(scene);
stage.setWidth(1100);
stage.setHeight(700);
stage.show();
}


public static void main(String[] args) {
launch();
}
}