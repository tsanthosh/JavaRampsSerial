package controllers;

import java.util.List;

import views.MainFrame;
import views.Welcome;
import models.Location;
import models.Medication;
import models.User;
import models.DBConnector;

public class UserMedsController {
	
	private User userObj;
	private Location medlocation;
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
	
}
