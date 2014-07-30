package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {
    public void inserir(Cliente c) throws SQLException, ClassNotFoundException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        
        //construir o comando SQL
        String sql = "INSERT INTO cliente VALUES (?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setString(1, c.getNome());
        stm.setString(2, c.getTelefone());
        stm.setString(3, c.getEmail());
        
        
        
        //executar e validar o comando SQL.
        stm.execute();
    }
    
//    public void inserir(String nome, String telefone, String email) throws ClassNotFoundException, SQLException {
//        //Estabelecer a conexão
//        Connection conn = ConnectionFactory.getConnection();        
//        //construir o comando SQL
//        String sql = "INSERT INTO cliente" +  "(idCliente, nome, telefone, email) VALUES" + "(?,?,?,?)";
//        PreparedStatement stm = conn.prepareStatement(sql);
//        int id=0;
//        stm.setInt(1, id);
//        stm.setString(2, nome);
//        stm.setString(3, telefone);
//        stm.setString(4, email);
//
//        //executar e validar o comando SQL.
//        stm.execute();
//    }
    
    public int getIdByNome(String nome) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
