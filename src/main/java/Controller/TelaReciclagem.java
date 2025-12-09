package Controller;

import Classes.LoggedUser;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TelaReciclagem extends BaseController implements Initializable{
    
    boolean isFS = true;
    
    @FXML
    private Button btnAgendar;

    @FXML
    private Button btnCarrinho;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnIcone;

    @FXML
    private ImageView btnLoja1;

    @FXML
    private ImageView btnLoja2;

    @FXML
    private ImageView btnLoja3;

    @FXML
    private ImageView btnLoja4;

    @FXML
    private Button btnMais;

    @FXML
    private Button btnMedicamentos;

    @FXML
    private Button btnMinMax;

    @FXML
    private Button btnPin1;

    @FXML
    private Button btnPin2;

    @FXML
    private Button btnPin3;

    @FXML
    private Button btnPin4;

    @FXML
    private Button btnReciclagem;

    @FXML
    private Button btnSaibaMais;

    @FXML
    private ImageView ivMapa;

    @FXML
    private Label lblDescricao;

    @FXML
    private Label lblReciclagem;

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
    void btnClickMedicamentos(ActionEvent event) {
	sceneSwitch.telaPrincipal();
    }

    @FXML
    void btnAgendClickar(MouseEvent event) {
	sceneSwitch.telaAgendar();
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
    void btnRecClickar(MouseEvent event) {

    }

    @FXML
    void btnSaibaClickar(MouseEvent event) {
	sceneSwitch.telaSobrenos();
    } 
    
    @FXML
    void loja1(ActionEvent event) {
	Gson gson = new Gson();
	boolean save = false;
	
	try(FileWriter fw = new FileWriter("src/main/resources/UserLogged/Clicado.json")){
	    String teste = "Droga Raia";
	    String json = gson.toJson(teste);
	    
	    fw.write(json);
	    
	    save = true;
	    
	}catch (Exception e) {
	    System.out.println("Erro: " + e.getMessage());
	}
	
	if(save){
	    sceneSwitch.telaFarmacia();
	}
	
    }

    @FXML
    void loja2(ActionEvent event) {
	Gson gson = new Gson();
	boolean save = false;
	
	try(FileWriter fw = new FileWriter("src/main/resources/UserLogged/Clicado.json")){
	    String teste = "Drogaria Popular";
	    String json = gson.toJson(teste);
	    
	    fw.write(json);
	    
	    save = true;
	    
	}catch (Exception e) {
	    System.out.println("Erro: " + e.getMessage());
	}
	
	if(save){
	    sceneSwitch.telaFarmacia();
	}
    }

    @FXML
    void loja3(ActionEvent event) {
	Gson gson = new Gson();
	boolean save = false;
	
	try(FileWriter fw = new FileWriter("src/main/resources/UserLogged/Clicado.json")){
	    String teste = "Rede Saúde";
	    String json = gson.toJson(teste);
	    
	    fw.write(json);
	    
	    save = true;
	    
	}catch (Exception e) {
	    System.out.println("Erro: " + e.getMessage());
	}
	
	if(save){
	    sceneSwitch.telaFarmacia();
	}
    }

    @FXML
    void loja4(ActionEvent event) {
	Gson gson = new Gson();
	boolean save = false;
	
	try(FileWriter fw = new FileWriter("src/main/resources/UserLogged/Clicado.json")){
	    String teste = "Pague Pouco";
	    String json = gson.toJson(teste);
	    
	    fw.write(json);
	    
	    save = true;
	    
	}catch (Exception e) {
	    System.out.println("Erro: " + e.getMessage());
	}
	
	if(save){
	    sceneSwitch.telaFarmacia();
	}
	
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	Image mapa = new Image("/Placeholders/");
	
	String nomeUsuario = LoggedUser.userName();
	lblUsername.setText(nomeUsuario);
	
	Tooltip t1 = new Tooltip("Droga Raia");
	Tooltip t2 = new Tooltip("Drogaria Popular");
	Tooltip t3 = new Tooltip("Rede Saúde");
	Tooltip t4 = new Tooltip("Pague Pouco");
	
	btnPin1.setTooltip(t1);
	btnPin2.setTooltip(t2);
	btnPin3.setTooltip(t3);
	btnPin4.setTooltip(t4);
    }
}
