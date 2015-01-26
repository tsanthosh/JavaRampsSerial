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

}

