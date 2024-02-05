package com.cg.security.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


public class WashPackEntity {
	
	
	@Transient
    public static final String SEQUENCE_NAME="washpack_sequence";
	
	@Id
	private int id;

	@NotBlank(message = "wash pack name should not be black")
    private String washPackName;
	
	@NotBlank(message = "wash pack description should not be black")
    private String washPackDescription;
    
    @PositiveOrZero(message = "cost should not be negative")
    private int washPackCost;
    
    private int washerId;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public WashPackEntity(int id, @NotBlank(message = "wash pack name should not be black") String washPackName,
			@NotBlank(message = "wash pack description should not be black") String washPackDescription,
			@PositiveOrZero(message = "cost should not be negative") int washPackCost, int washerId) {
		super();
		this.id = id;
		this.washPackName = washPackName;
		this.washPackDescription = washPackDescription;
		this.washPackCost = washPackCost;
		this.washerId = washerId;
	}

	
    
    

}
