package com.cg.UserService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.UserService.exception.UserException;
//import com.cg.UserService.exception.UserNotFoundException;
import com.cg.UserService.model.UserEntity;
import com.cg.UserService.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repo;

	@Autowired
	SequenceGeneratorService sequence;

	@Override
	// @EventListener(ApplicationReadyEvent.class)
	public UserEntity addUser(UserEntity user) throws UserException {
		List<UserEntity> users = repo.findAll();
		boolean b = false;
		UserEntity consumer = null;
		for (UserEntity u : users) {
			if ((u.getEmailId().equalsIgnoreCase(user.getEmailId())) || (u.getPhoneNumber() == user.getPhoneNumber())) {

				throw new UserException("User with user name " + user.getId() + " or phone number "
						+ user.getPhoneNumber() + " or email " + user.getEmailId() + " Already Exists");
			} else {
				b = true;
			}
		}
		if (b) {
			user.setId(sequence.getSequenceNumber(UserEntity.SEQUENCE_NAME));
			consumer = repo.save(user);

			// emailService.sendEmail(user.getEmailId(), "Reddy Car Wash", "thankyou for
			// register as a customer to Reddy Car Wash");

		}
		return consumer;
	}

	@Override
	public UserEntity updateUserPhoneNumberAndEmail(int id, UserEntity user) throws UserException {

		UserEntity u = repo.findById(id).orElseThrow(()->new UserException("User not found"));
		u.setAddress(user.getAddress());
		u.setEmailId(user.getEmailId());
		u.setPassword(user.getPassword());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setUserName(user.getUserName());

//		u.setId(id);

		return repo.save(u);

	}

	@Override
	public UserEntity getUserById(int id) throws UserException {

		Optional<UserEntity> userOP = repo.findById(id);
		if (userOP.isPresent()) {
			UserEntity user = userOP.get();
			return user;
		} else {
			throw new UserException("User with user Id: " + id + "  Not Found");
		}
	}

	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> user = repo.findAll();
		return user;
	}

	@Override
	public void deleteUser(int id) {
		repo.deleteById(id);

	}

	@Override
	public UserEntity addwashPackId(int id, UserEntity washPackId) throws UserException {
		Optional<UserEntity> user = repo.findById(id);
		if (user.isPresent()) {
			UserEntity use = user.get();
			use.setWashPackId(washPackId.getWashPackId());
			repo.save(use);
			return use;
		} else {
			throw new UserException("User not Found");
		}
	}

	public UserEntity findByEmail(String emailId) throws UserException {
//		UserEntity use = n
//		return null;
//	}
		List<UserEntity> user = repo.findAll();
		UserEntity us = null;
		for (UserEntity u : user) {
			if (u.getEmailId().equalsIgnoreCase(emailId)) {
				us = u;

			}

		}
		return us;

	}

}
