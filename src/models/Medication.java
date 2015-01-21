package models;

public class Medication {
	private Integer MedicationId;
	private String BrandName;
	private String GenericName;
	
	public Medication(Integer MedicationId, String BrandName, String GenericName){
		this.MedicationId = MedicationId;
		this.BrandName = BrandName;
		this.GenericName = GenericName;
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

	public String getGenericName() {
		return GenericName;
	}

	public void setGenericName(String genericName) {
		GenericName = genericName;
	}
}

