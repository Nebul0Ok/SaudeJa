package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class FarmaciaController extends BaseController implements Initializable{

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
    private Label lblEndereco;

    @FXML
    private Label lblHorario;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblUsername;

    @FXML
    private HBox pnlPainelPrincipal;

    @FXML
    private StackPane pnlPrincipal;

    @FXML
    private HBox pnlSuperior;

    @FXML
    private TextField tfPesquisar;

    @FXML
    void btnClose(MouseEvent event) {

    }

    @FXML
    void btnMax(MouseEvent event) {

    }

    @FXML
    void handleOnKeyPressed(KeyEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	Gson gson = new Gson();
	String nomeProd = new String();
	
	try (FileReader fr = new FileReader("src/main/resources/UserLogged/Clicado.json")){
	    JsonElement produto = JsonParser.parseReader(fr);
	    
	    nomeProd = produto.getAsString();
	    
	    try (Connection conexao = DriverManager.getConnection("jdbc:sqlite:BancoDados.db");
	         PreparedStatement comando = conexao.prepareStatement("SELECT * FROM farmacias WHERE nome = ?")){
		
		comando.setString(1, nomeProd);
	    
		try (ResultSet rs = comando.executeQuery()){
		    while(rs.next()){
			String URL = rs.getString("URL");
			String labelNome = rs.getString("Nome");
			String labelEndereco = rs.getString("Endereco");
			String labelHorario = rs.getString("Horarios_Funcionamento");
			String labelStatus = rs.getString("Status");
			
			Image imagem = new Image(URL);
			
			ivImagem.setImage(imagem);
			ivImagem.setFitWidth(500);
			ivImagem.setFitHeight(500);
			
			Rectangle clip = new Rectangle(ivImagem.getFitWidth(), ivImagem.getFitHeight());
			
			clip.setArcWidth(30);
			clip.setArcHeight(30);
			
			ivImagem.setClip(clip);
			
			lblNome.setText("Nome: \n" + labelNome);
			lblEndereco.setText("Endereço: \n" + labelEndereco);
			lblHorario.setText("Horário: \n" + labelHorario);
			lblStatus.setText("Recebe Reciclagem? \n" + labelStatus);
			
		    }
		} catch (Exception e) {
		    System.out.println("Erro: " + e.getMessage());
		}
	    
	    } catch (Exception e) {
		System.out.println("Erro: " + e.getMessage());
	    }
	    
	} catch (Exception e) {
	    System.out.println("Erro: " + e.getMessage());
	}
	
	pnlPrincipal.setOnKeyPressed(this::keybinds);
	
    }
    
    public void keybinds(KeyEvent event){
	if(event.getCode() == KeyCode.H){
	    sceneSwitch.telaPrincipal();
	}
    }

    
}
