package com.cg.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.security.entities.WasherModel;

@Repository
public interface WasherRepository extends MongoRepository<WasherModel, Integer> {

	//Optional<WasherModel> findBy(String washerEmail);
	//public WasherModel findByEmail(String washerEmail);

}
