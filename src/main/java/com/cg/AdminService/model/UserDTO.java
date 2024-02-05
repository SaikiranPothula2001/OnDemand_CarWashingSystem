package com.cg.AdminService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
	
	private int id;	 
	private String userName;	
	private String emailId;
	private String phoneNumber; 
	private String password;
	private String address;
	
	
	private String washPackName;	
	private String washPackDescription;	
	private int washPackCost;
	
	
	private String washerName;

	
	public UserDTO(int id, String userName, String emailId, String phoneNumber, String password, String address,
			String washPackName, String washPackDescription, int washPackCost, String washerName) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.washPackName = washPackName;
		this.washPackDescription = washPackDescription;
		this.washPackCost = washPackCost;
		this.washerName = washerName;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getWashPackName() {
		return washPackName;
	}

	public void setWashPackName(String washPackName) {
		this.washPackName = washPackName;
	}

	public String getWashPackDescription() {
		return washPackDescription;
	}

	public void setWashPackDescription(String washPackDescription) {
		this.washPackDescription = washPackDescription;
	}

	public int getWashPackCost() {
		return washPackCost;
	}

	public void setWashPackCost(int washPackCost) {
		this.washPackCost = washPackCost;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	
	
}

	

	