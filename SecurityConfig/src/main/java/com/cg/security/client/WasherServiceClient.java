package com.cg.security.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.security.entities.WasherModel;





@FeignClient(url="http://localhost:9092/washer",name="washer-client")
public interface WasherServiceClient   {

	@GetMapping()
    public List<WasherModel> getAllWashers();
	
	@GetMapping("/{id}")
    public WasherModel getById(@PathVariable int id);
	
	@PutMapping("/edit/{washerId}")
    public WasherModel updateWasherInfo(@RequestBody WasherModel washerInfo,@PathVariable int washerId);
	
	@DeleteMapping("/delete/{washerId}")
    public String deleteWasherInfo(@PathVariable int washerId);
	
	
	@PostMapping("/add")
	public WasherModel insertWasherInfo(@RequestBody  WasherModel washerInfo);
}
