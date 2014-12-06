package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.AgenciaDao;
import edu.ifrn.poo.sistemaBancario.dao.BancoDao;
import edu.ifrn.poo.sistemaBancario.dominio.Agencia;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;

public class ControladorAgencia {
    public void cadastrarAgencia(Agencia a) throws ClassNotFoundException, SQLException {
        AgenciaDao agencia_dao = new AgenciaDao();    
<<<<<<< HEAD
        agencia_dao.inserir(a);
    }
    
    public DefaultComboBoxModel listarAgencias() throws ClassNotFoundException, SQLException {
        AgenciaDao dao = new AgenciaDao();
        Integer[] agencias = dao.listarNumAgencias();
=======
        BancoDao banco_dao = new BancoDao();

        agencia_dao.inserir(a);
    }
    
    public int getIdByNumero(int numero) throws ClassNotFoundException, SQLException {
        AgenciaDao agenciadao = new AgenciaDao();
        
        return agenciadao.getIdByNumero(numero);
    }
    
    public DefaultComboBoxModel listarAgencias() throws ClassNotFoundException, SQLException {
       	AgenciaDao dao = new AgenciaDao();
        String[] agencias = dao.listarNumeroAgencias();
>>>>>>> origin/master
        DefaultComboBoxModel df = new DefaultComboBoxModel(agencias);        
        return df;
    }

    public DefaultTableModel listarAgencia() throws ClassNotFoundException, SQLException {
        DefaultTableModel dft = new DefaultTableModel();
        AgenciaDao dao = new AgenciaDao(); 
       
        Iterator<Agencia> it = dao.listarAgencia().iterator();
        Agencia a;
        Object[] obj;
              
	// Colunas //
        dft.addColumn("Número");
        dft.addColumn("Nome");
        dft.addColumn("Endereço");
        dft.addColumn("Nome do Gerente");
        dft.addColumn("Nome Banco");
        dft.addColumn("Número");
        
<<<<<<< HEAD
        dft.addColumn("Número ", dao.listarNumAgencias());
        dft.addColumn("Nome ", dao.listarNomeAgencias());
        //dft.addColumn("Categoria", dao.listarCategoria());        
        return dft;
    }   
=======
        
        while(it.hasNext()) {
            a = it.next();
             
            obj = new Object[7];
            obj[0] = a.getNumero();
            obj[1] = a.getNome();
            obj[2] = a.getEndereco();
            obj[3] = a.getNomeGerente();
//            obj[4] = a.getBanco().getNome();
//            obj[5] = a.getBanco().getNumero();
//                        
            dft.addRow(obj);
        }
		
        return dft;
    }
    
>>>>>>> origin/master
}