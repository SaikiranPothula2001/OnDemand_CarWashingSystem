package com.cg.security.entities;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;



public class UserEntity {
	@Transient
    public static final String SEQUENCE_NAME="user_sequence";
	
	@Id
	private int id;
	
	@NotBlank(message = "name must not be null or empty")
    @Pattern(regexp = "^[a-zA-Z]*$")
	private String userName;
	

	@Pattern(regexp = "[6-9]{1}[0-9]{9}",message="provide a valid mobile number")
	private String phoneNumber;
	
	@Email(message = "not a valid email")
	private String emailId;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",message="provide a valid password")
	private String password;
	
	@NotBlank(message = "address is required")
	private String address;
	
	private int washPackId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getWashPackId() {
		return washPackId;
	}

	public void setWashPackId(int washPackId) {
		this.washPackId = washPackId;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public UserEntity(int id,
			@NotBlank(message = "name must not be null or empty") @Pattern(regexp = "^[a-zA-Z]*$") String userName,
			@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "provide a valid mobile number") String phoneNumber,
			@Email(message = "not a valid email") String emailId,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "provide a valid password") String password,
			@NotBlank(message = "address is required") String address, int washPackId) {
		super();
		this.id = id;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
		this.washPackId = washPackId;
	}
	
	

}
