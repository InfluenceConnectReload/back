package com.senac.influenceconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.dto.CompanyDTO;
import com.senac.influenceconnect.services.CompanyService;

@RestController
@RequestMapping(value ="/companies")
public class CompanyController {

	@Autowired 
	private CompanyService companyServ;
	
	@PostMapping
	public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO){
		CompanyDTO responseCompanyDTO = companyServ.createCompany(companyDTO);
		
		return ResponseEntity.status(201).body(responseCompanyDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<CompanyDTO>> getAllCompanys(){
        List<CompanyDTO> allCompanys = companyServ.getAllCompanys();
        
        return ResponseEntity.status(200).body(allCompanys);
    }
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id){
		CompanyDTO companyDTO = companyServ.getCompanyById(id);
        
        if(companyDTO == null){
            return ResponseEntity.status(204).body(null);
        }
        
        return ResponseEntity.status(200).body(companyDTO);
    }
	
	@GetMapping(value="/pageable")
	public ResponseEntity<List<CompanyDTO>> getAllCompanysPageable(
            @RequestParam int page, @RequestParam int pageSize  )
    {
		List<CompanyDTO> companies = companyServ.getCompaniesPageable(page, pageSize);
		return ResponseEntity.status(HttpStatus.OK).body(companies);
    }
	
	@GetMapping(value="/count")
    public ResponseEntity<Long> countCompanies(){
		long count = companyServ.countCompanies();
		
		return ResponseEntity.status(HttpStatus.OK).body(count);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<CompanyDTO> updateCompany(
			@PathVariable Long id,
			@RequestBody CompanyDTO companyDTO)
	{
        CompanyDTO updatedCompanyDTO = companyServ.updateCompany(id, companyDTO);
        
        return ResponseEntity.status(HttpStatus.OK).body(updatedCompanyDTO);
    }
}
