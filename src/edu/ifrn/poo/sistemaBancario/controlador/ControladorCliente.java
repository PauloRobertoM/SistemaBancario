package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.ClienteDao;
import edu.ifrn.poo.sistemaBancario.dominio.Cliente;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ControladorCliente {
    public void cadastrarCliente(Cliente c) throws ClassNotFoundException, SQLException {
        ClienteDao cliente_dao = new ClienteDao();   
        cliente_dao.inserir(c);
    }
       
    public void verCliente(Cliente c) throws ClassNotFoundException, SQLException {
        ClienteDao cliente_dao = new ClienteDao();
        cliente_dao.listarCliente();
    }
    
    public DefaultTableModel listarCliente() throws ClassNotFoundException, SQLException {
        DefaultTableModel dft = new DefaultTableModel();
        ClienteDao dao = new ClienteDao();        
        dft.addColumn("Cliente ", dao.listarCliente());
        //dft.addColumn("Data de Vencimento", dao.listarDataVenc());
        //dft.addColumn("Categoria", dao.listarCategoria());
        return dft;
    }
}