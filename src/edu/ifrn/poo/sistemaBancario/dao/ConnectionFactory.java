package edu.ifrn.poo.sistemaBancario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection conn = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(conn == null){
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=root");
        }
 
        return conn;
    }
}
