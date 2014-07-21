package edu.ifrn.poo.sistemaBancario.dominio;

public class Banco {
    private String nome;
    private int numero;

    public String getNome() {
        return nome;
    }    
    public void setNome(String nome) {
        this.nome = nome;
    }    
    public int getNumero() {
        return numero;
    }    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void buscarAgencia(int numero){

    }
    
    // Construtor //
    public Banco(String nome, int numero){
        this.nome = nome;
        this.numero = numero;
    }    
}