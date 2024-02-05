package com.cg.WasherService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.WasherService.entity.WasherModel;
import com.cg.WasherService.exception.WasherException;
import com.cg.WasherService.service.WasherServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/washer")
@CrossOrigin("*")
public class WasherController {
	
	@Autowired
	WasherServiceImpl service;
	
	@Validated
	@PostMapping("/add")
	public WasherModel insertWasherInfo(@RequestBody @Valid WasherModel washerInfo) throws WasherException{
		return service.insertWasherInfo(washerInfo);
		
	}
	
	@GetMapping()
    public List<WasherModel> getAllWashers(){
    	return service.getAllWashers();
    	
    }


	@PutMapping("/edit/{washerId}")
    public WasherModel updateWasherInfo(@RequestBody WasherModel washerInfo,@PathVariable int washerId) throws WasherException{
    	return service.updateWasherInfo(washerInfo, washerId);
    }

	@DeleteMapping("/delete/{washerId}")
    public String deleteWasherInfo(@PathVariable int washerId) {
    	service.deleteWasherInfo(washerId);
    	return "Successfully Deleted consumer";
    }

	@GetMapping("/{washerId}")
    public WasherModel getById(@PathVariable("washerId") int washerId) throws WasherException{
    	return service.getById(washerId);
    }

}
