package com.example.carrinho.controller;


import com.example.carrinho.model.Produto;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ItemCarrinhoController {


@FXML private ImageView imgRemedio;
@FXML private Label nomeRemedio;
@FXML private Label precoLabel;
@FXML private Label qtdLabel;
@FXML private Button btnMais;
@FXML private Button btnMenos;
@FXML private Button btnRemover;


private Produto produto;
private int quantidade = 1;
private CarrinhoController carrinhoController;


public void setProduto(Produto p, CarrinhoController carrinho) {
this.produto = p;
this.carrinhoController = carrinho;
nomeRemedio.setText(p.getNome());
precoLabel.setText(String.format("R$ %.2f", p.getPreco()));
qtdLabel.setText(String.valueOf(quantidade));



try {
Image img;
if (p.getImagemPath().startsWith("file:")) {
img = new Image(p.getImagemPath(), true);
} else {

img = new Image(getClass().getResourceAsStream(p.getImagemPath()));
}
imgRemedio.setImage(img);
} catch (Exception e) {
System.out.println("Não foi possível carregar imagem: " + p.getImagemPath());
}
}


@FXML
private void onMais() {
quantidade++;
qtdLabel.setText(String.valueOf(quantidade));
carrinhoController.ajustarTotal(produto.getPreco());
}


@FXML
private void onMenos() {
if (quantidade > 1) {
quantidade--;
qtdLabel.setText(String.valueOf(quantidade));
carrinhoController.ajustarTotal(-produto.getPreco());
}
}


@FXML
private void onRemover() {

Parent parent = imgRemedio.getParent(); // HBox (item)

double valor = produto.getPreco() * quantidade;
carrinhoController.removerItem((Parent) imgRemedio.getParent().getParent(), valor);
}
}