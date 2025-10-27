package Classes;

public class Cliente {
    int id;
    public String nome;
    public String senha;
    public String email;

    public Cliente(int id, String nome, String senha, String email) {
	this.id = id;
	this.nome = nome;
	this.senha = senha;
	this.email = email;
    }

    public Cliente(String nome, String senha, String email) {
	this.nome = nome;
	this.senha = senha;
	this.email = email;
    }

    public Cliente(String senha, String email) {
	this.senha = senha;
	this.email = email;
    }
    
    
}
