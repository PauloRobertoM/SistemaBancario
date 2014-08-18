package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.Cliente;
import edu.ifrn.poo.sistemaBancario.dominio.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContaDao {
    public void inserir(Conta c) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        

        //Construir o comando SQL
        String sql = "INSERT INTO Conta (numero, ativa, saldo, Cliente_idCliente, Agencia_idAgencia) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        
        //preparedStatement.setInt(1, 1);
        preparedStatement.setInt(1, c.getNumero());
        preparedStatement.setBoolean(2, c.getAtiva());
        preparedStatement.setDouble(3, c.getSaldo());
        preparedStatement.setInt(4, c.getIdCliente());
        preparedStatement.setInt(5, c.getIdAgencia());
        //Executar e validar o comando SQL.
        preparedStatement.executeUpdate();
    }
    
    public ArrayList<Conta> mostrarSaldo() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        ArrayList<Conta> conta = new ArrayList<Conta>();
        Conta c;
        //Construir o comando SQL
        String sql = "SELECT saldo FROM Conta WHERE idConta = (?)";
        PreparedStatement stm = conn.prepareStatement(sql);
       
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            c = new Conta();
            c.setSaldo(rs.getDouble("saldo"));
            
            conta.add(c);
        }
        return conta;          
    }
    
    public void atualizarSaldo(double saldo, int idConta) throws ClassNotFoundException, SQLException {
         //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        

        //Construir o comando SQL
        String sql = "UPDATE Conta SET saldo = (?) WHERE idConta = (?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setDouble(1, saldo);
        stm.setInt(2, idConta);
         
        //Executar e validar o comando SQL.
        stm.executeUpdate();
    }
    
    public ArrayList<Conta> listarConta() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        ArrayList<Conta> contas = new ArrayList<Conta>();
        Conta c;
        Cliente cl;
       //Construir o comando SQL
        String sql = "SELECT * FROM Conta, Cliente where Conta.Cliente_idCliente = Cliente.idCliente";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            c = new Conta();
            cl = new Cliente();
            c.setNumero(rs.getInt("numero")); 
            c.setAtiva(rs.getBoolean("ativa"));
            c.setSaldo(rs.getDouble("saldo"));
            
            cl.setNome(rs.getString("nome"));
            cl.setTelefone(rs.getString("telefone"));
            cl.setEmail(rs.getString("email"));
            c.setCliente(cl);
//            
            contas.add(c);
          
        }
        return contas;          
    }
    
    public String[] listarNumeroContas() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        String[] res = new String[this.quantidadeContas()];
        int i = 0;
        
        //construir o comando SQL
        String sql = "SELECT numero FROM Conta ORDER BY numero ASC";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            res[i] = rs.getString(1);                       
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
        String sql = "SELECT COUNT(*) FROM Conta";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
    
    public int getIdByNumero(int numero) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        
        //construir o comando SQL
        String sql = "SELECT idConta FROM Conta WHERE numero = (?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setInt(1, numero);           
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();

        rs.next();
        return rs.getInt("idConta");  
    }
    
    public double getSaldoByNumero(int numero) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        
        //construir o comando SQL
        String sql = "SELECT saldo FROM Conta WHERE numero = (?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setInt(1, numero);           
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();

        rs.next();
        return rs.getDouble("saldo");
    }
}