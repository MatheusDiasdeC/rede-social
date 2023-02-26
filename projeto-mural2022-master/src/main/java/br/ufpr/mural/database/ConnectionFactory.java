package br.ufpr.mural.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public static Connection getConnection() {
        try {
            //MUITO IMPORTANJTE ESSA LINHA ABAIXO!!!!
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/heliorogerio", "root", "mat8carv"
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
    	
    	//Connection connection = getConnection();
//    	if (connection != null) {
//    		System.out.println("ok");
//    	}else {
//    		System.out.println("n~~ao ok");
//    	}
    }
}