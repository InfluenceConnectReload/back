package com.senac.influenceconnect.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senac.influenceconnect.dto.InfluencerDTO;
import com.senac.influenceconnect.dto.InfluencerSocialMediaDTO;
import com.senac.influenceconnect.dto.UpdateInfluencerDTO;
import com.senac.influenceconnect.enums.StatusType;
import com.senac.influenceconnect.models.Influencer;
import com.senac.influenceconnect.models.InfluencerSocialMedia;
import com.senac.influenceconnect.models.Niche;
import com.senac.influenceconnect.models.Role;
import com.senac.influenceconnect.models.SocialMedia;
import com.senac.influenceconnect.models.State;
import com.senac.influenceconnect.models.User;
import com.senac.influenceconnect.repositories.CampaignRepository;
import com.senac.influenceconnect.repositories.InfluencerRepository;
import com.senac.influenceconnect.repositories.NicheRepository;
import com.senac.influenceconnect.repositories.RoleRepository;
import com.senac.influenceconnect.repositories.SocialMediaRepository;
import com.senac.influenceconnect.repositories.StateRepository;
import com.senac.influenceconnect.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InfluencerService {
	
	@Autowired
	private InfluencerRepository influenceRepo;
	@Autowired
    private StateRepository stateRepo;
	@Autowired
    private NicheRepository nicheRepo;
	@Autowired
    private SocialMediaRepository socialMediaRepo;	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private CampaignRepository campaignRepo;
	
	public InfluencerDTO registerInfluencer(InfluencerDTO iDTO) {
		Influencer inf = new Influencer();
		copyInfluencerDTO(iDTO, inf);
		
		Influencer newInf = influenceRepo.save(inf);
		return new InfluencerDTO(newInf);
	}
	
	public List<InfluencerDTO> getAllInfluencers(){
		List<Influencer> allInfluencers = influenceRepo.findAll();
        List<InfluencerDTO> allInfluencersDTO = new ArrayList<>();
        
        for (Influencer inf : allInfluencers) {
            allInfluencersDTO.add(new InfluencerDTO(inf));
        }
        
        return allInfluencersDTO;
	}
	
	public List<InfluencerDTO> getAllInfPageable(int page, int pageSize){
		PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("id"));
		
		List<Influencer> allInfluencers = influenceRepo.findAll(pageRequest).getContent();
		List<InfluencerDTO> returnInfluencers = new ArrayList<>();
		
		for( Influencer inf: allInfluencers) {
			returnInfluencers.add(new InfluencerDTO(inf));
		}
		
		return returnInfluencers;
	}
	
	public long countInfluencers() {
		return influenceRepo.count();
	}
	
	public InfluencerDTO getInfluencerById(long id) {
		try {
	        Influencer inf = influenceRepo.getReferenceById(id);
	        InfluencerDTO infDTO = new InfluencerDTO(inf);
	        return infDTO;
	    } catch (EntityNotFoundException e) {
	        // Log the exception or handle it appropriately
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Influencer not found", e);
	    } catch (Exception e) {
	        // Log the exception or handle it appropriately
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
	    }
	}
	
	public InfluencerDTO updateInfluencer(long id, UpdateInfluencerDTO iDTO) {
		Influencer inf = influenceRepo.getReferenceById(id);
		inf.setId(id);
		inf.getUser().setEmail(iDTO.getEmail());
		inf.getUser().setName(iDTO.getName());
		inf.setBirthdate(iDTO.getBirthdate());
		inf.setProfilePhoto(iDTO.getProfilePhoto());
		inf.setCpf(iDTO.getCpf());
		State state = stateRepo.getReferenceById(iDTO.getStateId());
		inf.setState(state);
		Set<Niche> infNiches = new HashSet<Niche>();
		for (Long nicheId : iDTO.getNicheIds()) {
            Niche niche = nicheRepo.getReferenceById(nicheId);
            infNiches.add(niche);
        }
		inf.setNiches(infNiches);
		
		inf.getInfluencerSocialMedia().clear();
		System.out.println("REDES SOCIAIS");	
	    for (InfluencerSocialMediaDTO socialMediaDTO : iDTO.getInfluencerSocialMedia()) {
	        SocialMedia socialMedia = socialMediaRepo.getReferenceById(socialMediaDTO.getSocialMediaId());
	        InfluencerSocialMedia influencerSocialMedia = new InfluencerSocialMedia(inf, socialMedia, socialMediaDTO.getLink());
	        inf.getInfluencerSocialMedia().add(influencerSocialMedia);
	    }
	    
	    influenceRepo.save(inf);
	    
	    return new InfluencerDTO(inf);
	}
	
	public InfluencerDTO updateStatus(Long id, StatusType statusType) {
		Influencer inf = influenceRepo.getReferenceById(id);
		
		inf.setStatus(statusType);
		
		try {
			campaignRepo.deleteInfluencerFromCampaigns(inf.getId());
		} catch (DataAccessException e) {
			System.out.println("Error deleting influencer from Campaigns");
			System.out.println(e.getMessage());
		}
		
		
        influenceRepo.save(inf);
        
        return new InfluencerDTO(inf);
	}
	
	public void setDefaultsInfluencers() {
		for(int i =0; i < 30; ++i) {
			Role role = roleRepo.getReferenceById((long) 2);
			String userName = "Influencer " + (i+1);
			String userEmail = "influencer"+(i+1) + "@gmail.com";
			String userPassword = "12345678Aa!";
			User u = new User(role, userName, userEmail, userPassword);
			State state = stateRepo.getReferenceById( (long)(i % 28)+1);
			Set<Niche> niches = new HashSet<>();
			for(int j = 0; j < 3; ++j) {
                Niche niche = nicheRepo.getReferenceById( (long)(j+1));
                niches.add(niche);
            }
			Set<InfluencerSocialMedia> infSC = new HashSet<>();
			LocalDate birthDate = LocalDate.parse("02-26-1802", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
	        String profilePhoto = "https://avatars.githubusercontent.com/u/153961814?v=4";
			Influencer inf = new Influencer(u, birthDate,StatusType.PENDING , "446.072.237-27",
					profilePhoto,state, niches, infSC );
			for(int j = 0; j < 3; ++j) {
				SocialMedia socialMedia = socialMediaRepo.getReferenceById( (long)(j+1));
                InfluencerSocialMedia infSCa = new InfluencerSocialMedia(inf, socialMedia, "https://www.google.com");
                inf.getInfluencerSocialMedia().add(infSCa);
			}
			
			if( i % 3 == 0 ) {
				inf.setStatus(StatusType.ACTIVE);
			} if( i % 3 == 1 ) {
				inf.setStatus(StatusType.INACTIVE);
			}
			
            influenceRepo.save(inf);
		}
	}
	
	public List<InfluencerDTO> getAllActiveInfluencers(){
		List<InfluencerDTO> activeInfluencers = new ArrayList<>();
		List<Influencer> infList = influenceRepo.findAllActives();
		
		for(Influencer inf: infList) {
			activeInfluencers.add(new InfluencerDTO(inf));
		}
		
		return activeInfluencers;
	}
	
	public Page<InfluencerDTO> getPageableInfluencersByTerm(String term, int page, int pageSize ){
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<Influencer> infs =influenceRepo.findByNameContainingIgnoreCase(term, pageable); 
		return infs.map(InfluencerDTO::new); 
	}
	
	private void copyInfluencerDTO(InfluencerDTO iDTO, Influencer inf) {
		//CRIAR UM USER
		Role userRole = roleRepo.findById((long)2).orElseThrow();
		User user = new User(userRole,iDTO.getName(), iDTO.getEmail(), iDTO.getPassword());
		
		User infUser = userRepo.save(user);
		
		inf.setUser(infUser);
		
		inf.setBirthdate(iDTO.getBirthdate());
		inf.setProfilePhoto(iDTO.getProfilePhoto());
		inf.setCpf(iDTO.getCpf());
		
		//getState by id
		State infState = stateRepo.getReferenceById(iDTO.getStateId());
		inf.setState(infState);
		
		//getNiche by Id
		Set<Niche> infNiches = new HashSet<Niche>();
		for (Long nicheId : iDTO.getNicheIds()) {
            Niche niche = nicheRepo.getReferenceById(nicheId);
            infNiches.add(niche);
        }
		inf.setNiches(infNiches);
		
		// Lidar com redes sociais
	    Set<InfluencerSocialMedia> influencerSocialMedias = new HashSet<>();
	    for (InfluencerSocialMediaDTO socialMediaDTO : iDTO.getInfluencerSocialMedia()) {
	        SocialMedia socialMedia = socialMediaRepo.getReferenceById(socialMediaDTO.getSocialMediaId());
	        InfluencerSocialMedia influencerSocialMedia = new InfluencerSocialMedia(inf, socialMedia, socialMediaDTO.getLink());
	        influencerSocialMedias.add(influencerSocialMedia);
	    }
	    inf.setInfluencerSocialMedia(influencerSocialMedias);
	}
}
