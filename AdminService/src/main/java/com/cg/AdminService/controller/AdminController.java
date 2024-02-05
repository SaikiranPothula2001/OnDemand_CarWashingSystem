package com.cg.AdminService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.AdminService.client.UserServiceClient;
import com.cg.AdminService.client.WashPackServiceClient;
import com.cg.AdminService.client.WasherServiceClient;
import com.cg.AdminService.model.UserDTO;
import com.cg.AdminService.model.UserService;
import com.cg.AdminService.model.WashPackService;
import com.cg.AdminService.model.WasherService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")

public class AdminController {
	
	@Autowired
	UserServiceClient user;
	
	@Autowired
	WasherServiceClient washer;
	
	@Autowired
	WashPackServiceClient wash;
	
	
	@GetMapping("/user/{id}")
	public UserDTO getUserById(@PathVariable int id) {
		UserDTO userInfo = null;
		try {
			UserService consumer = user.getUserById(id);
			
			WashPackService washPack = wash.getWashPackById(consumer.getWashPackId());
			WasherService washerService = washer.getById(washPack.getWasherId());
			
			 userInfo = new UserDTO(
					consumer.getId(),
					consumer.getUserName(),
					consumer.getEmailId(), 
					consumer.getPhoneNumber(),
					consumer.getPassword(),
					consumer.getAddress(),				
					washPack.getWashPackName(),
					washPack.getWashPackDescription(),
					washPack.getWashPackCost(),
					washerService.getWasherName()
					);
			return userInfo;
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"it not found");
		}
		
		
	}
	
//	@GetMapping("/")
//	public List<UserDTO> getAllUsers(){
//		List<UserDTO>list = new ArrayList<>();
//		
//		try {
//			List<UserService> consumer = user.getAllUsers();
//			List<WasherService> washSevice = washer.getAllWashers();
//			List<WashPackService> washPack = wash.getAllWashPack();
//			
//			
//			list.add((UserDTO) consumer);
//			list.add((UserDTO) washSevice);
//			list.add((UserDTO) washPack);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
//		return list;
//		
//	}
	
//	@GetMapping("/user/")
//	public List<UserService> getAllUsers(){
//		return user.getAllUsers();
//	}
//	
	

}
