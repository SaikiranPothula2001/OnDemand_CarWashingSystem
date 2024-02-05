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

import com.cg.security.client.WasherServiceClient;
import com.cg.security.entities.WasherModel;

@RestController
@RequestMapping(value = "/washer")
public class WasherController {
	
	@Autowired
	WasherServiceClient service;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/add")
	public WasherModel insertWasherInfo(@RequestBody  WasherModel washerInfo) {
		return service.insertWasherInfo(washerInfo);
		
	}
	
	@GetMapping()
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<WasherModel> getAllWashers(){
    	return service.getAllWashers();
    	
    }


	@PutMapping("/edit/{washerId}")
	@PreAuthorize("hasRole('ROLE_WASHER')")
    public WasherModel updateWasherInfo(@RequestBody WasherModel washerInfo,@PathVariable int washerId) {
    	return service.updateWasherInfo(washerInfo, washerId);
    }

	@DeleteMapping("/delete/{washerId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteWasherInfo(@PathVariable int washerId) {
    	service.deleteWasherInfo(washerId);
    	return "Successfully Deleted consumer";
    }

	@GetMapping("/{washerId}")
	@PreAuthorize("hasRole('ROLE_WASHER')")
    public WasherModel getById(@PathVariable("washerId") int washerId) {
    	return service.getById(washerId);
    }

}
