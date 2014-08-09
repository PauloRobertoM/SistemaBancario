package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao {
    public void inserir(Cliente c) throws SQLException, ClassNotFoundException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        
        //Construir o comando SQL
        String sql = "INSERT INTO Cliente" + "(nome, telefone, email) VALUES" + "(?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
         //preparedStatement.setInt(1, 1);
        preparedStatement.setString(1, c.getNome());
        preparedStatement.setString(2, c.getTelefone());
        preparedStatement.setString(3, c.getEmail());
        
        //Executar e validar o comando SQL.
        preparedStatement.executeUpdate();      

    }
    
//    public Integer[] listarCliente() throws ClassNotFoundException, SQLException {
//        //Estabelecer a conexão
//        Connection conn = ConnectionFactory.getConnection();
//        ResultSet rs;
//        Integer[] res = new Integer[this.quantidadeCliente()];
//        int i = 0;
//        
//        //Construir o comando SQL
//        String sql = "SELECT * FROM cliente";
//        PreparedStatement stm = conn.prepareStatement(sql);
//        
//        //Executar e validar o comando SQL.
//        rs = stm.executeQuery();
//        
//        //Converter ResultSet em String        
//        while(rs.next()== true) {
//            res[i] = rs.getInt("nome");                       
//            i++;
//        }
//                
//        return res;
//    }
    public ArrayList<Cliente> listarCliente() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
       // Conta c;
        Cliente c;
        //Construir o comando SQL
        String sql = "SELECT * FROM Cliente ORDER BY nome ASC";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            c = new Cliente();
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            
            clientes.add(c);
          
        }
        return clientes;          
    }
    private int quantidadeCliente() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade = 0;
        
        //Construir o comando SQL
        String sql = "SELECT COUNT(*) FROM cliente";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
}