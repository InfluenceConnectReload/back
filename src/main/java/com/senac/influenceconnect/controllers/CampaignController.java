package com.senac.influenceconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.dto.CampaignDTO;
import com.senac.influenceconnect.dto.InfluencerDTO;
import com.senac.influenceconnect.services.CampaignService;

@RestController
@RequestMapping(value="/campaigns")
public class CampaignController {

	@Autowired
	private CampaignService campaignServ;
	
	@PostMapping
	public ResponseEntity<CampaignDTO> createCampaign
	(@RequestBody CampaignDTO reqDTO) 
	{
		CampaignDTO resDTO = campaignServ.createCampaign(reqDTO);
		
		return ResponseEntity.status(201).body(resDTO);
	}
	
	@GetMapping
    public ResponseEntity<List<CampaignDTO>> getAllCampaigns(){
		List<CampaignDTO> allCampaigns = campaignServ.getAllCampaigns();
		
		return ResponseEntity.status(200).body(allCampaigns);
	}
	
	@GetMapping(value="/pageable")
	public ResponseEntity<List<CampaignDTO>> getPageableCampaigns
	(@RequestParam int page, @RequestParam int pageSize)
	{
		List<CampaignDTO> allCampaigns = campaignServ.getPageableCampaigns(page, pageSize);
        
        return ResponseEntity.status(200).body(allCampaigns);
	}
	
	@PatchMapping(value="/addInfluencer")
	public ResponseEntity<CampaignDTO> addInfluencerToCampaign
	(@RequestParam long idCampaign, @RequestParam long influencerId)
	{
		CampaignDTO resDTO = campaignServ.addInfluencerToCampaign(idCampaign, influencerId);
		return ResponseEntity.status(200).body(resDTO);
	}
}
 