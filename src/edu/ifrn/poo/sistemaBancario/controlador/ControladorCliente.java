package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.ClienteDao;
import edu.ifrn.poo.sistemaBancario.dominio.Cliente;
import java.sql.SQLException;

public class ControladorCliente {
    public void cadastrarCliente(Cliente c) throws ClassNotFoundException, SQLException {
//        HabilitacaoDao habilitacao_dao = new HabilitacaoDao();
        ClienteDao cliente_dao = new ClienteDao();
//        int habilitacao_numHab = habilitacao_dao.getNumHab(_numHab.intValue());
//                
//        if (habilitacao_numHab < 0){
//            habilitacao_dao.inserir(habilitacao_numHab, dataNasc, endereco);
//            habilitacao_numHab = habilitacao_dao.getNumHab(_numHab.intValue());
//        }
                
        cliente_dao.inserir(c);
                
    }
    public int getIdByNome(String nome) throws ClassNotFoundException, SQLException {
        ClienteDao cliente_dao = new ClienteDao();
        
        return cliente_dao.getIdByNome(nome);
    }
}
