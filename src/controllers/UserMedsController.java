package controllers;

import java.util.List;

import views.AddUserMeds;
import views.MainFrame;
import views.Welcome;
import models.MedLocation;
import models.Medication;
import models.User;
import models.DBConnector;

public class UserMedsController {
	
	private User userObj;
	private MedLocation locationObj;
	private Medication medication;
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
	
}
