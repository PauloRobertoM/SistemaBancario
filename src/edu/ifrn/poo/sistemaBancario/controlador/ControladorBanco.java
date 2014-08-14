package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.BancoDao;
import edu.ifrn.poo.sistemaBancario.dominio.Banco;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;

public class ControladorBanco {
    public void cadastrarClienteBanco(Banco b) throws ClassNotFoundException, SQLException {
        BancoDao banco_dao = new BancoDao();   
        banco_dao.inserir(b);           
    }
    
    public DefaultComboBoxModel listarBancos() throws ClassNotFoundException, SQLException {
        BancoDao dao = new BancoDao();
        String[] bancos = dao.listarNomeBancos();
        DefaultComboBoxModel df = new DefaultComboBoxModel(bancos);
        return df;
    }
    public int getIdByNumero(String nomeBanco) throws ClassNotFoundException, SQLException {
        BancoDao bancodao = new BancoDao();
        
        return bancodao.getIdByNumero(nomeBanco);
    }
    public DefaultTableModel listarBanco() throws ClassNotFoundException, SQLException {
        DefaultTableModel dft = new DefaultTableModel();
        BancoDao dao = new BancoDao(); 
       
        Iterator<Banco> it = dao.listarBanco().iterator();
        Banco b;
        Object[] obj;
       
	// Colunas //
        dft.addColumn("Nome");
        dft.addColumn("Número");
           
        while(it.hasNext()) {
            b = it.next();
            
            obj = new Object[2];
            obj[0] = b.getNome();
            obj[1] = b.getNumero();
            
            dft.addRow(obj);
        }
		
        return dft;
    }
}