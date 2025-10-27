package Controller;

import Classes.Cliente;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

public class TelaLoginController implements Initializable {
    private String usuario = "cliente";
    
     @FXML
    private Button btnCadastro;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnComerciante;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnMedico;

    @FXML
    private Label lblCadastrar;

    @FXML
    private Label lblQuemEstaLogando;

    @FXML
    private Label lblUserAtual;

    @FXML
    private BorderPane pnlBackground;

    @FXML
    private VBox pnlLoginPanel;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;
    
    @FXML
    public void cadastrarUsuario(ActionEvent event){
	String nome = txtNome.getText();
	String email = txtEmail.getText();
	String senha = txtSenha.getText();
	
	Cliente cliente = new Cliente(nome, senha, email);
	
	System.out.printf("%s%n%s%n%s", cliente.nome, cliente.email, cliente.senha);
	
    }
    
    @FXML
    void btnClienteClick(ActionEvent event) {
	usuario = "cliente";
	lblUserAtual.setText("Cliente");
    }

    @FXML
    void btnComercianteClick(ActionEvent event) {
	usuario = "comerciante";
	lblUserAtual.setText("Comerciante");
    }

    @FXML
    void btnMedicoClick(ActionEvent event) {
	usuario = "medico";
	lblUserAtual.setText("Medico");
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
