package com.senac.influenceconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.dto.CompanyDTO;
import com.senac.influenceconnect.services.CompanyService;

@RestController
@RequestMapping(value ="/company")
public class CompanyController {

	@Autowired 
	private CompanyService companyServ;
	
	@PostMapping
	public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO){
		CompanyDTO responseCompanyDTO = companyServ.createCompany(companyDTO);
		
		return ResponseEntity.status(201).body(responseCompanyDTO);
	}
	
}
