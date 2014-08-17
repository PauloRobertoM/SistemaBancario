package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaJuridicaDao {
    public void inserir(PessoaJuridica pj) throws SQLException, ClassNotFoundException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        
        //Construir o comando SQL
        String sql = "INSERT INTO PessoaJuridica (cnpj, nomeFantasia, Cliente_idCliente) VALUES (?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
         //preparedStatement.setInt(1, 1);
        preparedStatement.setString(1, pj.getCnpj());
        preparedStatement.setString(2, pj.getNomeFantasia());
        preparedStatement.setInt(3, pj.getIdCliente());
        
        //Executar e validar o comando SQL.
        preparedStatement.executeUpdate();      

    }
}
