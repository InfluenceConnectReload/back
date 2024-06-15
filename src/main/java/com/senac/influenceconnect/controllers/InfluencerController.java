package com.senac.influenceconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.dto.InfluencerDTO;
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
	
	@GetMapping
	public ResponseEntity<List<InfluencerDTO>> getAllInfluencers(){
		List<InfluencerDTO> allInfluencers = influencerServ.getAllInfluencers();
        
        return ResponseEntity.status(HttpStatus.OK).body(allInfluencers);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<InfluencerDTO> getInfluencerById(@PathVariable Long id){
        InfluencerDTO infDTO = influencerServ.getInfluencerById(id);
        
        if(infDTO == null){
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(infDTO);
    }
	
}
