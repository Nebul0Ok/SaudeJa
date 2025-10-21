package Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PrincipalController {

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
        Rectangle ret = new Rectangle(100,100, 200,200);
        ret.setFill(Color.BLUE);
        ret.setStroke(Color.BLACK);
        pnlContent.getChildren().add(ret);
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

}