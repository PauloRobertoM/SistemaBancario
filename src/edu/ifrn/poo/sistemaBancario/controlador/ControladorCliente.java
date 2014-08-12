package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.ClienteDao;
import edu.ifrn.poo.sistemaBancario.dominio.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
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
       
        Iterator<Cliente> it = dao.listarCliente().iterator();
        Cliente c;
        Object[] obj;
        
        // Colunas //
        dft.addColumn("Nome Cliente");
        dft.addColumn("Telefone");
        dft.addColumn("E-mail");
                          
        while(it.hasNext()) {
            c = it.next();
                     
            obj = new Object[3];
            obj[0] = c.getNome();
            obj[1] = c.getTelefone();
            obj[2] = c.getEmail();
            
            dft.addRow(obj);
        }
		
        return dft;
    }
	
}