package edu.ifrn.poo.sistemaBancario.dominio;

public class Agencia {
    private int numero;
    private String nome;
    private String endereco;
    private String nomeGerente;
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNomeGerente() {
        return nomeGerente;
    }
    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }  
}