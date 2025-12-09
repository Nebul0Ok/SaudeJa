package Controller;

import Classes.LoggedUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Classes.Card;
import com.google.gson.Gson;
import java.io.FileWriter;

public class AgendarController extends BaseController implements Initializable{
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
    private HBox hbContent;

    @FXML
    private Label lblAgendarConsulta;

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
    void btnAgendClickar(MouseEvent event) {

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
    void btnMedClickar(MouseEvent event) {
	sceneSwitch.telaPrincipal();
    }

    @FXML
    void btnRecClickar(MouseEvent event) {
	sceneSwitch.telaReciclagem();
    }

    @FXML
    void btnSaibaClickar(MouseEvent event) {
	sceneSwitch.telaSobrenos();
    }
    
    public void initialize(){
    	String nomeUsuario = LoggedUser.userName();
	lblUsername.setText(nomeUsuario);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	String nomeUsuario = LoggedUser.userName();
	lblUsername.setText(nomeUsuario);
	
	HBox card1= Card.medcardGen("Dr. Cássio Marques de Araújo", "/Icons/medico1.jpg", "Cardiologista", "+55 9 99999-9999", sceneSwitch);
	HBox card2= Card.medcardGen("Dra. Mônica de Souza", "/Icons/medico2.jpg", "Oftalmologista", "+55 5 5555-5555", sceneSwitch);
	HBox card3= Card.medcardGen("Dr. Carlos Frederico Médici", "/Icons/medico3.jpg", "Oftalmologista", "+55 5 5555-5555", sceneSwitch);
	HBox card4= Card.medcardGen("Dra. Magali Lima", "/Icons/medico4.jpg", "Oftalmologista", "+55 5 5555-5555", sceneSwitch);
	
	card1.setOnMouseClicked(e -> {
		 Gson gson = new Gson();
		 boolean save = false;
		 String nome = (String) card1.getUserData();
		 
		 
		 try (FileWriter fr = new FileWriter("src/main/resources/UserLogged/Clicado.json")){
		     
		     String json = gson.toJson(nome);
		     
		     fr.write(json);
		     
		     save = true;
		     
		 } catch (Exception ex) {
		     System.out.println("Erro: " + ex.getMessage());
		 }
		 
		 if(save){
		     sceneSwitch.telaMedico();
		 }
	});
	
	hbContent.getChildren().add(card1);
	hbContent.getChildren().add(card2);
	hbContent.getChildren().add(card3);
	hbContent.getChildren().add(card4);
	

	
    }
    
}
