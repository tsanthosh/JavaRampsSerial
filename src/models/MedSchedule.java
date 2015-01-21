package models;

public class MedSchedule {
	
	private Integer MedScheduleId;
	private Integer UserId;
	private Integer MedicationId;
	private Integer ScheduleId;
	
	public MedSchedule(Integer MedScheduleId, Integer UserId, Integer MedicationId, Integer ScheduleId){
		this.MedScheduleId = MedScheduleId;
		this.UserId = UserId;
		this.MedicationId = MedicationId;
		this.ScheduleId = ScheduleId;
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

	public Integer getScheduleId() {
		return ScheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		ScheduleId = scheduleId;
	}

}
