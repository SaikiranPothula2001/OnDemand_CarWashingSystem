package com.cg.AdminService.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.AdminService.model.UserService;




@FeignClient(url="http://localhost:9091/user",name="user-client")
public interface UserServiceClient   {

	@GetMapping("/{id}")
	public UserService getUserById(@PathVariable int id);
	
	@GetMapping()
	public List<UserService> getAllUsers();
	
	@PutMapping("/edit/{id}")
	public UserService updateUserPhoneNumberAndEmail(@PathVariable int id,@RequestBody UserService user);
}
