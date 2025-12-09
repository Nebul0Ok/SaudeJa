package Controller;

import Classes.Card;
import Classes.LoggedUser;
import com.google.gson.Gson;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ProdutoController extends BaseController implements Initializable{

    boolean isFS = true;
    
     @FXML
    private Button btnCarrinho;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnIcone;

    @FXML
    private Button btnMais;

    @FXML
    private Button btnMinMax;

    @FXML
    private Button btnReturn;

    @FXML
    private ImageView ivImagem;

    @FXML
    private Label lblDescricao;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblQuantidade;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblUso;

    @FXML
    private ListView<GridPane> lvLista;

    @FXML
    private HBox pnlContent;

    @FXML
    private HBox pnlPainelPrincipal;

    @FXML
    private StackPane pnlPrincipal;

    @FXML
    private HBox pnlSuperior;

    @FXML
    private TextField tfPesquisar;
	    
    @FXML
    void brnRetorno(ActionEvent event) {
	sceneSwitch.telaPrincipal();
    }
    
    @FXML
    void btnClose(MouseEvent event) {
	Platform.exit();
    }

    @FXML
    void btnMax(MouseEvent event) {
	if(isFS == true){
	    Stage stage = (Stage) btnMinMax.getScene().getWindow();
	    stage.setFullScreen(false);
	    isFS = false;
	}else{
	    Stage stage = (Stage) btnMinMax.getScene().getWindow();
	    stage.setFullScreen(true);
	    isFS = true;
	}
    }

    @FXML
    void handleOnKeyPressed(KeyEvent event) {

    }
    
    int prodId;
    
    	public ObservableList<GridPane> itens;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	
	String nomeUsuario = LoggedUser.userName();
	
	lblDescricao.setWrapText(true);
	String nomeProduto = new String();
	try{
	    Gson gson = new Gson();
	    FileReader fr = new FileReader("src/main/resources/UserLogged/ProdutoClickado.json");
	    
	    nomeProduto = gson.fromJson(fr, String.class);
	    
	    lblNome.setText("Nome:\n" + nomeProduto);
	    
	    try (Connection conexao = DriverManager.getConnection("jdbc:sqlite:BancoDados.db");
		 PreparedStatement comando = conexao.prepareStatement("SELECT * FROM remedio WHERE nome = ?")){
		    comando.setString(1, nomeProduto);

		    
		try (ResultSet rs = comando.executeQuery()){
		    rs.next();
		    String urlImagem = rs.getString("caminho_imagem");
		    Image imagem = new Image(urlImagem);
		    ivImagem.setImage(imagem);
		    prodId = rs.getInt("id");
		    String uso = rs.getString("tipo_uso");
		    
		    lblDescricao.setText( "Descrição:\n  " + rs.getString("descricao"));
		    lblUso.setText( "Uso:\n" + uso);
		    lblQuantidade.setText( "Quantidade:\n" + rs.getString("quantidade"));
		    
		} catch (Exception e) {
		    System.out.println("Erro: " + e.getMessage());
		}
		
		
		
	    } catch (Exception e) {
		System.out.println("Erro: " + e.getMessage());
	    }
	    
	    fr.close();
	    
	    
	    ArrayList<GridPane> cartasProd = new ArrayList<>();
	    
	    try (Connection conexao = DriverManager.getConnection("jdbc:sqlite:BancoDados.db");
		 PreparedStatement comando = conexao.prepareStatement("SELECT * FROM remedio_estoque WHERE remedio_id = ?")){
		String idProd = String.valueOf(prodId);
		comando.setString(1,idProd);
		
		try (ResultSet rs = comando.executeQuery()){
		    while (rs.next()) {
			String nomeProd = rs.getString("nome_loja");
			float precoProd = rs.getFloat("preco");
			GridPane cardprod = Card.cardLojas(prodId, nomeProduto, nomeProd, precoProd, nomeUsuario);
			cartasProd.add(cardprod);
		    }
		} catch (Exception e) {
		    System.out.println("Erro: " + e.getMessage());
		}
		
	    } catch (Exception e) {
		System.out.println("Erro: " + e.getMessage());
	    }
	    itens = FXCollections.observableArrayList(cartasProd);
	
	    lvLista.setItems(itens);
	    
	    
	    
	    
	}catch(Exception e){
	    System.out.println("Erro: "+ e.getMessage());
	}
    }

    
}
