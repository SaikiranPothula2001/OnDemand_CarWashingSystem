package com.cg.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.security.client.WashPackServiceClient;
import com.cg.security.entities.WashPackEntity;

@RestController
@RequestMapping("/washpack")
public class WashPackServiceController {
	@Autowired
	WashPackServiceClient service;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/add")
	public WashPackEntity addWashPack(@RequestBody  WashPackEntity washpack) {
		return service.addWashPack(washpack);
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/edit/{id}")
	public WashPackEntity updateWashPack(@RequestBody  WashPackEntity washpack ,@PathVariable int id) {
		return service.updateWashPack(washpack, id);
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public WashPackEntity getWashPackById(@PathVariable int id) {
		return service.getWashPackById(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping()
	public List<WashPackEntity> getAllWashPack(){
		return service.getAllWashPack();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public String deleteWashPack(@PathVariable int id) {
		service.deleteWashPack(id);
		return "Deleted successfully";
	}

}
