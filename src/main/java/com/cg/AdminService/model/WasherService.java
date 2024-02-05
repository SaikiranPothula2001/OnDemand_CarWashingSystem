package com.cg.AdminService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class WasherService {
	
	
	private int washerId;
	
	   
    private String washerName;
   
    private String washerEmail;
   
    private String washerPassword;

	public WasherService(int washerId, String washerName, String washerEmail, String washerPassword) {
		super();
		this.washerId = washerId;
		this.washerName = washerName;
		this.washerEmail = washerEmail;
		this.washerPassword = washerPassword;
	}

	public int getWasherId() {
		return washerId;
	}

	public void setWasherId(int washerId) {
		this.washerId = washerId;
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
    
    
    


}
