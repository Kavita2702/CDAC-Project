package com.app.dairydelight.service.UserServices.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dairydelight.Repository.UserRepository;
import com.app.dairydelight.model.User;
import com.app.dairydelight.service.UserServices.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findByMobile(String mobile) throws Exception {
		return userRepo.findByMobile(mobile).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User getUserDetailById(long userId) throws Exception {
		
		return userRepo.findById(userId).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User signUpUser(User transUser) throws Exception {
		try {
			if(userRepo.findByMobile(transUser.getMobile()).isPresent()) {
				throw new Exception("User is already registered with Mobile No.");
			}
			User user = new User();
			user.setName(transUser.getName());
			user.setEmail(transUser.getEmail());
			user.setMobile(transUser.getMobile());
			user.setPassword(transUser.getPassword());
			user.setAddress(transUser.getAddress());
			user.setIs_email_verified(transUser.getIs_email_verified());
			user.setCreated_at(new Timestamp(System.currentTimeMillis()).toString());
			userRepo.save(user);
			return user;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}
