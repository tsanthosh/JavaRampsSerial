package models;

public class Schedule {
	
	private Integer ScheduleId;
	private String Type;

	public Schedule (Integer ScheduleId, String Type){
		this.ScheduleId = ScheduleId;
		this.Type = Type;
	}

	public Integer getScheduleId() {
		return ScheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		ScheduleId = scheduleId;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
}
