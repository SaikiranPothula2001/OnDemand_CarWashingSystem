package com.cg.security.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Document(collection = "washers")

public class WasherModel {
	
	
	@Transient
    public static final String SEQUENCE_NAME="washer_sequence";
	@Id
   
	private int id;
	
    @NotBlank(message = "name must not be null or empty")
    private String washerName;
    @Email(message = "not a valid email")
    private String washerEmail;
    @NotBlank(message = "password is required")
    @Size(min = 4, max = 10)
    private String washerPassword;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public String getWasherEmail() {
		return washerEmail;
	}
	public void setWasherEmail(String washerEmail) {
		this.washerEmail = washerEmail;
	}
	public String getWasherPassword() {
		return washerPassword;
	}
	public void setWasherPassword(String washerPassword) {
		this.washerPassword = washerPassword;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	public WasherModel(int id, @NotBlank(message = "name must not be null or empty") String washerName,
			@Email(message = "not a valid email") String washerEmail,
			@NotBlank(message = "password is required") @Size(min = 4, max = 10) String washerPassword) {
		super();
		this.id = id;
		this.washerName = washerName;
		this.washerEmail = washerEmail;
		this.washerPassword = washerPassword;
	}
	
    
    


}
