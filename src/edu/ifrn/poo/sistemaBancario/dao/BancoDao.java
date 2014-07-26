package edu.ifrn.poo.sistemaBancario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BancoDao {
    public void inserir(String nome, int numero) throws ClassNotFoundException, SQLException {
         //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        
        //construir o comando SQL
        String sql = "INSERT INTO banco" +  "(idBanco, nome, numero) VALUES" + "(?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        int id=0;
        stm.setInt(1, id);
        stm.setString(2, nome);
        stm.setInt(3, numero);

        //executar e validar o comando SQL.
        stm.execute();
    }
    
    public Integer[] listarNumBancos() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        Integer[] res = new Integer[this.quantidadeBancos()];
        int i = 0;
        
        //construir o comando SQL
        String sql = "SELECT numero FROM banco ORDER BY nome ASC";
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
    private int quantidadeBancos() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade;
        
        //construir o comando SQL
        String sql = "SELECT COUNT(*) FROM banco";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
    
    public String[] listarNomeBancos() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        String[] res = new String[this.quantidadeBancos()];
        int i = 0;
        
        //construir o comando SQL
        String sql = "SELECT nome FROM banco ORDER BY nome ASC";
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
