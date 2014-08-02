package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.BancoDao;
import edu.ifrn.poo.sistemaBancario.dominio.Banco;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ControladorBanco {
    public void cadastrarClienteBanco(Banco b) throws ClassNotFoundException, SQLException {
        BancoDao banco_dao = new BancoDao();
           
        banco_dao.inserir(b);           
    }
    
     public DefaultComboBoxModel listarBancos() throws ClassNotFoundException, SQLException {
        BancoDao dao = new BancoDao();
        Integer[] bancos = dao.listarNumBancos();
        DefaultComboBoxModel df = new DefaultComboBoxModel(bancos);
        
        return df;
    }

    public DefaultTableModel listarBancoTabela() throws ClassNotFoundException, SQLException {
        DefaultTableModel dft = new DefaultTableModel();
        BancoDao dao = new BancoDao();
        
        dft.addColumn("Número ", dao.listarNumBancos());
        dft.addColumn("Nome ", dao.listarNomeBancos());
//        dft.addColumn("Categoria", dao.listarCategoria());  
        return dft;
    }
}
