package edu.ifrn.poo.sistemaBancario.dominio;

public class PessoaJuridica extends Cliente {
//    public PessoaJuridica(String nome, String endereco, String email) {
//	super(nome, endereco, email);
	
//    }
    String cnpj, nomeFantasia;
    int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica(String cnpj, String nomeFantasia, int idCliente) throws CNPJInvalidoException {
	if(cnpj.length() != 14)	{
            throw new CNPJInvalidoException("CNPJ deve conter 14 dígitos");
	}
	for(int i = 0; i < cnpj.length(); i++){
            char c = cnpj.charAt(i);
            if(!Character.isDigit(c)){
		throw new CNPJInvalidoException("CNPJ deve conter apenas dígitos");
            }
	}
	
	this.cnpj = cnpj;
	this.nomeFantasia = nomeFantasia;
	this.idCliente = idCliente;
    }
    
}
