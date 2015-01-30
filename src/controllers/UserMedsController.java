package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import views.AddUserMeds;
import views.MainFrame;
import views.UserDetails;
import views.Welcome;
import models.MedLocation;
import models.MedSchedule;
import models.Medication;
import models.User;
import models.DBConnector;

public class UserMedsController {
	
	private User userObj;
	private MedLocation locationObj;
	private DBConnector databaseObj;
	private MainFrame mainframe;
	private List<MedSchedule> medScheduleList;
	private List<Medication> medicationList;
	private List<MedLocation> medLocationList;
	
	public UserMedsController(){
		databaseObj = new DBConnector();
	}
	
	public void start(){
		mainframe = new MainFrame(this);
		mainframe.setVisible(true);
	}
	
	public void setUserObjData(User userObj) {
		databaseObj.insertNewUser(userObj.getFirstName(), userObj.getLastName(), userObj.getMedicareId(), userObj.getDateOfBirth());
		mainframe.getContentPane().removeAll();
		mainframe.add(new Welcome());
		mainframe.validate();
	}
	
	public List<User> getUserObjsData(){
		List<User> userObjects = databaseObj.RetrieveAllUsers();
		return userObjects;
	}

	public User getUserObj() {
		return userObj;
	}

	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}

	public MedLocation getLocation() {
		return locationObj;
	}

	public void setLocation(MedLocation location) {
		this.locationObj = location;
	}

	public void setLocationData(MedLocation location) {
		databaseObj.insertNewLocation(location.getLocationName(), location.getXaxis(), location.getYaxis(), location.getZaxis());
		mainframe.getContentPane().removeAll();
		mainframe.add(new Welcome());
		mainframe.validate();
	}
	
	public List<MedLocation> getMedLocationList() {
		return medLocationList;
	}

	public void setMedLocationList(List<MedLocation> medLocationList) {
		this.medLocationList = medLocationList;
	}

	public void addUserMeds(){
		mainframe.getContentPane().removeAll();
		mainframe.add(new AddUserMeds(this));
		mainframe.validate();
	}

	public List<MedLocation> getLocationObjsData() {
		List<MedLocation> locationObjects = databaseObj.RetrieveAllLocations();
		return locationObjects;
	}

	public void addUserMedsData(String brandName, String locationId,
			Time schedule1, Time schedule2, Time schedule3, Time schedule4,
			Time schedule5) {
		//Update Medication & retrieve MedicationID
		int medicationId = databaseObj.insertNewMedication(brandName, Integer.parseInt(locationId));
		//Update MedSchedule
		databaseObj.insertNewMedSchedule(this.getUserObj().getUserId(), medicationId, schedule1, schedule2, schedule3, schedule4, schedule5);
		//Change Panel
		mainframe.getContentPane().removeAll();
		mainframe.add(new UserDetails(this));
		mainframe.validate();
	}
	
	public void getUserMedsData(){
		//databaseObj.getMedScheduleData(this.getUserObj().getUserId(), this);
		PreparedStatement prepStatement = null;
		medScheduleList = new ArrayList<MedSchedule>();
		medicationList = new ArrayList<Medication>();
		medLocationList = new ArrayList<MedLocation>();
		Medication medication = null;
		MedLocation medLocation = null;
		ResultSet rst = null;
		Connection con = null;
		try {
			
			databaseObj.connect();
			con = databaseObj.getCon();
			prepStatement = con.prepareStatement("SELECT * FROM  `medschedule` WHERE UserId=?");
		    prepStatement.setInt(1, this.getUserObj().getUserId());
		    rst = prepStatement.executeQuery();
			while (rst.next()){
				MedSchedule medSchedule = new MedSchedule (rst.getInt(1), rst.getInt(2), rst.getInt(3), rst.getTime(4), rst.getTime(5), rst.getTime(6), rst.getTime(7), rst.getTime(8));
				medScheduleList.add(medSchedule);
			}
			
			for(MedSchedule d: medScheduleList){
				prepStatement = con.prepareStatement("SELECT * FROM  `medication` WHERE medicationId=?");
			    prepStatement.setInt(1, d.getMedicationId());
			    rst = prepStatement.executeQuery();
				while (rst.next()){
					medication = new Medication (rst.getInt(1), rst.getString(2), rst.getInt(3));
				}
				medicationList.add(medication);
			}
			
			for (Medication med: medicationList){
				prepStatement = con.prepareStatement("SELECT * FROM  `location` WHERE locationId=?");
			    prepStatement.setInt(1, med.getLocationId());
			    rst = prepStatement.executeQuery();
				while (rst.next()){
					medLocation = new MedLocation (rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getFloat(4), rst.getFloat(5));
				}
				medLocationList.add(medLocation);
			}
			
			prepStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{ if(prepStatement!=null) prepStatement.close(); } catch (SQLException se2) {}
			try{ if(con!=null) con.close(); } catch (SQLException se) { se.printStackTrace(); }
		}
	}

	public List<MedSchedule> getMedScheduleList() {
		return medScheduleList;
	}

	public void setMedScheduleList(List<MedSchedule> medScheduleList) {
		this.medScheduleList = medScheduleList;
	}

	public List<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(List<Medication> medicationList) {
		this.medicationList = medicationList;
	}
	
	

	public void settxtReceive(String inputLine) {
		// TODO Auto-generated method stub
		
	}
}
