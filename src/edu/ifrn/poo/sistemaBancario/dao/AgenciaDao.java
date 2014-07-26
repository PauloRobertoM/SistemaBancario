package edu.ifrn.poo.sistemaBancario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgenciaDao {
     public void inserir(int numero, String nome, String endereco, String nomeGerente) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        
        //construir o comando SQL
   
        String sql = "INSERT INTO agencia" +  "(idAgencia, numero, nome, endereco, nomeGerente) VALUES" + "(?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        int id=0;
        stm.setInt(1, id);
        stm.setInt(2, numero);
        stm.setString(3, nome);
        stm.setString(4, endereco);
        stm.setString(5, nomeGerente);        
        
        //executar e validar o comando SQL.
        stm.executeUpdate();
    }
     
     public Integer[] listarNumAgencias() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        Integer[] res = new Integer[this.quantidadeAgencias()];
        int i = 0;
        
        //construir o comando SQL
        String sql = "SELECT numero FROM agencia ORDER BY nome ASC";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            res[i] = rs.getInt("numero");                       
            i++;
        }
                
        return res;
    }
    private int quantidadeAgencias() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade;
        
        //construir o comando SQL
        String sql = "SELECT COUNT(*) FROM agencia";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
    
    public String[] listarNomeAgencias() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        String[] res = new String[this.quantidadeAgencias()];
        int i = 0;
        
        //construir o comando SQL
        String sql = "SELECT nome FROM agencia ORDER BY nome ASC";
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
}
