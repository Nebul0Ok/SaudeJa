package Classes;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoggedUser {
    public String nome;
    public String email;
    public boolean isMedic=false;
    public boolean isMerchant=false;
    
    static String url = "jdbc:sqlite:BancoDados.db";
    static String urlJson = "src/main/resources/UserLogged/UserLogged.json";

    public LoggedUser(String nome, String email) {
	this.nome = nome;
	this.email = email;
    }
    
    public LoggedUser(String nome, String email, boolean isMedic, boolean isMerchant) {
        this.nome = nome;
        this.email = email;
        this.isMedic = isMedic;
        this.isMerchant = isMerchant;
    }    
    
    
    public static void queryUser(String email, String senha){
	Connection conexao = null;
	PreparedStatement comando = null;
	ResultSet resultado = null;

	try {
	    conexao = DriverManager.getConnection(url);
	    String qUser = "SELECT * FROM cliente WHERE email=? AND senha=?";

		try {
			comando = conexao.prepareStatement(qUser);

			comando.setString(1, email);
			comando.setString(2, senha);

			resultado = comando.executeQuery();

			if (resultado.next()) {
			    String nomeUsuario= resultado.getString("nome");
			    String emailUsuario= resultado.getString("email");
			    
			    LoggedUser usuarioLogado = new LoggedUser(nomeUsuario, emailUsuario);
			    
			    Gson gson = new Gson();
			    FileWriter fw = new FileWriter(urlJson);
			    String objJson = gson.toJson(usuarioLogado);
			    fw.write(objJson);
			    fw.close();
			    
			} else {
			    System.out.println("Login Falhou");
			    
			}

		} catch (Exception e) {

			System.out.println("Falha no login: " + e.getMessage());

		}finally{
			   try {
			
			if (conexao != null){conexao.close();}
			
			if (comando != null){comando.close();}
			
			if (resultado != null){resultado.close();}
			
		    } catch (Exception e) {
			System.out.println("Erro de execucao: " + e.getMessage());
		    }
			
		}

	} catch (Exception e) {
	    System.out.println("Falha na conexao com o banco de dados: " + e.getMessage());
	}
    }
	
	
	public static String userName(){
	    try {
	    Gson gson = new Gson();
	    FileReader fr = new FileReader(urlJson);
	    LoggedUser usuarioLogado = gson.fromJson(fr, LoggedUser.class);
	    fr.close();
	    return usuarioLogado.nome;
	    } catch (Exception e) {
		System.out.println("Erro: " + e.getMessage());
	    }
	    
	    return null;
	}
	
    }
