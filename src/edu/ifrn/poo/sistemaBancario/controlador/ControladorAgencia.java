package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.AgenciaDao;
import edu.ifrn.poo.sistemaBancario.dominio.Agencia;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ControladorAgencia {
    public void cadastrarAgencia(Agencia a) throws ClassNotFoundException, SQLException {
        AgenciaDao agencia_dao = new AgenciaDao();    
        agencia_dao.inserir(a);
    }
    
    public DefaultComboBoxModel listarAgencias() throws ClassNotFoundException, SQLException {
        AgenciaDao dao = new AgenciaDao();
        Integer[] agencias = dao.listarNumAgencias();
        DefaultComboBoxModel df = new DefaultComboBoxModel(agencias);        
        return df;
    }

    public DefaultTableModel listarAgenciaTabela() throws ClassNotFoundException, SQLException {
        DefaultTableModel dft = new DefaultTableModel();
        AgenciaDao dao = new AgenciaDao();
        
        dft.addColumn("Número ", dao.listarNumAgencias());
        dft.addColumn("Nome ", dao.listarNomeAgencias());
        //dft.addColumn("Categoria", dao.listarCategoria());        
        return dft;
    }   
}