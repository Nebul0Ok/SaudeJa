package Controller;

import Classes.Cliente;
import DAO.ClienteDao;
import DAO.ComercianteDAO;
import DAO.MedicoDAO;
import Utility.HashSenha;
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
    private Label lblEspecifico;

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
    private TextField txtEspecifico;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;
    
    @FXML
    public void cadastrarUsuario(ActionEvent event){
	String nome = txtNome.getText();
	String email = txtEmail.getText();
	String senha = txtSenha.getText();
	String especifico = txtEspecifico.getText();
	boolean cadastro = true;
	senha = HashSenha.senhaHash(senha);
	
	Cliente cliente = new Cliente(nome, senha, email);
	
	if(usuario.equals("cliente")){
	    cadastro = ClienteDao.cadastrar(nome, email, senha);
	    System.out.println("Cliente Cadastrado");
	}
	else if(usuario.equals("medico")){
	    cadastro = MedicoDAO.cadastrar(nome, email, especifico, senha);
	    System.out.println("Medico Cadastrado");
	}
	else{
	    cadastro = ComercianteDAO.cadastrar(nome, email, especifico, senha);
	    System.out.println("Comerciante Cadastrado");
	}
	
    }
    
    @FXML
    void btnClienteClick(ActionEvent event) {
	usuario = "cliente";
	lblUserAtual.setText("Cliente");
	txtNome.setText(null);
	txtEmail.setText(null);
	txtSenha.setText(null);
	txtEspecifico.setText(null);
	
	txtEspecifico.setVisible(false);
	lblEspecifico.setVisible(false);
    }

    @FXML
    void btnComercianteClick(ActionEvent event) {
	usuario = "comerciante";
	lblUserAtual.setText("Comerciante");
	
	txtNome.setText(null);
	txtEmail.setText(null);
	txtSenha.setText(null);
	txtEspecifico.setText(null);
	
	lblEspecifico.setText("CNPJ:");
	
	txtEspecifico.setVisible(true);
	lblEspecifico.setVisible(true);
    }

    @FXML
    void btnMedicoClick(ActionEvent event) {
	usuario = "medico";
	lblUserAtual.setText("Medico");
	txtNome.setText(null);
	txtEmail.setText(null);
	txtSenha.setText(null);
	txtEspecifico.setText(null);
	lblEspecifico.setText("CRM:");
	
	txtEspecifico.setVisible(true);
	lblEspecifico.setVisible(true);
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	txtEspecifico.setVisible(false);
	lblEspecifico.setVisible(false);
    }    
    
}
