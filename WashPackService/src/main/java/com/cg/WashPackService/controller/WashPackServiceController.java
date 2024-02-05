package com.cg.WashPackService.controller;

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

import com.cg.WashPackService.exception.WashPackException;
import com.cg.WashPackService.model.WashPackEntity;
import com.cg.WashPackService.service.WashPackServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/washpack")
@CrossOrigin("*")
public class WashPackServiceController {
	@Autowired
	WashPackServiceImpl service;
	
	@Validated
	@PostMapping("/add")
	public WashPackEntity addWashPack(@RequestBody @Valid WashPackEntity washpack) throws WashPackException{
		return service.addWashPack(washpack);
		
	} 
	
	@Validated
	@PutMapping("/edit/{id}")
	public WashPackEntity updateWashPack(@RequestBody @Valid WashPackEntity washpack ,@PathVariable int id) throws WashPackException{
		return service.updateWashPack(washpack, id);
		
	}
	
	@GetMapping("/getByWasherId/{id}")
	public List<WashPackEntity> getWashPackByWasherId(@PathVariable int id){
		return service.getWashPackByWasherId(id);
		
	}
	
	@GetMapping("/{id}")
	public WashPackEntity getWashPackById(@PathVariable int id) throws WashPackException{
		return service.getWashPackById(id);
	}
	
	@GetMapping()
	public List<WashPackEntity> getAllWashPack(){
		return service.getAllWashPack();
	} 
	 
	@DeleteMapping("/delete/{id}")
	public String deleteWashPack(@PathVariable int id) {
		service.deleteWashPack(id); 
		return "Deleted successfully";
	}

}
