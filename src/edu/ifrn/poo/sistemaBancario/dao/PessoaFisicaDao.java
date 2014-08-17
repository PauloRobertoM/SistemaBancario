
package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaFisicaDao {
    public void inserir(PessoaFisica pf) throws SQLException, ClassNotFoundException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        
        //Construir o comando SQL
        String sql = "INSERT INTO PessoaFisica (cpf, Cliente_idCliente) VALUES (?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
         //preparedStatement.setInt(1, 1);
        preparedStatement.setString(1, pf.getCpf());
        preparedStatement.setInt(2, pf.getIdCliente());
        
        //Executar e validar o comando SQL.
        preparedStatement.executeUpdate();      

    }
}
