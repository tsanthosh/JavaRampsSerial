package models;

import java.sql.Time;

public class MedSchedule {
	
	private Integer MedScheduleId;
	private Integer UserId;
	private Integer MedicationId;
	private Time Schedule1;
	private Time Schedule2;
	private Time Schedule3;
	private Time Schedule4;
	private Time Schedule5;
	
	
	public MedSchedule(Integer MedScheduleId, Integer UserId, Integer MedicationId, Time Schedule1, Time Schedule2, Time Schedule3, Time Schedule4, Time Schedule5){
		this.MedScheduleId = MedScheduleId;
		this.UserId = UserId;
		this.MedicationId = MedicationId;
		this.Schedule1 = Schedule1;
		this.Schedule2 = Schedule2;
		this.Schedule3 = Schedule3;
		this.Schedule4 = Schedule4;
		this.Schedule5 = Schedule5;
	}


	public Integer getMedScheduleId() {
		return MedScheduleId;
	}


	public void setMedScheduleId(Integer medScheduleId) {
		MedScheduleId = medScheduleId;
	}


	public Integer getUserId() {
		return UserId;
	}


	public void setUserId(Integer userId) {
		UserId = userId;
	}


	public Integer getMedicationId() {
		return MedicationId;
	}


	public void setMedicationId(Integer medicationId) {
		MedicationId = medicationId;
	}


	public Time getSchedule1() {
		return Schedule1;
	}


	public void setSchedule1(Time schedule1) {
		Schedule1 = schedule1;
	}


	public Time getSchedule2() {
		return Schedule2;
	}


	public void setSchedule2(Time schedule2) {
		Schedule2 = schedule2;
	}


	public Time getSchedule3() {
		return Schedule3;
	}


	public void setSchedule3(Time schedule3) {
		Schedule3 = schedule3;
	}


	public Time getSchedule4() {
		return Schedule4;
	}


	public void setSchedule4(Time schedule4) {
		Schedule4 = schedule4;
	}


	public Time getSchedule5() {
		return Schedule5;
	}


	public void setSchedule5(Time schedule5) {
		Schedule5 = schedule5;
	}

}
