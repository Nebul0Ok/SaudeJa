package com.example.carrinho.controller;


import com.example.carrinho.model.Produto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;


public class CarrinhoController {


@FXML
private VBox listaCarrinho;


@FXML
private Label labelTotal;


@FXML
private Button btnFinalizar;


private double total = 0.0;


public void initialize() {
adicionarProduto(new Produto("Amoxicilina", 16.00, "file:/mnt/data/db4237a9-b556-4a1e-ab25-85dd3449fceb.jpg"));
adicionarProduto(new Produto("Dipirona", 8.50, "/images/dipirona.png"));
}


public void adicionarProduto(Produto p) {
try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/itemCarrinho.fxml"));
Parent item = loader.load();


ItemCarrinhoController ic = loader.getController();
ic.setProduto(p, this);


listaCarrinho.getChildren().add(item);


total += p.getPreco();
atualizarTotal();


} catch (IOException e) {
e.printStackTrace();
}
}


public void atualizarTotal() {
NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
labelTotal.setText("Total: " + nf.format(total));
}


public void ajustarTotal(double delta) {
total += delta;
atualizarTotal();
}


public void removerItem(Parent itemParent, double valor) {
listaCarrinho.getChildren().remove(itemParent);
ajustarTotal(-valor);
}



@FXML
private void onFinalizar() {
System.out.println("Finalizar compra: " + labelTotal.getText());
}
}