package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	
	public DBConnector(){
        
        String url = "jdbc:mysql://50.22.153.228,777/tsanthosh_dispenser";
        String user = "tsant_user";
        String password = "talk2000";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
        	System.out.println("Cannot connect to database");
        }
    
	}
	
}
