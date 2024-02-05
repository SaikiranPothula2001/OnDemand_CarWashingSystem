package com.cg.UserService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.UserService.model.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity	, Integer>{
	

}
