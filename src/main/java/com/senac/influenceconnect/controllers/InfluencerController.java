package com.senac.influenceconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.dto.InfluencerDTO;
import com.senac.influenceconnect.dto.StatusTypeDTO;
import com.senac.influenceconnect.dto.UpdateInfluencerDTO;
import com.senac.influenceconnect.models.Influencer;
import com.senac.influenceconnect.services.InfluencerService;

@RestController
@RequestMapping(value = "/influencers")
public class InfluencerController {
	
	@Autowired
	private InfluencerService influencerServ;
	
	@PostMapping
	public ResponseEntity<InfluencerDTO> registerInfluencer(@RequestBody InfluencerDTO iDTO) {
		
        InfluencerDTO createdInfluencerDTO = influencerServ.registerInfluencer(iDTO);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInfluencerDTO);
    }
	
	@GetMapping
	public ResponseEntity<List<InfluencerDTO>> getAllInfluencers(){
		List<InfluencerDTO> allInfluencers = influencerServ.getAllInfluencers();
        
        return ResponseEntity.status(HttpStatus.OK).body(allInfluencers);
	}
	
	@GetMapping(value= "/count")
	public ResponseEntity<Long> countInfluencers(){
        long count = influencerServ.countInfluencers();
        
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }
	
	@GetMapping(value="/pageable")
    public ResponseEntity<List<InfluencerDTO>> getAllInfPageable(
    		@RequestParam int page, @RequestParam int pageSize  )
	{
		
		List<InfluencerDTO> allInfluencers = influencerServ.getAllInfPageable(page, pageSize);
		
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
	
	@PutMapping(value="/{id}")
	public ResponseEntity<InfluencerDTO> updateInfluencer(@PathVariable Long id,
			@RequestBody UpdateInfluencerDTO iDTO)
	{
		InfluencerDTO updatedInfluencerDTO = influencerServ.updateInfluencer(id, iDTO);
        
        if(updatedInfluencerDTO == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(updatedInfluencerDTO);
    }
	
	@PatchMapping(value="/status/{id}")
	public ResponseEntity<InfluencerDTO> patchStatusInfluencer(@PathVariable Long id,
            @RequestBody StatusTypeDTO statusDTO)
    {
		InfluencerDTO updatedInfluencerDTO = influencerServ.updateStatus(id,statusDTO.getStatusType());
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedInfluencerDTO);
    }
	
	@GetMapping("/active")
	public ResponseEntity<List<InfluencerDTO>> getAllActiveInfluencers(){
		List<InfluencerDTO> allInfluencers = influencerServ.getAllActiveInfluencers();
        
        return ResponseEntity.status(HttpStatus.OK).body(allInfluencers);
	}
	
	@GetMapping("/pageable/{term}")
	public ResponseEntity<Page<InfluencerDTO>> getPageableInfluencersByTerm
	(@PathVariable String term,@RequestParam int page, @RequestParam int pageSize )
    {
		Page<InfluencerDTO> p = influencerServ.getPageableInfluencersByTerm(term, page, pageSize);
		System.out.println("TERMO: " + term);
		
		return ResponseEntity.status(HttpStatus.OK).body(p);
    }
	
}
