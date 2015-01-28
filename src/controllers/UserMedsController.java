package controllers;

import java.sql.Time;
import java.util.List;

import views.AddUserMeds;
import views.MainFrame;
import views.UserDetails;
import views.Welcome;
import models.MedLocation;
import models.User;
import models.DBConnector;

public class UserMedsController {
	
	private User userObj;
	private MedLocation locationObj;
	private DBConnector databaseObj;
	private MainFrame mainframe;
	
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
		//Retrieve MedSchedule Objects for User
		databaseObj.getMedScheduleData(this.getUserObj().getUserId());
		//Retrieve Medication Objects for each MedSchedule Objects
		
	}
}
