package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.Agencia;
import edu.ifrn.poo.sistemaBancario.dominio.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgenciaDao {
     public void inserir(Agencia a) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        
        
        //Construir o comando SQL
        String sql = "INSERT INTO Agencia (numero, nome, endereco, nomeGerente, Banco_idBanco) VALUES (?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setInt(1, a.getNumero());
        stm.setString(2, a.getNome());
        stm.setString(3, a.getEndereco());
        stm.setString(4, a.getNomeGerente());        
        stm.setInt(5, a.getIdBanco());
        //Executar e validar o comando SQL.
        stm.executeUpdate();
    }

    public ArrayList<Agencia> listarAgencia() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        ArrayList<Agencia> agencias = new ArrayList<Agencia>();
        Agencia a;
        Banco b;
        //Construir o comando SQL
//        String sql = "SELECT * FROM Agencia ORDER BY numero ASC";
        String sql = "SELECT * FROM Agencia, Banco where Agencia.Banco_idBanco = Banco.idBanco";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            a = new Agencia();
            b = new Banco();
            
            a.setNumero(rs.getInt("numero")); 
            a.setNome(rs.getString("nome"));
            a.setEndereco(rs.getString("endereco"));
            a.setNomeGerente(rs.getString("nomeGerente"));
            
            b.setNome(rs.getString("nomeBanco"));
            b.setNumero(rs.getInt("numeroBanco")); 
            a.setBanco(b);
            
            agencias.add(a);
        }
        return agencias;          
    }
	
    private int quantidadeAgencias() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade;
        
        //Construir o comando SQL
        String sql = "SELECT COUNT(*) FROM Agencia";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
    
    public String[] listarNumeroAgencias() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        String[] res = new String[this.quantidadeAgencias()];
        int i = 0;
        
        //Construir o comando SQL
        String sql = "SELECT numero FROM Agencia ORDER BY numero ASC";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next() == true) {
            res[i] = rs.getString(1);                       
            i++;
        }       
        return res;
    }    
   public int getIdByNumero(int numero) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        
        //construir o comando SQL
        String sql = "SELECT idAgencia FROM Agencia WHERE numero = (?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setInt(1, numero);           
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();

        rs.next();
        return rs.getInt("idAgencia");  
    }
}