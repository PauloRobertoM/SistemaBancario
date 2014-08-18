package edu.ifrn.poo.sistemaBancario.dominio;

public class PessoaFisica extends Cliente {
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

     public PessoaFisica(String cpf, int idCliente) throws CPFInvalidoException {
	if(cpf.length()	!= 11)	{
            throw new CPFInvalidoException("CPF deve conter 11 dígitos");
	}
	for(int i = 0; i < cpf.length(); i++){
            char c = cpf.charAt(i);
            if(!Character.isDigit(c)){
		throw new CPFInvalidoException("CPF deve conter apenas dígitos");
            }
	}
	
	this.cpf = cpf;
	this.idCliente = idCliente;
    }
}
