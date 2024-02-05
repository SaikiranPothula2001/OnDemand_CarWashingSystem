package com.cg.UserService.service;

import java.util.List;

import com.cg.UserService.exception.UserException;
import com.cg.UserService.model.UserEntity;

public interface UserService {
	public UserEntity addUser(UserEntity user) throws UserException;
	public UserEntity updateUserPhoneNumberAndEmail(int id,UserEntity user) throws UserException;
	public UserEntity getUserById(int id) throws UserException;
	public List<UserEntity> getAllUsers();
	public void deleteUser(int id);
	public UserEntity addwashPackId(int id,UserEntity washPackId) throws UserException;
	public UserEntity findByEmail(String emailId) throws UserException;

}
