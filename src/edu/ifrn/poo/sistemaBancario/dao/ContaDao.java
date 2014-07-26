package edu.ifrn.poo.sistemaBancario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ContaDao {
    
    public void inserir(int numero, boolean ativa, double saldo) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        
        //construir o comando SQL
   
        String sql = "INSERT INTO conta" +  "(idConta, numero, ativa, saldo) VALUES" + "(?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
        preparedStatement.setInt(1, 1);
        preparedStatement.setInt(2, numero);
        preparedStatement.setBoolean(3, ativa);
        preparedStatement.setDouble(4, saldo);
        
        //executar e validar o comando SQL.
        preparedStatement.executeUpdate();
    }
    
    public int getIdByNumero(int numero) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
