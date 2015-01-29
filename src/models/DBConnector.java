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
import java.sql.Time;

public class DBConnector {
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rst = null;
	private PreparedStatement prepStatement = null;
	private String url;
	private String user;
	private String password;
	
	public DBConnector() {
        
        this.url = "jdbc:mysql://50.22.153.228:3306/tsanthosh_dispenser";
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
	
	public void connect(){
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
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
	
	public void insertNewLocation(String LocationName, float XAxis, float YAxis, float ZAxis){

		try {
			con = DriverManager.getConnection(url, user, password);
			prepStatement = con.prepareStatement("INSERT INTO  `tsanthosh_dispenser`.`location` (`LocationId` ,`LocationName` ,`XAxis` ,`YAxis` ,`ZAxis`) VALUES (NULL,?,?,?,?)");
		    prepStatement.setString(1, LocationName);
		    prepStatement.setFloat(2, XAxis);
		    prepStatement.setFloat(3, YAxis);
		    prepStatement.setFloat(4, ZAxis);
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

	public List<MedLocation> RetrieveAllLocations() {
		List<MedLocation> locationList = new ArrayList<MedLocation>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rst = stmt.executeQuery("SELECT * FROM location");
			while (rst.next()){
				MedLocation newlocation = new MedLocation (rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getFloat(4), rst.getFloat(5));
				locationList.add(newlocation);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{ if(stmt!=null) stmt.close(); } catch (SQLException se2) {}
			try{ if(con!=null) con.close(); } catch (SQLException se) { se.printStackTrace(); }
		}
		
		return locationList;
	}
	
	public Integer insertNewMedication(String brandName, int locationId){
		
		int medicationId = 0;
		try {
			
			con = DriverManager.getConnection(url, user, password);
			prepStatement = con.prepareStatement("INSERT INTO  `tsanthosh_dispenser`.`medication` (`MedicationId` ,`BrandName` ,`LocationId`) VALUES (NULL,?,?)", Statement.RETURN_GENERATED_KEYS);
		    prepStatement.setString(1, brandName);
		    prepStatement.setFloat(2, locationId);
		    prepStatement.executeUpdate();
		    rst = prepStatement.getGeneratedKeys();
			if (rst.next()){
			    medicationId = rst.getInt(1);
			}
		    prepStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{ if(prepStatement!=null) prepStatement.close(); } catch (SQLException se2) {}
			try{ if(con!=null) con.close(); } catch (SQLException se) { se.printStackTrace(); }
		}
		
		return medicationId;
	}

	public void insertNewMedSchedule(Integer userId, Integer medicationId,
			Time schedule1, Time schedule2, Time schedule3, Time schedule4,
			Time schedule5) {

		try {
			con = DriverManager.getConnection(url, user, password);
			prepStatement = con.prepareStatement("INSERT INTO  `tsanthosh_dispenser`.`medschedule` (`MedScheduleId` ,`UserId` ,`MedicationId` ,`Schedule1` ,`Schedule2` ,`Schedule3` ,`Schedule4` ,`Schedule5`) VALUES (NULL,?,?,?,?,?,?,?)");
		    prepStatement.setInt(1, userId);
		    prepStatement.setInt(2, medicationId);
		    prepStatement.setTime(3, schedule1);
		    prepStatement.setTime(4, schedule2);
		    prepStatement.setTime(5, schedule3);
		    prepStatement.setTime(6, schedule4);
		    prepStatement.setTime(7, schedule5);
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

	/* public UserMedsController getMedScheduleData(int userId, UserMedsController userMedsCont) {
		this.userMedsCont = userMedsCont;
		List<MedSchedule> medScheduleList = new ArrayList<MedSchedule>();
		List<Medication> medicationList = new ArrayList<Medication>();
		Medication medication = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			prepStatement = con.prepareStatement("SELECT * FROM  `medschedule` WHERE UserId=?");
		    prepStatement.setInt(1, userId);
		    rst = prepStatement.executeQuery();
			while (rst.next()){
				MedSchedule medSchedule = new MedSchedule (rst.getInt(1), rst.getInt(2), rst.getInt(3), rst.getTime(4), rst.getTime(5), rst.getTime(6), rst.getTime(7), rst.getTime(8));
				medScheduleList.add(medSchedule);
			}
			userMedsCont.setMedScheduleList(medScheduleList);
			
			for(MedSchedule d: medScheduleList){
				prepStatement = con.prepareStatement("SELECT * FROM  `medication` WHERE medicationId=?");
			    prepStatement.setInt(1, d.getMedicationId());
			    rst = prepStatement.executeQuery();
				while (rst.next()){
					medication = new Medication (rst.getInt(1), rst.getString(2), rst.getInt(3));
				}
				medicationList.add(medication);
			}	
			userMedsCont.setMedicationList(medicationList);
			
			prepStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{ if(prepStatement!=null) prepStatement.close(); } catch (SQLException se2) {}
			try{ if(con!=null) con.close(); } catch (SQLException se) { se.printStackTrace(); }
		}
		
		return userMedsCont;
	} */
	
}