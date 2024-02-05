package com.cg.security.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.security.entities.WashPackEntity;

@FeignClient(url="http://localhost:9093/washpack",name="washPack-client")
public interface WashPackServiceClient {
	
	@GetMapping("/{id}")
	public WashPackEntity getWashPackById(@PathVariable("id") int id);
	
	@GetMapping()
	public List<WashPackEntity> getAllWashPack();
	
	@PutMapping("/edit/{id}")
	public WashPackEntity updateWashPack(@RequestBody  WashPackEntity washpack ,@PathVariable int id);
	
	
	@PostMapping("/add")
	public WashPackEntity addWashPack(@RequestBody  WashPackEntity washpack);
	
	@DeleteMapping("/delete/{id}")
	public String deleteWashPack(@PathVariable int id);

}