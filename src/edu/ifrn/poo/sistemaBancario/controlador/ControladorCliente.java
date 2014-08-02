package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.ClienteDao;
import edu.ifrn.poo.sistemaBancario.dominio.Cliente;
import java.sql.SQLException;

public class ControladorCliente {
    public void cadastrarCliente(Cliente c) throws ClassNotFoundException, SQLException {
        ClienteDao cliente_dao = new ClienteDao();
           
        cliente_dao.inserir(c);
                
    }
    public int getIdByNome(String nome) throws ClassNotFoundException, SQLException {
        ClienteDao cliente_dao = new ClienteDao();
        
        return cliente_dao.getIdByNome(nome);
    }
}
