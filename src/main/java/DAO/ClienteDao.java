package DAO;

import java.sql.*;

public class ClienteDao {

    static String url = "jdbc:sqlite:BancoDados.db";

    public static boolean cadastrar(String nome, String email, String senha) {
	Connection conexao = null;
	PreparedStatement comando = null;
	ResultSet resultado = null;

	try {
	    conexao = DriverManager.getConnection(url);
	    String pesquisa = "SELECT * FROM cliente WHERE email=?";
	    String registro = "INSERT INTO cliente (nome, email, senha) VALUES (?,?,?)";

	    try {
		comando = conexao.prepareStatement(pesquisa);
		comando.setString(1, email);

		resultado = comando.executeQuery();

		if (resultado.next()) {
		    //Email Existe, retorna falso
		    return false;
		}

		resultado.close();
		comando.close();

		//Email não existe, continua
		comando = conexao.prepareStatement(registro);

		comando.setString(1, nome);
		comando.setString(2, email);
		comando.setString(3, senha);

		comando.executeUpdate();

	    } catch (Exception e) {
		System.out.println("Falha na execucao: " + e.getMessage());
		return false;
	    } finally {
		//Fecha Conexão
		try {
		    if (resultado != null){
			resultado.close();
		    }
		    
		    if (comando != null){
			comando.close();
		    }
		    
		    if (conexao != null){
			conexao.close();
		    }
		    
		} catch (Exception e) {
		    System.out.println("Erro ao fechar o banco: " + e.getMessage());
		}
	    }

	} catch (SQLException ex) {
	    System.out.println("Falha na execucao: " + ex.getMessage());
	    return false;
	}

	return true;
    }
    
    public static boolean sessaoLogin(String email, String senha) {
	Connection conexao = null;
	PreparedStatement comando = null;
	ResultSet resultado = null;

	try {
	    conexao = DriverManager.getConnection(url);
	    String login = "SELECT * FROM cliente WHERE email=? AND senha=?";

		try {
			comando = conexao.prepareStatement(login);

			comando.setString(1, email);
			comando.setString(2, senha);

			resultado = comando.executeQuery();

			if (resultado.next()) {
			    System.out.println("Login Bem-Sucedido");
			    return true;
			} else {
			    System.out.println("Login Falhou");
			    return false;
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
	
	return false;
    }
    
}
