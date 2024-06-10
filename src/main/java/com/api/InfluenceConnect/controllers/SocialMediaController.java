package com.api.InfluenceConnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.InfluenceConnect.services.SocialMediaService;

@RestController
@RequestMapping(value="/socialmedias")
public class SocialMediaController {
	
	@Autowired
	private SocialMediaService socialMediaServ;
	
	@GetMapping(value="/setDefault")
	public ResponseEntity<Void> setDefaultSocialMedia() {
		boolean wasCreated = socialMediaServ.setDefaultSocialMedia();
        
        if(wasCreated) {
            return ResponseEntity.status(201).build();
        }
        
        return ResponseEntity.status(300).build();
	}
	
}
