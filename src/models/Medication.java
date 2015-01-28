package models;

public class Medication {
	private Integer MedicationId;
	private String BrandName;
	private Integer LocationId;
	
	public Medication(Integer MedicationId, String BrandName, Integer LocationId){
		this.MedicationId = MedicationId;
		this.BrandName = BrandName;
		this.LocationId = LocationId;
	}

	public Integer getMedicationId() {
		return MedicationId;
	}

	public void setMedicationId(Integer medicationId) {
		MedicationId = medicationId;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public Integer getLocationId() {
		return LocationId;
	}

	public void setLocationId(Integer locationId) {
		LocationId = locationId;
	}

}

