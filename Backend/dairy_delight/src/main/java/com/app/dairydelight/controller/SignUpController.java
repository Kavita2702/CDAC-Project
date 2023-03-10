package com.app.dairydelight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dairydelight.controller.RequestPojo.ApiResponse;
import com.app.dairydelight.model.User;
import com.app.dairydelight.service.UserServices.UserService;

@RestController
@RequestMapping("api/signup")
public class SignUpController {
	@Autowired
	  UserService userservice;
	@PostMapping("user")
	public ResponseEntity<?> userLogin(@RequestBody User signupRequest) {
		try {
			//TODO validation has to add for client request
			User user = userservice.signUpUser(signupRequest);
			return  ResponseEntity.ok(user);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}
