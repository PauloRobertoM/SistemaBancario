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
<<<<<<< HEAD
        String sql = "INSERT INTO cliente VALUES (?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
=======
        String sql = "INSERT INTO Cliente (nome, telefone, email, ePessoaFisica) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
         //preparedStatement.setInt(1, 1);
        preparedStatement.setString(1, c.getNome());
        preparedStatement.setString(2, c.getTelefone());
        preparedStatement.setString(3, c.getEmail());
        preparedStatement.setBoolean(4, c.isePessoaFisica());
        
>>>>>>> origin/master
        
        //Executar e validar o comando SQL.
        preparedStatement.executeUpdate();      

<<<<<<< HEAD
        //Executar e validar o comando SQL.
        stm.execute();
=======
>>>>>>> origin/master
    }
    
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
//    private int quantidadeCliente() throws ClassNotFoundException, SQLException {
//        //Estabelecer a conexão
//        Connection conn = ConnectionFactory.getConnection();
//        ResultSet rs;        
//        int quantidade = 0;
//        
//        //Construir o comando SQL
//        String sql = "SELECT COUNT(*) FROM cliente";
//        PreparedStatement stm = conn.prepareStatement(sql);
//        
//        //Executar e validar o comando SQL.
//        rs = stm.executeQuery();
//        
//        rs.next();        
//        quantidade = rs.getInt(1);
//                
//        return quantidade;
//    }
    
    public String[] listarNomeClientes() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        String[] res = new String[this.quantidadeClientes()];
        int i = 0;
        
<<<<<<< HEAD
        //Construir o comando SQL
        String sql = "SELECT * FROM cliente";
=======
        //construir o comando SQL
        String sql = "SELECT nome FROM Cliente ORDER BY nome ASC";
>>>>>>> origin/master
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            res[i] = rs.getString("nome");                       
            i++;
        }
                
        return res;
    }
<<<<<<< HEAD
    
    private int quantidadeCliente() throws ClassNotFoundException, SQLException {
=======
    private int quantidadeClientes() throws ClassNotFoundException, SQLException {
>>>>>>> origin/master
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade;
        
        //Construir o comando SQL
<<<<<<< HEAD
        String sql = "SELECT COUNT(*) FROM cliente";
=======
        String sql = "SELECT COUNT(*) FROM Cliente";
>>>>>>> origin/master
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
<<<<<<< HEAD
=======
    public int getIdByNome(String cliente) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        
        //construir o comando SQL
        String sql = "SELECT idCliente FROM Cliente WHERE nome = (?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setString(1, cliente);           
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();

        rs.next();
        return rs.getInt("idCliente");  
    }
>>>>>>> origin/master
}