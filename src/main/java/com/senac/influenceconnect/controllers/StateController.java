package com.senac.influenceconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.services.StateService;


@RestController
@RequestMapping(value="/states")
public class StateController {
	
	@Autowired
	private StateService stateServ;
	
	@GetMapping(value="/setDefault")
    public ResponseEntity<Void> setDefaultStates() {
        boolean wasCreated = stateServ.setDefaultStates();
        
        if(wasCreated) {
        	return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
