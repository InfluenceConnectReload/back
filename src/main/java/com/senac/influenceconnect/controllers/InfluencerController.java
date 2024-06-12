package com.senac.influenceconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.dto.InfluencerDTO;
import com.senac.influenceconnect.requests.EmailAvailabilityRequest;
import com.senac.influenceconnect.services.InfluencerService;

@RestController
@RequestMapping(value = "/influencers")
public class InfluencerController {
	
	@Autowired
	private InfluencerService influencerServ;
	
	@PostMapping(value = "/register")
	public ResponseEntity<InfluencerDTO> registerInfluencer(@RequestBody InfluencerDTO iDTO) {
		
        InfluencerDTO createdInfluencerDTO = influencerServ.registerInfluencer(iDTO);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInfluencerDTO);
    }
	
	@GetMapping(value = "/is-email-available")
    public ResponseEntity<EmailAvailabilityResponse> isEmailAvailable(@RequestBody EmailAvailabilityRequest req){
		boolean isAvailable = influencerServ.isEmailAvailable(req.getEmail());
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
