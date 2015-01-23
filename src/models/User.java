package models;

import java.util.Date;

public class User {
	private Integer UserId;
	private String FirstName;
	private String LastName;
	private String MedicareId;
	private Date DateOfBirth;
	
	public User(String FirstName, String LastName, String MedicareId, Date DateOfBirth ){
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.MedicareId = MedicareId;
		this.DateOfBirth = DateOfBirth;
	}

	public Integer getUserId() {
		return UserId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMedicareId() {
		return MedicareId;
	}

	public void setMedicareId(String medicareId) {
		MedicareId = medicareId;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	
}
