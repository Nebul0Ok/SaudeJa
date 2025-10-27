package Classes;

public class Medico {
    public int id;
    public String nome;
    public String email;
    public String senha;
    public String whatsapp;
    public String crm;

    public Medico(int id, String nome, String email, String senha, String whatsapp, String crm) {
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.senha = senha;
	this.whatsapp = whatsapp;
	this.crm = crm;
    }

    public Medico(String nome, String email, String senha, String whatsapp, String crm) {
	this.nome = nome;
	this.email = email;
	this.senha = senha;
	this.whatsapp = whatsapp;
	this.crm = crm;
    }

    public Medico(String nome, String email, String senha, String crm) {
	this.nome = nome;
	this.email = email;
	this.senha = senha;
	this.crm = crm;
    }

    public Medico(String nome, String email, String senha) {
	this.nome = nome;
	this.email = email;
	this.senha = senha;
    }
    
    
}
