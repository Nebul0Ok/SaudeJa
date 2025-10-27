package Classes;

public class Produto {
    public int id;
    public String nome;
    public double preco;
    public String tipoUso;
    public String tipoConsumo;
    public int dose;
    public String estabelecimento;
    public int quantidade;

    public Produto(int id, String nome, double preco, String tipoUso, String tipoConsumo, int dose, String estabelecimento, int quantidade) {
	this.id = id;
	this.nome = nome;
	this.preco = preco;
	this.tipoUso = tipoUso;
	this.tipoConsumo = tipoConsumo;
	this.dose = dose;
	this.estabelecimento = estabelecimento;
	this.quantidade = quantidade;
    }

    public Produto(String nome, double preco, String tipoUso, String tipoConsumo, int dose, String estabelecimento, int quantidade) {
	this.nome = nome;
	this.preco = preco;
	this.tipoUso = tipoUso;
	this.tipoConsumo = tipoConsumo;
	this.dose = dose;
	this.estabelecimento = estabelecimento;
	this.quantidade = quantidade;
    }

    public Produto(String nome, String tipoUso, String tipoConsumo) {
	this.nome = nome;
	this.tipoUso = tipoUso;
	this.tipoConsumo = tipoConsumo;
    }

    public Produto(String nome, String tipoUso, String tipoConsumo, int dose) {
	this.nome = nome;
	this.tipoUso = tipoUso;
	this.tipoConsumo = tipoConsumo;
	this.dose = dose;
    }
    
    
}
