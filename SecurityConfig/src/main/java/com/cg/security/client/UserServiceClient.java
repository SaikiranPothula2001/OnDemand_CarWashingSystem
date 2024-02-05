package com.cg.security.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.security.entities.UserEntity;




@FeignClient(url="http://localhost:9091/user",name="user-client")
public interface UserServiceClient   {

	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable int id);
	
	@GetMapping()
	public List<UserEntity> getAllUsers();
	
	@PutMapping("/edit/{id}")
	public UserEntity updateUserPhoneNumberAndEmail(@PathVariable int id,@RequestBody UserEntity user);
	
	@GetMapping("/getemail/{emailId}")
	public UserEntity findByEmail(@PathVariable("emailId") String emailId);
	
	@PutMapping("/addack/{id}")
	public UserEntity addwashPackId(@PathVariable int id, @RequestBody UserEntity washPackId);
	
	@PostMapping("/add")
	
	public UserEntity addUser(@RequestBody  UserEntity user);
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id);
}
