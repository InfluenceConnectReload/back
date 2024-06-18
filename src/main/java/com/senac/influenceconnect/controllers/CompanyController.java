package com.senac.influenceconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	 @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyServ.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}


/*####################### COMPANYCONTROLLER QUE EU, RAFAEL, FIZ CONFORME ME FOI SOLICITADO#######################################*/

/**
 * Controller responsible for handling HTTP requests related to Company entities.
 * Controlador responsável por lidar com requisições HTTP relacionadas a entidades de Empresa.
 */
/*
package com.senac.influenceconnect.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.senac.influenceconnect.dto.CompanyDTO;
import com.senac.influenceconnect.services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    // Constructor injection to inject dependencies
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Method to find all companies
    // Método para encontrar todas as empresas
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findAll() {
        List<CompanyDTO> companies = companyService.findAll();
        return ResponseEntity.ok().body(companies);
    }

    // Method to find a company by ID
    // Método para encontrar uma empresa por ID
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable Long id) {
        CompanyDTO company = companyService.findById(id);
        return company != null ? ResponseEntity.ok().body(company) : ResponseEntity.notFound().build();
    }

    // Method to insert a new company
    // Método para inserir uma nova empresa
    @PostMapping
    public ResponseEntity<CompanyDTO> insert(@jakarta.validation.Valid @RequestBody CompanyDTO companyDTO) {
        CompanyDTO createdCompany = companyService.save(companyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
    }

    // Method to update an existing company
    // Método para atualizar uma empresa existente
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> update(@PathVariable Long id, @jakarta.validation.Valid @RequestBody CompanyDTO companyDTO) {
        CompanyDTO updatedCompany = companyService.update(id, companyDTO);
        return updatedCompany != null ? ResponseEntity.ok().body(updatedCompany) : ResponseEntity.notFound().build();
    }

    // Method to delete a company by ID
    // Método para excluir uma empresa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

*/

