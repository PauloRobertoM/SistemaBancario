package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.ContaDao;
import java.sql.SQLException;

public class ControladorConta {
    public void cadastrarConta(int numero, boolean ativa, double saldo) throws ClassNotFoundException, SQLException {
        ContaDao conta_dao = new ContaDao();

        conta_dao.inserir(numero, ativa, saldo);
                
    }
    public int getIdByNumero(int numero) throws ClassNotFoundException, SQLException {
         ContaDao conta_dao = new ContaDao();
        
        return conta_dao.getIdByNumero(numero);
    }
    
}
