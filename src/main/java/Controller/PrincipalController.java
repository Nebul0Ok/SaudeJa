package Controller;

import Classes.Card;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PrincipalController extends BaseController implements Initializable{

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
        Stage stage = (Stage) btnMinMax.getScene().getWindow();
        stage.setFullScreen(true);
    }

        @FXML
    void btnMedClickar(MouseEvent event) {
    }

    @FXML
    void btnRecClickar(MouseEvent event) {

    }

    @FXML
    void btnAgendClickar(MouseEvent event) {

    }

    @FXML
    void btnSaibaClickar(MouseEvent event) {

    }
    
    public void initialize(URL url, ResourceBundle rb) {
	
	pnlContent.setSpacing(10);
	
	Card card1 = new Card();
	VBox card1Teste = card1.cardGen("Ibuprofeno", "/imagemRemedio/ibuprofeno.png");
	pnlContent.getChildren().add(card1Teste);
	
	Card card2 = new Card();
	VBox card2Teste = card2.cardGen("Dipirona", "/imagemRemedio/dipirona.png");
	pnlContent.getChildren().add(card2Teste);
	
	Card card3 = new Card();
	VBox card3Teste = card3.cardGen("Amoxicilina", "/imagemRemedio/amoxicilina.png");
	pnlContent.getChildren().add(card3Teste);
	
    } 

}