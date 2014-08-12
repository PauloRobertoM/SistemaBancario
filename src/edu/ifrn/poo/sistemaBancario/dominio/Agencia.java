package edu.ifrn.poo.sistemaBancario.dominio;

public class Agencia{
    private int numero;
    private String nome;
    private String endereco;
    private String nomeGerente;
    Banco b;
	
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
	
    public void setBanco(Banco b) {
        this.b = b;
    }
    public Banco getBanco(){
        return b;
    }
    
    public void criarConta(Cliente c, int numConta, int limConta, String tipoConta){
    
    }
    
    public void buscarConta(int numero){
        
    }
    
    public void buscarCliente(String nome){
        
    }
    
    // Construtor //
//    public Agencia(int numero){
//        this.numero = numero;
//    }
}
