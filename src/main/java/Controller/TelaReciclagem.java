package Controller;

import Classes.LoggedUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    }  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	Image mapa = new Image("/Placeholders/");
	
	String nomeUsuario = LoggedUser.userName();
	lblUsername.setText(nomeUsuario);
    }
}
