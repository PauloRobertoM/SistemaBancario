package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public Integer[] listarCliente() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        Integer[] res = new Integer[this.quantidadeCliente()];
        int i = 0;
        
        //construir o comando SQL
        String sql = "SELECT * FROM cliente";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            res[i] = rs.getInt("nome");                       
            i++;
        }
                
        return res;
    }
    private int quantidadeCliente() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade = 0;
        
        //construir o comando SQL
        String sql = "SELECT COUNT(*) FROM cliente";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
   
}
