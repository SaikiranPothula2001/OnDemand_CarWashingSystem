package com.cg.WasherService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.WasherService.entity.WasherModel;

@Repository
public interface WasherRepository extends MongoRepository<WasherModel, Integer> {

	//Optional<WasherModel> findBy(String washerEmail);
	//public WasherModel findByEmail(String washerEmail);

}
