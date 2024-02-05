package com.cg.security.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "roles")
public class Role {

	@Id
	private String id;
	private ERole name;
	public String getId() {
		return id;
	}
	public Role(String id, ERole name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ERole getName() {
		return name;
	}
	public void setName(ERole name) {
		this.name = name;
	}

}
