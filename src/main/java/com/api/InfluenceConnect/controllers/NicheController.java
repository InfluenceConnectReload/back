package com.api.InfluenceConnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.InfluenceConnect.services.NicheService;

@RestController
@RequestMapping(value = "/niches")
public class NicheController {
	
	@Autowired
	private NicheService nicheServ;
	
	@GetMapping(value = "/setDefault")
	public ResponseEntity<String> setDefaultNiches() {
		boolean wasCreated = nicheServ.setDefaultNiches();
        
        if(wasCreated) {
            return ResponseEntity.status(201).build();
        }
        
        return ResponseEntity.status(300).build();
		
	}
}
