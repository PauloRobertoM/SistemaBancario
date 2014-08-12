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
        String sql = "INSERT INTO agencia" +  "(idAgencia, numero, nome, endereco, nomeGerente) VALUES" + "(?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        int id=0;
        
        //stm.setInt(1, id);
        stm.setInt(1, a.getNumero());
        stm.setString(2, a.getNome());
        stm.setString(3, a.getEndereco());
        stm.setString(4, a.getNomeGerente());        
        
        //Executar e validar o comando SQL.
        stm.executeUpdate();
    }
     
//    public Integer[] listarNumAgencias() throws ClassNotFoundException, SQLException {
//        //Estabelecer a conexão
//        Connection conn = ConnectionFactory.getConnection();
//        ResultSet rs;
//        Integer[] res = new Integer[this.quantidadeAgencias()];
//        int i = 0;
//        
//        //Construir o comando SQL
//        String sql = "SELECT numero FROM agencia ORDER BY nome ASC";
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
	
    public ArrayList<Agencia> listarAgencia() throws ClassNotFoundException, SQLException {
        //Estabelecer a conexão
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs;
        ArrayList<Agencia> agencias = new ArrayList<Agencia>();
        Agencia a;
        Banco b;
        //Construir o comando SQL
//        String sql = "SELECT * FROM Agencia ORDER BY numero ASC";
        String sql = "SELECT * FROM Agencia, Conta where Agencia.Conta_idConta = Conta.idConta;";
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
            
            b.setNome(rs.getString("nome"));
            b.setNumero(rs.getInt("numero")); 
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
        String sql = "SELECT COUNT(*) FROM agencia";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        //Executar e validar o comando SQL.
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
        
        //Construir o comando SQL
        String sql = "SELECT nome FROM agencia ORDER BY nome ASC";
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