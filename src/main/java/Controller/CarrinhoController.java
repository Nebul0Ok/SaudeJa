package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class CarrinhoController {

    @FXML
    private VBox listaCarrinho;

    @FXML
    private Label labelTotal;

    private double total = 0.0;

    public void adicionarItem(String nome, double preco, String imagem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/itemCarrinho.fxml"));
            Parent item = loader.load();

            ItemCarrinhoController controller = loader.getController();
            controller.setData(nome, preco, imagem, this);

            listaCarrinho.getChildren().add(item);

            total += preco;
            atualizarTotal();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarTotal() {
        labelTotal.setText(String.format("Total: R$ %.2f", total));
    }

    public void removerItem(double preco) {
        total -= preco;
        atualizarTotal();
    }
}
