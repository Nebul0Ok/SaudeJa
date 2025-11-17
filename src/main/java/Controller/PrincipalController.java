package Controller;

//Imports das minhas classes
import Classes.Card;
import Classes.LoggedUser;
import Classes.Produto;
import Utility.Keybinds;

//Imports do SQL
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Imports de utildades
import java.util.ArrayList;
import java.util.ResourceBundle;

//Imports do javafx
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PrincipalController extends BaseController implements Initializable{
    boolean isMenu = false;
    
    boolean isFS = true;
    short min = 0;
    
    ArrayList<VBox> allCards = new ArrayList<>();
    StackPane background = new StackPane();
    
    @FXML
    private Button btnAgendar;

    @FXML
    private Button btnCarrinho;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnIcone;

    @FXML
    private Button btnMais;

    @FXML
    private Button btnMedicamentos;

    @FXML
    private Button btnMinMax;

    @FXML
    private Button btnReciclagem;

    @FXML
    private Button btnSaibaMais;
    
    @FXML
    private Button btnLeft;
	
    @FXML
    private Button btnRight;
    
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
    private HBox pnlContent;

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
    void btnMedClickar(MouseEvent event) {
	
    }

    @FXML
    void btnRecClickar(MouseEvent event) {
	sceneSwitch.telaReciclagem();
    }

    @FXML
    void btnAgendClickar(MouseEvent event) {
	sceneSwitch.telaAgendar();
    }

    @FXML
    void btnSaibaClickar(MouseEvent event) {
	sceneSwitch.telaSobrenos();
    }
    
    public void initialize(URL url, ResourceBundle rb) {
	
	pnlContent.setSpacing(10);
	
	String nomeUsuario = LoggedUser.userName();
	lblUsername.setText(nomeUsuario);
	
    } 
    
     @Override
    public void setSceneSwitch(Utility.SceneSwitch sceneSwitch) {
        super.setSceneSwitch(sceneSwitch);
	criarCards();
    }
    
    private void criarCards() {
        ArrayList<Produto> produtos = new ArrayList<>();
	ArrayList<VBox> cartas = new ArrayList<>();
	
	try (Connection conexao = DriverManager.getConnection("jdbc:sqlite:BancoDados.db");
	     PreparedStatement comando = conexao.prepareStatement("SELECT * FROM remedio")){
	    
	    try (ResultSet rs = comando.executeQuery()){
		
		while(rs.next()){
		    String nome = rs.getString("nome");
		    String urlIm = rs.getString("caminho_imagem");
		    
		    Produto prod = new Produto(nome, urlIm);
		    
		    produtos.add(prod);
		}
		
	    } catch (Exception e) {
		System.out.println("Erro: " + e.getMessage());
	    }
	    
	} catch (Exception e) {
	    System.out.println("Erro: " + e.getMessage());
	}
	
	for(Produto item : produtos){
	    Card carta = new Card();
	    VBox card = carta.cardGen(item.nome, item.urlImagem, sceneSwitch);
	    allCards.add(card);
	}
	
	mostraInicio();
    }
    
    public void mostraInicio(){
	pnlContent.getChildren().clear();
	
	for(int i =0; i < 4; i++){
	pnlContent.getChildren().add(allCards.get(i));
	}
    }
    
    @FXML
    void handleOnKeyPressed(KeyEvent event) {

	
	if(event.getCode() == KeyCode.E){
	    
	    if(isMenu == false){
		
		background.getChildren().clear();
		background.getChildren().add(Keybinds.Menu());
		
		if(!pnlPrincipal.getChildren().contains(background)){
		    pnlPrincipal.getChildren().add(background);
		}
		isMenu = true;
		
	    }else{
	    pnlPrincipal.getChildren().remove(background);
	    isMenu = false;
	    
	    }
	    
	}
	
	if(event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT){
	    int maxPos = allCards.size();
	    
	    if ((min + 4) < maxPos){
		pnlContent.getChildren().clear();
		min+=4;
		
		for(int i = min; i < (min+4); i++){
		    
		    if(i < maxPos){
			pnlContent.getChildren().add(allCards.get(i));
		    }
		}
		
		}
		
	    }
	    
	
	if(event.getCode() == KeyCode.A|| event.getCode() == KeyCode.LEFT){
	    int minPos = 0;
	    
	    if ((min - 4) >= minPos){
		pnlContent.getChildren().clear();
		min-=4;
		
		for(int i = min; i < (min+4); i++){
		    
		    if(i >= 0){
		    pnlContent.getChildren().add(allCards.get(i));
		    }		    
		    
		}
	    }
	    
	}
	
    }
    
}