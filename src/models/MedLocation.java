package models;

public class MedLocation {
	
	private Integer LocationId;
	private String LocationName;
	private float xaxis;
	private float yaxis;
	private float zaxis;

	public MedLocation(Integer LocationId, String LocationName, float xaxis, float yaxis, float zaxis) {
		this.LocationId = LocationId;
		this.LocationName = LocationName;
		this.xaxis = xaxis;
		this.yaxis = yaxis;
		this.zaxis = zaxis;
	}

	public Integer getLocationId() {
		return LocationId;
	}

	public void setLocationId(Integer locationId) {
		LocationId = locationId;
	}

	public String getLocationName() {
		return LocationName;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

	public float getXaxis() {
		return xaxis;
	}

	public void setXaxis(float xaxis) {
		this.xaxis = xaxis;
	}

	public float getYaxis() {
		return yaxis;
	}

	public void setYaxis(float yaxis) {
		this.yaxis = yaxis;
	}

	public float getZaxis() {
		return zaxis;
	}

	public void setZaxis(float zaxis) {
		this.zaxis = zaxis;
	}
	
	

}
