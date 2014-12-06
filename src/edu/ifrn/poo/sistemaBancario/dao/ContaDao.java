package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDao {
    public void inserir(Conta c) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        

        //Construir o comando SQL
        String sql = "INSERT INTO conta" +  "(numero, ativa, saldo) VALUES" + "(?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
        //preparedStatement.setInt(1, 1);
        preparedStatement.setInt(1, c.getNumero());
        preparedStatement.setBoolean(2, c.getAtiva());
        preparedStatement.setDouble(3, c.getSaldo());
        
        //Executar e validar o comando SQL.
        preparedStatement.executeUpdate();
    }

    public Integer[] listarConta() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        Integer[] res = new Integer[this.quantidadeContas()];
        int i = 0;
        
        //Construir o comando SQL
        String sql = "SELECT numero FROM Conta ORDER BY numero ASC";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            res[i] = rs.getInt("numero");                       
            i++;
        }
        return res;          
    }
    
    private int quantidadeContas() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade = 0;
        
        //Construir o comando SQL
        String sql = "SELECT COUNT(*) FROM conta";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
}