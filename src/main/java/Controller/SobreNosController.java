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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SobreNosController extends BaseController implements Initializable{
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
    private ImageView ivFoto;

    @FXML
    private ImageView ivFoto1;

    @FXML
    private Label lblContent;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblUsername;

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
    void btnAgendClickar(MouseEvent event) {
	sceneSwitch.telaMedico();
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

    }

    
    public void Initialize(){
    
    	String nomeUsuario = LoggedUser.userName();
	lblUsername.setText(nomeUsuario);
	
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		String nomeUsuario = LoggedUser.userName();
	lblUsername.setText(nomeUsuario);
    }
    
}
