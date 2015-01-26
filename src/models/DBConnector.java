package models;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	
	private Connection con = null;
	private PreparedStatement prepStatement = null;
	private Statement stmt = null;
	private ResultSet rst = null;
	private String url;
	private String user;
	private String password;
	
	public DBConnector() {
        
        this.url = "jdbc:mysql://50.22.153.228/tsanthosh_dispenser";
        this.user = "tsant_user";
        this.password = "talk2000";
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        //String url = "jdbc:mysql://dispenser.czlkb9asmum3.ap-southeast-2.rds.amazonaws.com:3306/pill_dispenser_mvp";
        //String user = "tsanthosh";
        //String password = "TALK2000";
	}
	
	public void insertNewUser(String FirstName, String LastName, String MedicareId, Date DOB){
		
		try {
			con = DriverManager.getConnection(url, user, password);
			prepStatement = con.prepareStatement("INSERT INTO  `tsanthosh_dispenser`.`user` (`UserId` ,`FirstName` ,`LastName` ,`MedicareId` ,`DOB`) VALUES (NULL,?,?,?,?)");
		    prepStatement.setString(1, FirstName);
		    prepStatement.setString(2, LastName);
		    prepStatement.setString(3, MedicareId);
		    prepStatement.setDate(4, new java.sql.Date(DOB.getTime()));
		    prepStatement.executeUpdate();
		    prepStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{ if(prepStatement!=null) prepStatement.close(); } catch (SQLException se2) {}
			try{ if(con!=null) con.close(); } catch (SQLException se) { se.printStackTrace(); }
		}
	}
	
	public List<User> RetrieveAllUsers(){
		
		List<User> userList = new ArrayList<User>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rst = stmt.executeQuery("SELECT * FROM user");
			while (rst.next()){
				User newUser = new User (rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5));
				userList.add(newUser);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{ if(stmt!=null) stmt.close(); } catch (SQLException se2) {}
			try{ if(con!=null) con.close(); } catch (SQLException se) { se.printStackTrace(); }
		}
		
		return userList;
	}
	
	
}
