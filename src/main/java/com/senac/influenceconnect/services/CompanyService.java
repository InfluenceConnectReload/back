package com.senac.influenceconnect.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.influenceconnect.dto.CompanyDTO;
import com.senac.influenceconnect.dto.CompanyMarketingChannelDTO;
import com.senac.influenceconnect.models.Company;
import com.senac.influenceconnect.models.CompanyMarketingChannel;
import com.senac.influenceconnect.models.MarketingChannel;
import com.senac.influenceconnect.models.Niche;
import com.senac.influenceconnect.models.Role;
import com.senac.influenceconnect.models.User;
import com.senac.influenceconnect.repositories.CompanyRepository;
import com.senac.influenceconnect.repositories.MarketingChannelRepository;
import com.senac.influenceconnect.repositories.NicheRepository;
import com.senac.influenceconnect.repositories.RoleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private NicheRepository nicheRepo;
	@Autowired
	private MarketingChannelRepository markChannelRepo;
	
	public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company newCompany = transformDTO_intoEntity(companyDTO);
        Company savedComp = companyRepo.save(newCompany);
        savedComp.getUser().setPassword(null);
        
        return new CompanyDTO(savedComp);
      }
	
	public List<CompanyDTO> getAllCompanys(){
		List<Company> companies = companyRepo.findAll();
		List<CompanyDTO> companiesDTO = new ArrayList<CompanyDTO>();
		
		for (Company c : companies) {
			CompanyDTO companyDTO = new CompanyDTO(c);
			
			companiesDTO.add(companyDTO);
        }
		
		return companiesDTO;
	}
	
	public CompanyDTO getCompanyById(Long id) {
		try {			
			Company c = companyRepo.getReferenceById(id);
			return new CompanyDTO(c);
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public Company transformDTO_intoEntity(CompanyDTO cDTO) {
		Company c = new Company();
		
		Role role = roleRepo.findById((long) 3).orElseThrow();
		User user = new User(role,
				cDTO.getName(),
				cDTO.getEmail(),
				cDTO.getPassword());

		c.setCnpj(cDTO.getCnpj());
		c.setProfileLogo(cDTO.getProfileLogo());
		c.setUser(user);
		
		Set<Niche> listNiche = new HashSet<Niche>();
		for (Long id : cDTO.getNicheIds()) {
            Niche niche = nicheRepo.getReferenceById(id);
            listNiche.add(niche);
        }
		c.setNiches( listNiche);
		
		Set<CompanyMarketingChannel> listCompMarkChannel = new HashSet<CompanyMarketingChannel>();
		for(CompanyMarketingChannelDTO dto: cDTO.getCompanyMarketingChannels()) {
			MarketingChannel markChannel = markChannelRepo.getReferenceById(dto.getMarketingChannelId());
			CompanyMarketingChannel compMarkChannel = new CompanyMarketingChannel(c, markChannel, dto.getLink());
			listCompMarkChannel.add(compMarkChannel);			
		}
		c.setCompanyMarketingChannel(listCompMarkChannel);

		
		return c;
	}
}
