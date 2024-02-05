package com.cg.WashPackService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.WashPackService.model.WashPackEntity;

@Repository
public interface WashPackRepository extends MongoRepository<WashPackEntity, Integer> {

}
