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

}
