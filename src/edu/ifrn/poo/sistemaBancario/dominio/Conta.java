package edu.ifrn.poo.sistemaBancario.dominio;

public class Conta{
    private int numero;
    private boolean ativa;
    private double saldo;
    
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
    
    public boolean sacar(double valor){
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

    public void depositar(double valor){
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
    
    public double verSaldo(){
        return saldo;
    }

    public void cancelarConta(){
        ativa = false;
    }
    
    public void verInformacoesCliente(){
        
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
    
    public String verSituacaoConta(){
        
        return "";
    }
}
