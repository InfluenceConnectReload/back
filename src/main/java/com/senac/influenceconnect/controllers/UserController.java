package com.senac.influenceconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.requests.EmailAvailabilityRequest;
import com.senac.influenceconnect.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserService userServ;	
	
	@PostMapping(value = "/is-email-available")
    public ResponseEntity<EmailAvailabilityResponse> isEmailAvailable(@RequestBody EmailAvailabilityRequest req){
		boolean isAvailable = userServ.isEmailAvailable(req.getEmail());
		EmailAvailabilityResponse response = new EmailAvailabilityResponse();
		response.email = req.getEmail();
		response.isAvailable = isAvailable;
		response.message = (isAvailable?"O email está disponível":"Email está sendo usado");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	private class EmailAvailabilityResponse{
		public String email;
		public boolean isAvailable;
		public String message;
	}
	
}
