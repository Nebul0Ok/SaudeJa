package Controller;

import Classes.LoggedUser;
import DAO.ClienteDao;
import DAO.ComercianteDAO;
import DAO.MedicoDAO;
import Utility.HashSenha;
import Utility.SceneSwitch;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TelaLoginController extends BaseController implements Initializable{
    
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
	    
	    if(cadastro){
		LoggedUser.queryUser(email, senha);
		
		sceneSwitch.telaPrincipal();
	    }else{
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText("Login Falhou, tente denovo!");
		alerta.showAndWait();
	    
	    }
	    
	}
	else if(usuario.equals("medico")){
	    cadastro = MedicoDAO.sessaoLogin(email, senha);
	    System.out.println("Medico Logado");
	    
	    if(cadastro){
		sceneSwitch.telaPrincipal();
	    }
	}
	else{
	    cadastro = ComercianteDAO.sessaoLogin(email, senha);
	    System.out.println("Comerciante Logado");
	    
	    if(cadastro){
		sceneSwitch.telaPrincipal();
	    }
	}
	
    }

    @FXML
    void btnMedicoClick(ActionEvent event) {
	usuario = "medico";
	lblUserAtual.setText("Medico");
	txtEmail.setText("");
	txtSenha.setText("");		
    }
    
        @FXML
    void btnClickCadastrar(ActionEvent event) {
	    sceneSwitch.telaCadastro();
    }
    
    public void handleEnter (KeyEvent event){
	if(event.getCode() == KeyCode.ENTER){
	String email = txtEmail.getText();
	String senha = txtSenha.getText();
	boolean cadastro = false;
	
	senha = HashSenha.senhaHash(senha);
	
	if(usuario.equals("cliente")){
	    cadastro = ClienteDao.sessaoLogin(email, senha);
	    System.out.println("Cliente Logado");
	    
	    if(cadastro){
		LoggedUser.queryUser(email, senha);
		
		sceneSwitch.telaPrincipal();
	    }else{
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText("Login Falhou, tente denovo!");
		alerta.showAndWait();
	    
	    }
	    
	}
	else if(usuario.equals("medico")){
	    cadastro = MedicoDAO.sessaoLogin(email, senha);
	    System.out.println("Medico Logado");
	    
	    if(cadastro){
		sceneSwitch.telaPrincipal();
	    }
	}
	else{
	    cadastro = ComercianteDAO.sessaoLogin(email, senha);
	    System.out.println("Comerciante Logado");
	    
	    if(cadastro){
		sceneSwitch.telaPrincipal();
	    }
	}
	}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	
	javafx.application.Platform.runLater(() -> {
	    Scene scene = btnLogin.getScene();
	    
	    scene.setOnKeyPressed(this::handleEnter);
	});
	
    }
    
    
}
