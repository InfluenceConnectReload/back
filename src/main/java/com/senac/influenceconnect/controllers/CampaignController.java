package com.senac.influenceconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.dto.CampaignDTO;
import com.senac.influenceconnect.services.CampaignService;

@RestController
@RequestMapping(value="/campaigns")
public class CampaignController {

	@Autowired
	private CampaignService campaignServ;
	
	@PostMapping
	public ResponseEntity<CampaignDTO> createCampaign(
			@RequestBody CampaignDTO reqDTO) 
	{
		CampaignDTO resDTO = campaignServ.createCampaign(reqDTO);
		
		return ResponseEntity.status(201).body(resDTO);
	}
	
	
}
 