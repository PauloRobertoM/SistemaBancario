package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ContaDao {
    
    public void inserir(Conta c) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        
        //construir o comando SQL
   
        String sql = "INSERT INTO conta" +  "(idConta, numero, ativa, saldo) VALUES" + "(?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
//        preparedStatement.setInt(1, 1);
        preparedStatement.setInt(1, c.getNumero());
        preparedStatement.setBoolean(2, c.getAtiva());
        preparedStatement.setDouble(3, c.getSaldo());
        
        //executar e validar o comando SQL.
        preparedStatement.executeUpdate();
    }
    
    public int getIdByNumero(int numero) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
