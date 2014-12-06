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
<<<<<<< HEAD
        String sql = "INSERT INTO banco" +  "(idBanco, nome, numero) VALUES" + "(?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        int id=0;
=======
        String sql = "INSERT INTO Banco (idBanco, nome, numero) VALUES (?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
>>>>>>> origin/master
        
        //stm.setInt(1, id);
        stm.setString(1, b.getNome());
        stm.setInt(2, b.getNumero());

        //Executar e validar o comando SQL.
        stm.execute();
    }
	
    public ArrayList<Banco> listarBanco() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
<<<<<<< HEAD
        Integer[] res = new Integer[this.quantidadeBancos()];
        int i = 0;
        
        //Construir o comando SQL
        String sql = "SELECT numero FROM banco ORDER BY nome ASC";
=======
        ArrayList<Banco> bancos = new ArrayList<Banco>();
        Banco b;
        //Construir o comando SQL
        String sql = "SELECT * FROM Banco ORDER BY numeroBanco ASC";
>>>>>>> origin/master
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            b = new Banco();
            
            b.setNome(rs.getString("nomeBanco"));
            b.setNumero(rs.getInt("numeroBanco"));      
            
            bancos.add(b);
        }
        return bancos;          
    }
<<<<<<< HEAD
    
=======
	
>>>>>>> origin/master
    private int quantidadeBancos() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;        
        int quantidade;
        
        //Construir o comando SQL
<<<<<<< HEAD
        String sql = "SELECT COUNT(*) FROM banco";
=======
        String sql = "SELECT COUNT(*) FROM Banco";
>>>>>>> origin/master
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        rs.next();        
        quantidade = rs.getInt(1);
                
        return quantidade;
    }
    
    public String[] listarBancos() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        String[] res = new String[this.quantidadeBancos()];
        int i = 0;
        
        //Construir o comando SQL
        String sql = "SELECT nomeBanco FROM Banco ORDER BY nomeBanco ASC";
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
    public int getIdByNome(String nomeBanco) throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        
        //construir o comando SQL
        String sql = "SELECT idBanco FROM Banco WHERE nomeBanco = (?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setString(1, nomeBanco);           
        
        //executar e validar o comando SQL.
        rs = stm.executeQuery();

        rs.next();
        return rs.getInt("idBanco");  
    }
    public String[] listarNomeBancos() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        String[] res = new String[this.quantidadeBancos()];
        int i = 0;
        
<<<<<<< HEAD
        //Construir o comando SQL
        String sql = "SELECT nome FROM banco ORDER BY nome ASC";
=======
        //construir o comando SQL
        String sql = "SELECT nomeBanco FROM Banco ORDER BY nomeBanco ASC";
>>>>>>> origin/master
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
        rs = stm.executeQuery();
        
        //Converter ResultSet em String        
        while(rs.next()== true) {
            res[i] = rs.getString("nomeBanco");                       
            i++;
        }         
        return res;
    }
}
