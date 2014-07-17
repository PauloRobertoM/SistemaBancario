package edu.ifrn.poo.sistemaBancario.dominio;

import javax.swing.JOptionPane;

public class Conta {
    private int numero;
    private boolean ativa;
    private String dono;  // verificar
    private double saldo;
    private double limiteDiario = 1000;  // verificar

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
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getLimiteDiario() {
        return limiteDiario;
    }
    public void setLimiteDiario(double limiteDiario) {
        this.limiteDiario = limiteDiario;
    }	

    public boolean sacar(double valor){
//        if (saldo < valor || limiteDiario < valor){
//            return false;
//        }else{
//            saldo -= valor;
//            limiteDiario -= valor;
//            return true;
//        }

        try{
            if (saldo >= valor){
                saldo -= valor;
                return true;
            }
            else{
                if (valor < 0){
                        JOptionPane.showMessageDialog(null, "Valor inválido. Não é possível realizar o saque.");
                }
                else{
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                }
//		return false;
            }
        }
        catch (NumberFormatException nfe2){
            JOptionPane.showMessageDialog(null, "Só será aceito valores numéricos");
        }
        return false;
    }

    public void depositar(double valor){
        //saldo += valor; 
        try{
            if (valor < 0){
                JOptionPane.showMessageDialog(null, "Valor inválido. Não é possível realizar o depósito.");
            }
            else{
                saldo += valor;
            }
        }
        catch(NumberFormatException nfe1){
            JOptionPane.showMessageDialog(null, "Só será aceito valores numéricos");
        }
    }

    public boolean transferir(Conta destino, double valor){
        boolean transferiu = sacar(valor);
        if (transferiu == false){
            return false;
        }else{
            destino.depositar(valor);
            return true;
        }
    }

    public void cancelarConta(){
        ativa = false;
    } 
}
