package edu.ifrn.poo.sistemaBancario.dominio;

public class PessoaFisica extends Cliente {
//    public PessoaFisica(String nome, String endereco, String email) {
//	super(nome, endereco, email);
	
//    }
    String cpf;
    int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
