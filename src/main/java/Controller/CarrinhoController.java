package Controller;

import Classes.LoggedUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CarrinhoController extends BaseController implements Initializable {

    @FXML private ListView<HBox> lvCarrinho;
    @FXML private Label lblPreco;
    @FXML private Label lblUsername;

    private ObservableList<HBox> listaDeLinhas = FXCollections.observableArrayList();
    private double valorTotal = 0.0;
    
    private int idClienteLogado = -1;
    
    private static final String DB_URL = "jdbc:sqlite:BancoDados.db";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvCarrinho.setItems(listaDeLinhas);
        
        String nomeUsuario = LoggedUser.userName();
        lblUsername.setText(nomeUsuario); 
        this.idClienteLogado = buscarIdCliente(nomeUsuario);
        
        if (this.idClienteLogado != -1) {
            carregarItensDoCarrinho();
        } else {
            System.err.println("ERRO: ID do Cliente não encontrado. Não é possível carregar o carrinho.");
        }
        
        lblUsername.setOnKeyPressed(this::keybinds);
    }
    
    private int buscarIdCliente(String nomeUsuario) {
        String sql = "SELECT id FROM cliente WHERE nome = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, nomeUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar ID do cliente: " + e.getMessage());
        }
        return -1;
    }

    private void carregarItensDoCarrinho() {
        simularDadosDoCarrinho(); 
    }

    private void simularDadosDoCarrinho() {
        listaDeLinhas.clear(); 
        valorTotal = 0.0;

        adicionarLinhaAoCarrinhoManual("Ibuprofeno 500mg", "Droga Raia", 12.50);
        adicionarLinhaAoCarrinhoManual("Amoxicilina 250mg", "Drogaria Popular", 35.90);
        adicionarLinhaAoCarrinhoManual("Paracetamol", "Farmácia Econômica", 6.00);
        adicionarLinhaAoCarrinhoManual("Paracetamol", "Droga Raia", 7.20);
        adicionarLinhaAoCarrinhoManual("Vitamina C", "Farmácia Central", 19.99);

        recalcularTotal();
    }
    
    private void adicionarLinhaAoCarrinhoManual(String nome, String loja, double preco) {
        HBox linha = new HBox(20);
        linha.setAlignment(Pos.CENTER_LEFT);
        linha.setPrefHeight(50);

        Label lblNome = new Label(nome);
        Label lblLoja = new Label("Loja: " + loja);
        Label lblValor = new Label("R$ " + String.format("%.2f", preco));

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
    }
    
    private void buscarDadosDoCarrinho() {
        String query = "SELECT r.nome, c.nome_remedio, e.preco, c.id AS id_carrinho " + 
                       "FROM carrinho c " +
                       "JOIN remedio_estoque e ON c.id_produto_estoque = e.id " +
                       "JOIN remedio r ON e.remedio_id = r.id " +
                       "WHERE c.id_cliente = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, this.idClienteLogado);
            
            try (ResultSet rs = stmt.executeQuery()) {
                
                listaDeLinhas.clear(); 
                valorTotal = 0.0;
                
                while (rs.next()) {
                    String nomeRemedio = rs.getString("nome");
                    String nomeLoja = rs.getString("nome_remedio");
                    double preco = rs.getDouble("preco");
                    int idCarrinho = rs.getInt("id_carrinho");
                    
                    adicionarLinhaAoCarrinho(nomeRemedio, nomeLoja, preco, idCarrinho);
                }
            }
            recalcularTotal();

        } catch (SQLException e) {
            System.err.println("Erro SQL ao carregar carrinho: " + e.getMessage());
        }
    }

    private void adicionarLinhaAoCarrinho(String nome, String loja, double preco, int idCarrinho) {
        HBox linha = new HBox(20);
        linha.setAlignment(Pos.CENTER_LEFT);
        linha.setPrefHeight(50);
        linha.setUserData(idCarrinho);

        Label lblNome = new Label(nome);
        Label lblLoja = new Label("Loja: " + loja);
        Label lblValor = new Label("R$ " + String.format("%.2f", preco));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button btnRemover = new Button("Remover");
        btnRemover.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white; -fx-font-weight: bold;");

        btnRemover.setOnMouseEntered(e -> btnRemover.setStyle("-fx-background-color: #cc0000; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;"));
        btnRemover.setOnMouseExited(e -> btnRemover.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white; -fx-font-weight: bold;"));

        btnRemover.setOnAction(e -> {
            int idParaRemover = (int) linha.getUserData();
            removerItemDoBanco(idParaRemover);

            listaDeLinhas.remove(linha);
            recalcularTotal();
        });

        linha.getChildren().addAll(lblNome, lblLoja, lblValor, spacer, btnRemover);
        listaDeLinhas.add(linha);
    }
    
    private void removerItemDoBanco(int idCarrinho) {
        String sql = "DELETE FROM carrinho WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, idCarrinho);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Item do carrinho (ID: " + idCarrinho + ") removido do banco de dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover item do banco de dados: " + e.getMessage());
        }
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