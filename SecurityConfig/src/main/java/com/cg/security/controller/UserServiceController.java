package com.cg.security.controller;

import java.util.List;

//import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.security.client.UserServiceClient;
import com.cg.security.entities.UserEntity;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("*")

public class UserServiceController {
	@Autowired
	UserServiceClient service;
	
	@PostMapping("/add")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user) {
		
		UserEntity use = service.addUser(user);
		return new ResponseEntity<UserEntity>(use, HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ResponseEntity<UserEntity> updateUserPhoneNumberAndEmail(@PathVariable int id,@RequestBody UserEntity user) {
		UserEntity use = service.updateUserPhoneNumberAndEmail(id,user);
		return new ResponseEntity<UserEntity>(use, HttpStatus.CREATED);
		
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
		UserEntity use = service.getUserById(id);
		
		return new ResponseEntity<UserEntity>(use, HttpStatus.OK);
		
	}
	@GetMapping()
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<UserEntity>>  getAllUsers(){
		List<UserEntity> use = service.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(use, HttpStatus.OK);
	}
	
	@PutMapping("/addack/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ResponseEntity<UserEntity> addwashPackId(@PathVariable int id, @RequestBody UserEntity washPackId) {
		UserEntity use= service.addwashPackId(id, washPackId);
		return new ResponseEntity<UserEntity>(use, HttpStatus.CREATED); 
	}
	
	@GetMapping("/getemail/{emailId}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ResponseEntity<UserEntity> findByEmail(@PathVariable("emailId") String emailId)  {
		UserEntity use =service.findByEmail(emailId);
		return new ResponseEntity<UserEntity>(use, HttpStatus.OK); 
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteUser(@PathVariable int id) {
		service.deleteUser(id);
		return "deleted successfully...";
	}

}

