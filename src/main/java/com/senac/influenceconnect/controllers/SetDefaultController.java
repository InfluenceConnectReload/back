package com.senac.influenceconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.models.Role;
import com.senac.influenceconnect.repositories.RoleRepository;
import com.senac.influenceconnect.services.CompanyService;
import com.senac.influenceconnect.services.MarketingChannelService;
import com.senac.influenceconnect.services.NicheService;
import com.senac.influenceconnect.services.RoleService;
import com.senac.influenceconnect.services.SocialMediaService;
import com.senac.influenceconnect.services.StateService;

//Vamos setar aqui todos os valores default do nosso projeto
//Futuramente popular as tabelas de empresas e usuários por aqui

@RestController
@RequestMapping(value = "/setDefaults")
public class SetDefaultController {

	@Autowired
    private RoleService roleServ;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private NicheService nicheServ;
	@Autowired
	private SocialMediaService socialMediaServ;
	@Autowired
	private StateService stateServ;
	@Autowired
    private MarketingChannelService marketingChannelServ;
	@Autowired
	private CompanyService companyServ;	
	
	@PostMapping
	public ResponseEntity<String> setDefault(){
		List<Role> roles = roleRepo.findAll();
		
		if(roles.isEmpty()) {
			roleServ.setDefaultRoles();
			nicheServ.setDefaultNiches();
			socialMediaServ.setDefaultSocialMedia();
			stateServ.setDefaultStates();
			marketingChannelServ.setDefaultMarketingChannels();
			
			return ResponseEntity.status(HttpStatus.CREATED).body("Tabelas populadas com sucesso!");
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Tabelas não criadas");
		
	}
	
	@PostMapping(value= "/companies")
	public ResponseEntity<String> setDefaultCompanies(){
        companyServ.setDefaultCompanies();
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Tabela de empresas populadas com sucesso!");
    }
	
}
