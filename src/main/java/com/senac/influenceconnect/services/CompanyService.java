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
import com.senac.influenceconnect.enums.StatusType;
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
                    "https://w7.pngwing.com/pngs/591/502/png-transparent-logo-generic-drug-bank-bank-globe-service-payment.png",
                    user,nichesList, null);
			marketList.add(new CompanyMarketingChannel(c,
					markChannelRepo.getReferenceById((long)1),
					"www.facebook.com"
					));
			c.setCompanyMarketingChannel(marketList);
			c.setStatus(StatusType.ACTIVE);
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
	
	public Long countCompanies() {
		return companyRepo.count();
	}
	
	public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
		Company c = companyRepo.getReferenceById(id);
        c.setCnpj(companyDTO.getCnpj());
        c.setProfileLogo(companyDTO.getProfileLogo());
        c.getUser().setEmail(companyDTO.getEmail());
        c.getUser().setName(companyDTO.getName());
        c.getUser().setPassword(companyDTO.getPassword());
        
        Set<Niche> niches = new HashSet<Niche>();
        for( long idNiche: companyDTO.getNicheIds()) {
        	Niche niche = nicheRepo.getReferenceById(idNiche);
            niches.add(niche);
        }
        c.setNiches(niches);
        
        c.getCompanyMarketingChannel().clear();
        for(CompanyMarketingChannelDTO dto: companyDTO.getCompanyMarketingChannels()) {
            MarketingChannel markChannel = markChannelRepo.getReferenceById(dto.getMarketingChannelId());
            CompanyMarketingChannel compMarkChannel = new CompanyMarketingChannel(c, markChannel, dto.getLink());
            c.getCompanyMarketingChannel().add(compMarkChannel);
        }
        
        return new CompanyDTO(companyRepo.save(c));
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
		c.setStatus(StatusType.ACTIVE);
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
	
	public void deleteCompany(Long id) {
        companyRepo.deleteById(id);
    }
}

/*#################CLASSE COMPANYSERVICE QUE EU, RAFAEL FIZ E QUE ERA TRABALHO MEU.###############################################*/


/**
 * Service class responsible for handling business logic related to Company entities.
 * Classe de serviço responsável por lidar com a lógica de negócios relacionada a entidades de Empresa.
 */

/*

package com.senac.influenceconnect.services;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.senac.influenceconnect.dto.CompanyDTO;
import com.senac.influenceconnect.models.Company;
import com.senac.influenceconnect.repositories.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    // Constructor injection to inject dependencies
    //Construtor para injetar dependências
    public CompanyService(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    // Method to find all companies
    // Método para encontrar todas as empresas
    public List<CompanyDTO> findAll() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
    }

    // Method to find a company by ID
    // Método para encontrar uma empresa por ID
    public CompanyDTO findById(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        return company != null ? modelMapper.map(company, CompanyDTO.class) : null;
    }

    // Method to save a new company
    // Método para salvar uma nova empresa
    public CompanyDTO save(CompanyDTO companyDTO) {
        Company company = modelMapper.map(companyDTO, Company.class);
        company = companyRepository.save(company);
        return modelMapper.map(company, CompanyDTO.class);
    }

    // Method to update an existing company
    // Método para atualizar uma empresa existente
    public CompanyDTO update(Long id, CompanyDTO companyDTO) {
        Company existingCompany = companyRepository.findById(id).orElse(null);
        if (existingCompany != null) {
            modelMapper.map(companyDTO, existingCompany);
            existingCompany.setId(id);
            existingCompany = companyRepository.save(existingCompany);
            return modelMapper.map(existingCompany, CompanyDTO.class);
        }
        return null;
    }

    // Method to delete a company by ID
    // Método para excluir uma empresa por ID
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}

*/


 