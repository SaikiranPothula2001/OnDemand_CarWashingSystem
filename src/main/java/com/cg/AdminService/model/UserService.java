package com.cg.AdminService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserService {
	
private int id;
	
	
	private String userName;
	private String phoneNumber;
	
 
	private String emailId;
	
	
	private String password;
	
	
	private String address;
	
	
	private int washPackId;


	public UserService(int id, String userName, String phoneNumber, String emailId, String password, String address,
			int washPackId) {
		super();
		this.id = id;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
		this.washPackId = washPackId;
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
	
	

}

