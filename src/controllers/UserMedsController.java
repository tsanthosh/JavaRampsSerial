package controllers;

import models.MedSchedule;
import models.Medication;
import models.Schedule;
import models.User;
import models.DBConnector;

public class UserMedsController {
	
	private User userObj;
	private Schedule scheduleObj;
	private Medication medicationObj;
	private MedSchedule medscheduleObj;
	private DBConnector databaseObj;
	
	public User getUserObj() {
		return userObj;
	}
	public void setUserObj(User userObj) {
		this.userObj = userObj;
		databaseObj = new DBConnector();
		System.out.println(this.userObj.getDateOfBirth());
	}
	public Schedule getScheduleObj() {
		return scheduleObj;
	}
	public void setScheduleObj(Schedule scheduleObj) {
		this.scheduleObj = scheduleObj;
	}
	public Medication getMedicationObj() {
		return medicationObj;
	}
	public void setMedicationObj(Medication medicationObj) {
		this.medicationObj = medicationObj;
	}
	public MedSchedule getMedscheduleObj() {
		return medscheduleObj;
	}
	public void setMedscheduleObj(MedSchedule medscheduleObj) {
		this.medscheduleObj = medscheduleObj;
	}
	
}
