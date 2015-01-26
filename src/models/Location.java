package models;

public class Location {
	
	private Integer LocationId;
	private String LocationName;
	private float xaxis;
	private float yaxis;
	private float zaxis;

	public Location(Integer LocationId, String LocationName, float xaxis, float yaxis, float zaxis) {
		this.LocationId = LocationId;
		this.LocationName = LocationName;
		this.xaxis = xaxis;
		this.yaxis = yaxis;
		this.zaxis = zaxis;
	}

}
