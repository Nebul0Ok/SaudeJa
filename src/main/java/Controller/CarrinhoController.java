package Controller;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CarrinhoController extends BaseController implements Initializable {

    @FXML private ListView<HBox> lvCarrinho;
    @FXML private Label lblPreco;
    @FXML private Label lblUsername;

    private ObservableList<HBox> listaDeLinhas = FXCollections.observableArrayList();
    private double valorTotal = 0.0;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvCarrinho.setItems(listaDeLinhas);
        carregarItensDoCarrinho();
	
	lblUsername.setOnKeyPressed(this::keybinds);
	
    }

    private void carregarItensDoCarrinho() {
        String path = "src/main/resources/UserLogged/ProdutoClickado.json";
        try (FileReader fr = new FileReader(path)) {
            Gson gson = new Gson();
            String nomeProduto = gson.fromJson(fr, String.class);
            
            buscarDadosESombrar(nomeProduto);
            
        } catch (Exception e) {
            System.out.println("Erro ao carregar JSON: " + e.getMessage());
        }
    }

    private void buscarDadosESombrar(String nomeRemedio) {
        String query = "SELECT r.nome, e.nome_loja, e.preco FROM remedio r " +
                       "JOIN remedio_estoque e ON r.id = e.remedio_id WHERE r.nome = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BancoDados.db");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nomeRemedio);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String loja = rs.getString("nome_loja");
                double preco = rs.getDouble("preco");

                adicionarLinhaAoCarrinho(nome, loja, preco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void adicionarLinhaAoCarrinho(String nome, String loja, double preco) {
        HBox linha = new HBox(20);
        linha.setAlignment(Pos.CENTER_LEFT);
        linha.setPrefHeight(50);

        Label lblNome = new Label(nome);
        Label lblLoja = new Label("Loja: " + loja);
        Label lblValor = new Label("R$ " + preco);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button btnRemover = new Button("Remover");
        btnRemover.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white; -fx-font-weight: bold;");

        btnRemover.setOnMouseEntered(e -> btnRemover.setStyle("-fx-background-color: #cc0000; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;"));
        btnRemover.setOnMouseExited(e -> btnRemover.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white; -fx-font-weight: bold;"));

        btnRemover.setOnAction(e -> {
            listaDeLinhas.remove(linha);
            recalcularTotal();
        });

        linha.getChildren().addAll(lblNome, lblLoja, lblValor, spacer, btnRemover);
        listaDeLinhas.add(linha);
        
        recalcularTotal();
    }

    private void recalcularTotal() {
        valorTotal = 0.0;
        
        for (HBox hb : listaDeLinhas) {
            Label valorLabel = (Label) hb.getChildren().get(2);
            String textoPreco = valorLabel.getText().replace("R$ ", "").replace(",", ".");
            valorTotal += Double.parseDouble(textoPreco);
        }
        lblPreco.setText(String.format("Total: R$ %.2f", valorTotal));
    }
    
    public void keybinds(KeyEvent event){
	if(event.getCode() == KeyCode.H){
	    sceneSwitch.telaPrincipal();
	}
    }
    
}