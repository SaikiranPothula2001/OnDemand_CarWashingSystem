package com.cg.AdminService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class WashPackService {
	

	private int washpackId;
	
	
    private String washPackName;
	
	
    private String washPackDescription;
    
   
    private int washPackCost;
    
    private int washerId;

	public WashPackService(int washpackId, String washPackName, String washPackDescription, int washPackCost,
			int washerId) {
		super();
		this.washpackId = washpackId;
		this.washPackName = washPackName;
		this.washPackDescription = washPackDescription;
		this.washPackCost = washPackCost;
		this.washerId = washerId;
	}

	public int getWashpackId() {
		return washpackId;
	}

	public void setWashpackId(int washpackId) {
		this.washpackId = washpackId;
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

	public int getWasherId() {
		return washerId;
	}

	public void setWasherId(int washerId) {
		this.washerId = washerId;
	}
    
    

}