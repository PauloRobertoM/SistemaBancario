package edu.ifrn.poo.sistemaBancario.principal;
   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SistemaBancario {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn;
	PreparedStatement preparedStatement;
	Statement stm;

	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            conn = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=root");
			
            stm = conn.createStatement();
	//     INSERT      //
        String sql = "INSERT INTO Conta" +  "(numero, ativa, saldo) VALUES" + "(?,?,?)";
        preparedStatement  = conn.prepareStatement(sql);
        
        preparedStatement.setInt(1, 123);
        preparedStatement.setBoolean(2, true);
        preparedStatement.setDouble(3, 100.0);
        
        //executar e validar o comando SQL.
        System.out.println(preparedStatement.executeUpdate());
        //////////////////////////////
        
        //     SELECT      //
//        ResultSet rs = stm.executeQuery("SELECT * FROM conta"); 
//        while(rs.next()) {  
//            int id = rs.getInt("idConta");  
//            int numero = rs.getInt("numero");  
//            boolean ativa = rs.getBoolean("ativa");
//            double saldo = rs.getDouble("saldo");
////	 As vari�veis tit, aut e totalFaixas cont�m os valores retornados   
////         pela query. Vamos imprim�-los  
//            System.out.println("ID: " + id + " NUMERO: " + numero + " ATIVA: " + ativa + "SALDO: " + saldo);
//        }       
        /////////////////////////
        
        } catch (SQLException e) {
            //System.out.println("� ERRO FOI AQUI...");
            e.getMessage();
            e.printStackTrace();
	} catch (ClassNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
	} catch (InstantiationException e) {
            e.getMessage();
            e.printStackTrace();
	} catch (IllegalAccessException e) {
            e.getMessage();
            e.printStackTrace();
	}
    }      
}