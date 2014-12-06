package edu.ifrn.poo.sistemaBancario.dominio;

public class Cliente{
    private String nome;
    private String telefone;
    private String email;
    boolean ePessoaFisica;

    public boolean isePessoaFisica() {
        return ePessoaFisica;
    }

    public void setePessoaFisica(boolean ePessoaFisica) {
        this.ePessoaFisica = ePessoaFisica;
    }
    
    public String getNome() {
	return nome;
    }
    public void setNome(String nome) {
	this.nome = nome;
    }
    public String getTelefone() {
    	return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //  << Construtor >>  //
//    public Cliente(String nome, String telefone, String email){
//        this.nome = nome;
//        this.telefone = telefone;
//        this.email = email;
//    }
}
