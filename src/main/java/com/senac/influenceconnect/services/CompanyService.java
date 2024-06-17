package com.senac.influenceconnect.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	public void setDefaultCompanies() {		
		for( int i =0 ;i < 10; ++i) {
			Role role = roleRepo.findById((long) 3).orElseThrow();
			String userName = "Empresa " + (i+1);
			String userEmail = "empresa"+(i+1)+"@gmail.com";
			String userPassword = "12345678Aa!";
			User user = new User(role, userName, userEmail, userPassword);
			Set<Niche> nichesList = new HashSet<>();
			nichesList.add(nicheRepo.getReferenceById((long)2));
			nichesList.add(nicheRepo.getReferenceById((long)3));
			Set<CompanyMarketingChannel> marketList = new HashSet<>();
			
			Company c = new Company(null, "38.477.102/0001-75",
                    "https://freesvg.org/img/logo-generic.png", user,
                    nichesList, null);
			marketList.add(new CompanyMarketingChannel(c,
					markChannelRepo.getReferenceById((long)1),
					"www.facebook.com"
					));
			c.setCompanyMarketingChannel(marketList);
			
			
			companyRepo.save(c);
		}
	}
	
	public List<CompanyDTO> getCompaniesPageable(int page, int pageSize) {
		PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("id"));
		List<Company> companies = companyRepo.findAll(pageRequest).getContent();
		
		List<CompanyDTO> companiesDTO = new ArrayList<CompanyDTO>();
		for(Company c: companies) {
			companiesDTO.add(new CompanyDTO(c));
		}
		
		return companiesDTO;
	}
	
	private Company transformDTO_intoEntity(CompanyDTO cDTO) {
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
