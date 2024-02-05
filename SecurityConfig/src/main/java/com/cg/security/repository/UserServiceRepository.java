package com.cg.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.security.entities.UserEntity;


@Repository
public interface UserServiceRepository extends MongoRepository<UserEntity	, Integer>{
	

}
