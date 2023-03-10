package com.app.dairydelight.service.UserServices;

import org.springframework.stereotype.Service;

import com.app.dairydelight.model.User;

@Service
public interface UserService {
	User findByMobile(String mobile) throws Exception;
	User getUserDetailById(long userId) throws Exception;
	User signUpUser(User transUser) throws Exception;
	
}
