package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.ContaDao;
import edu.ifrn.poo.sistemaBancario.dominio.Conta;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ControladorConta {
    //public void cadastrarConta(int numero, boolean ativa, double saldo) throws ClassNotFoundException, SQLException {
        //ContaDao conta_dao = new ContaDao();
        //conta_dao.inserir(numero, ativa, saldo);          
    //}
    
    public void cadastrarConta(Conta c) throws ClassNotFoundException, SQLException {
        ContaDao conta_dao = new ContaDao();
        conta_dao.inserir(c);           
    }
    
    public void verConta(Conta c) throws ClassNotFoundException, SQLException {
        ContaDao conta_dao = new ContaDao();
        conta_dao.listarConta();
    }
    
    public int getIdByNumero(int numero)  throws ClassNotFoundException, SQLException {
        ContaDao contadao = new ContaDao();
        
        return contadao.getIdByNumero(numero);
    }
    
    public double getSaldoByNumero(int numero)  throws ClassNotFoundException, SQLException {
        ContaDao contadao = new ContaDao();
        
        return contadao.getSaldoByNumero(numero);
    }
    
    public void atualizarSaldo(double saldo, int idConta)  throws ClassNotFoundException, SQLException {
        ContaDao contadao = new ContaDao();
        
        contadao.atualizarSaldo(saldo, idConta);
    }
    
    public DefaultComboBoxModel listarContas() throws ClassNotFoundException, SQLException {
        ContaDao dao = new ContaDao();
        Integer[] contas = dao.listarNumeroContas();
        DefaultComboBoxModel df = new DefaultComboBoxModel(contas);
        return df;
    }
    
    public DefaultTableModel listarConta() throws ClassNotFoundException, SQLException {
        DefaultTableModel dft = new DefaultTableModel();
        ContaDao dao = new ContaDao(); 
        
        Iterator<Conta> it = dao.listarConta().iterator();
        Conta c;
        
        Object[] obj;
        
	// Colunas //
	dft.addColumn("Número Conta");
        dft.addColumn("Situação");
        dft.addColumn("Saldo");
        dft.addColumn("Nome Cliente");
        dft.addColumn("Telefone");
        dft.addColumn("E-mail");
                          
        while(it.hasNext()) {
            c = it.next();
            
            obj = new Object[6];
            obj[0] = c.getNumero();
            obj[1] = c.getAtiva();
            obj[2] = c.getSaldo();
            obj[3] = c.getCliente().getNome();
            obj[4] = c.getCliente().getTelefone();
            obj[5] = c.getCliente().getEmail();
            dft.addRow(obj);

        }
       
        return dft;
    }
    
   
}