package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ItemCarrinhoController {

    @FXML private ImageView imgRemedio;
    @FXML private Label nomeRemedio;
    @FXML private Label preco;
    @FXML private Label labelQtd;

    private double precoUnitario;
    private int quantidade = 1;
    private CarrinhoController carrinho;

    public void setData(String nome, double preco, String imagem, CarrinhoController c) {
        nomeRemedio.setText(nome);
        precoUnitario = preco;
        this.preco.setText("Preço: R$ " + preco);
        imgRemedio.setImage(new Image(imagem));
        carrinho = c;
    }

    @FXML
    private void aumentar() {
        quantidade++;
        labelQtd.setText(String.valueOf(quantidade));
        carrinho.removerItem(precoUnitario);
        carrinho.removerItem(-precoUnitario);
    }

    @FXML
    private void diminuir() {
        if (quantidade > 1) {
            quantidade--;
            labelQtd.setText(String.valueOf(quantidade));
            carrinho.removerItem(precoUnitario);
        }
    }

    @FXML
    private void remover() {
        carrinho.removerItem(precoUnitario * quantidade);
        ((VBox) nomeRemedio.getParent().getParent()).getChildren().remove(nomeRemedio.getParent().getParent());
    }
}
