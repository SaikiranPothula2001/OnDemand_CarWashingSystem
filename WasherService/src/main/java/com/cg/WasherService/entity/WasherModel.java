package com.cg.WasherService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Document(collection = "washers")

public class WasherModel {
	
	
	@Transient
    public static final String SEQUENCE_NAME="washer_sequence";
	@Id
    private int id;
	
    @NotBlank(message = "name must not be null or empty")
    private String washerName;
    @Email(message = "not a valid email")
    private String washerEmail;
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
	@NotBlank(message = "password is required")
    @Size(min = 4, max = 10)
    private String washerPassword;


}
