package Controller;

import DAO.ClienteDao;
import DAO.ComercianteDAO;
import DAO.MedicoDAO;
import Utility.HashSenha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TelaLoginController {
    
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
    private TextField txtSenha;

    @FXML
    void btnClienteClick(ActionEvent event) {
	usuario = "cliente";
	lblUserAtual.setText("Cliente");
	txtEmail.setText("");
	txtSenha.setText("");
    }

    @FXML
    void btnComercianteClick(ActionEvent event) {
	usuario = "comerciante";
	lblUserAtual.setText("Comerciante");
	txtEmail.setText("");
	txtSenha.setText("");	
    }

    @FXML
    void btnLogin(ActionEvent event) {
	String email = txtEmail.getText();
	String senha = txtSenha.getText();
	boolean cadastro = false;
	
	senha = HashSenha.senhaHash(senha);
	
	if(usuario.equals("cliente")){
	    cadastro = ClienteDao.sessaoLogin(email, senha);
	    System.out.println("Cliente Logado");
	}
	else if(usuario.equals("medico")){
	    cadastro = MedicoDAO.sessaoLogin(email, senha);
	    System.out.println("Medico Logado");
	}
	else{
	    cadastro = ComercianteDAO.sessaoLogin(email, senha);
	    System.out.println("Comerciante Logado");
	}
	
    }

    @FXML
    void btnMedicoClick(ActionEvent event) {
	usuario = "medico";
	lblUserAtual.setText("Medico");
	txtEmail.setText("");
	txtSenha.setText("");		
    }
}
