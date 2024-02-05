package com.cg.AdminService.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.AdminService.model.WasherService;




@FeignClient(url="http://localhost:9092/washer",name="washer-client")
public interface WasherServiceClient   {

	@GetMapping()
    public List<WasherService> getAllWashers();
	
	@GetMapping("/{id}")
    public WasherService getById(@PathVariable int id);
	
	@PutMapping("/edit/{washerId}")
    public WasherService updateWasherInfo(@RequestBody WasherService washerInfo,@PathVariable int washerId);
}
