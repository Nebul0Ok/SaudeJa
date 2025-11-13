package Controller;

import com.google.gson.Gson;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ProdutoController extends BaseController implements Initializable{

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
	String nomeProduto = new String();
	try{
	    Gson gson = new Gson();
	    FileReader fr = new FileReader("src/main/resources/UserLogged/ProdutoClickado.json");
	    
	    nomeProduto = gson.fromJson(fr, String.class);
	    
	    fr.close();
	    
	}catch(Exception e){
	    System.out.println("Erro: "+ e.getMessage());
	}
	
	
	lblNome.setText(nomeProduto);
	lblQuantidade.setText("Quantidade:\n500mg");
	lblUso.setText("Uso:\nOral");
	lblDescricao.setText("Descrição:\nMedicamento indicado para o alivio da dor e da febre");
	
	Image imagem = new Image("/imagemRemedio/ibuprofeno.png");
	ivImagem.setImage(imagem);
    }

    
}
