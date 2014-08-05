package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.ContaDao;
import edu.ifrn.poo.sistemaBancario.dominio.Conta;
import java.sql.SQLException;
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
    
    public DefaultTableModel listarContaTabela() throws ClassNotFoundException, SQLException {
        DefaultTableModel dft = new DefaultTableModel();
        ContaDao dao = new ContaDao();    
        dft.addColumn("Conta ", dao.listarConta());
        //dft.addColumn("Data de Vencimento", dao.listarDataVenc());
        //dft.addColumn("Categoria", dao.listarCategoria());
        return dft;
    }
    
    //public int getIdByNumero(int numero) throws ClassNotFoundException, SQLException {
        //ContaDao conta_dao = new ContaDao();  
        //return conta_dao.getIdByNumero(numero);
    //}
}