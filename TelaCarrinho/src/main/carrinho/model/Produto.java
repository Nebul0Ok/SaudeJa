package com.example.carrinho.model;


public class Produto {
private String nome;
private double preco;
private String imagemPath;


public Produto(String nome, double preco, String imagemPath) {
this.nome = nome;
this.preco = preco;
this.imagemPath = imagemPath;
}


public String getNome() { return nome; }
public double getPreco() { return preco; }
public String getImagemPath() { return imagemPath; }


public void setNome(String nome) { this.nome = nome; }
public void setPreco(double preco) { this.preco = preco; }
public void setImagemPath(String imagemPath) { this.imagemPath = imagemPath; }
}