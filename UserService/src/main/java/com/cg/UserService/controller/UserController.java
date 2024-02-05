package com.cg.UserService.controller;

import java.util.List;

//import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.UserService.exception.UserException;
import com.cg.UserService.model.UserEntity;
import com.cg.UserService.service.UserEmailService;
import com.cg.UserService.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user")

public class UserController {
	@Autowired
	UserServiceImpl service;
	
	
	@Autowired
	UserEmailService emailService;
	
	@Validated
	@PostMapping("/add")
	
	public ResponseEntity<UserEntity> addUser(@RequestBody @Valid UserEntity user) throws UserException{

		UserEntity use = service.addUser(user);
		emailService.sendEmail(user.getEmailId(), "Kiran Car Wash", "thankyou for register "+ user.getUserName()+ " to Kiran Car Wash");
		return new ResponseEntity<UserEntity>(use, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<UserEntity> updateUserPhoneNumberAndEmail(@PathVariable int id,@RequestBody UserEntity user) throws UserException{
		UserEntity use = service.updateUserPhoneNumberAndEmail(id,user);
		return new ResponseEntity<UserEntity>(use, HttpStatus.CREATED);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable int id) throws UserException{
		UserEntity use = service.getUserById(id);
		
		return new ResponseEntity<UserEntity>(use, HttpStatus.OK);
		
	}
	@GetMapping()
	public ResponseEntity<List<UserEntity>>  getAllUsers(){
		List<UserEntity> use = service.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(use, HttpStatus.OK);
	}
	
	@PutMapping("/addack/{id}")
	public ResponseEntity<UserEntity> addwashPackId(@PathVariable int id, @RequestBody UserEntity washPackId) throws UserException {
		UserEntity use= service.addwashPackId(id, washPackId);
		return new ResponseEntity<UserEntity>(use, HttpStatus.CREATED); 
	}
	
	@GetMapping("/getemail/{emailId}")
	public ResponseEntity<UserEntity> findByEmail(@PathVariable("emailId") String emailId) throws UserException {
		UserEntity use =service.findByEmail(emailId);
		return new ResponseEntity<UserEntity>(use, HttpStatus.OK); 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		service.deleteUser(id);
		return "deleted successfully...";
	}

}
