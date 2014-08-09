package edu.ifrn.poo.sistemaBancario.dao;

import edu.ifrn.poo.sistemaBancario.dominio.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BancoDao {
    public void inserir(Banco b) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();        
        
        //Construir o comando SQL
        String sql = "INSERT INTO banco" +  "(idBanco, nome, numero) VALUES" + "(?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        int id=0;
        
        //stm.setInt(1, id);
        stm.setString(1, b.getNome());
        stm.setInt(2, b.getNumero());

        //Executar e validar o comando SQL.
        stm.execute();
    }
    
//    public Integer[] listarNumBancos() throws ClassNotFoundException, SQLException {
//        //Estabelecer a conexão
//        Connection conn = ConnectionFactory.getConnection();
//        ResultSet rs;
//        Integer[] res = new Integer[this.quantidadeBancos()];
//        int i = 0;
//        
//        //Construir o comando SQL
//        String sql = "SELECT numero FROM banco ORDER BY nome ASC";
//        PreparedStatement stm = conn.prepareStatement(sql);
//        
//        //Executar e validar o comando SQL.
//        rs = stm.executeQuery();
//        
//        //Converter ResultSet em String        
//        while(rs.next()== true) {
//            res[i] = rs.getInt("numero");                       
//            i++;
//        }
//                
//        return res;
//    }
	
    public ArrayList<Banco> listarBanco() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        ArrayList<Banco> bancos = new ArrayList<Banco>();
        Banco b;
        //Construir o comando SQL
        String sql = "SELECT * FROM Banco ORDER BY numero ASC";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            b = new Banco();
            
			b.setNome(rs.getString("nome"));
            b.setNumero(rs.getInt("numero"));      
            
            bancos.add(b);
          
        }
        return bancos;          
    }
	
    private int quantidadeBancos() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade;
        
        //Construir o comando SQL
        String sql = "SELECT COUNT(*) FROM banco";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
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
        
        //Construir o comando SQL
        String sql = "SELECT nome FROM banco ORDER BY nome ASC";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            res[i] = rs.getString(1);                       
            i++;
        }
                
        return res;
    } 
}
