package edu.ifrn.poo.sistemaBancario.dominio;

import javax.swing.JOptionPane;

public class Conta{
    private int numero;
    private boolean ativa;
    private double saldo;
    Cliente c ;
//    Agencia a;
    int idCliente, idAgencia;
    
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdAgencia() {
        return idAgencia;
    }
    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }  
    
    public boolean getAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void setCliente(Cliente c) {
        this.c = c;
    }
    public Cliente getCliente(){
        return c;
    }
//    public void setAgencia(Agencia a) {
//        this.a = a;
//    }
//    public Agencia getAgencia(){
//        return a;
//    }
    
    public boolean sacar(double valor) {//throws  SaldoInvalidoException{
//        if(valor >= saldo) {
//            saldo -= valor;
//            return true;
//        } 
//        else{
//            if (valor <= 0) {
//                throw new SaldoInvalidoException("Valor Inválido");
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
//            }
//            return false;
//        }
        
        
        try{
            if (saldo >= valor){
                saldo -= valor;
                return true;
            }
            else{
                if (valor < 0){
                        System.out.println("Valor inválido. Não é possível realizar o saque.");
                }
                else{
                        System.out.println("Saldo insuficiente.");
                }
            }
        }
        catch (NumberFormatException nfe2){
            System.out.println("Só serão aceitos valores numéricos");
        }
        return false;
        
    }

    public double sacarBanco(double saldo,double valor) {//throws  SaldoInvalidoException{
        try{
            if (saldo >= valor){
                saldo -= valor;
                
            }
            else{
                if (valor < 0){
                        System.out.println("Valor inválido. Não é possível realizar o saque.");
                }
                else{
                        System.out.println("Saldo insuficiente.");
                }
            }
        }
        catch (NumberFormatException nfe2){
            System.out.println("Só serão aceitos valores numéricos");
        }
        return saldo;
        
    }
    
    public void depositar(double valor) {//throws  SaldoInvalidoException {
//        if(valor <= 0) {
//            throw new SaldoInvalidoException("Valor Inválido");
//        }
//        else{
//            saldo += valor;
//        }
        try{
            if (valor <= 0){
                System.out.println("Valor inválido. Não é possível realizar o depósito.");
            }
            else{
                saldo += valor;
            }
        }
        catch(NumberFormatException nfe1){
            System.out.println("Só serão aceitos valores numéricos");
        }
    }
  
    public double depositarBanco(double saldo, double valor) {//throws  SaldoInvalidoException {
        try{
            if (valor <= 0){
                System.out.println("Valor inválido. Não é possível realizar o depósito.");
            }
            else{
                saldo += valor;
            }
        }
        catch(NumberFormatException nfe1){
            System.out.println("Só serão aceitos valores numéricos");
        }
        return saldo;
    }
    
    public double verSaldo(){
        return saldo;
    }

    public void cancelarConta(){
        ativa = false;
    }
    
    public void verInformacoesCliente(){
//        c.getNome();
//        c.getTelefone();
//        c.getEmail();
    }
    
    public boolean transferirValor(Conta destino, double valor){
        boolean transferiu = sacar(valor);
        if (transferiu == false){
            return false;
        }else{
            destino.depositar(valor);
            return true;
        }
    }
    
    public void mudarLimitedeConta(double limite){
        
    }
    
    public boolean verSituacaoConta(){
        return ativa;
    }
}
