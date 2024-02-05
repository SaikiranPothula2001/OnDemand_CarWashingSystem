package com.cg.AdminService.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.AdminService.model.WashPackService;
//import com.cg.WashPackService.model.WashPackEntity;

import jakarta.validation.Valid;

@FeignClient(url="http://localhost:9093/washpack",name="washPack-client")
public interface WashPackServiceClient {
	
	@GetMapping("/{id}")
	public WashPackService getWashPackById(@PathVariable("id") int id);
	
	@GetMapping()
	public List<WashPackService> getAllWashPack();
	
	@PutMapping("/edit/{id}")
	public WashPackService updateWashPack(@RequestBody @Valid WashPackService washpack ,@PathVariable int id);

}
