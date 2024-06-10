package com.api.InfluenceConnect.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.InfluenceConnect.dto.InfluencerDTO;
import com.api.InfluenceConnect.dto.InfluencerSocialMediaDTO;
import com.api.InfluenceConnect.models.Influencer;
import com.api.InfluenceConnect.models.InfluencerSocialMedia;
import com.api.InfluenceConnect.models.Niche;
import com.api.InfluenceConnect.models.SocialMedia;
import com.api.InfluenceConnect.models.State;
import com.api.InfluenceConnect.repositories.InfluencerRepository;
import com.api.InfluenceConnect.repositories.NicheRepository;
import com.api.InfluenceConnect.repositories.SocialMediaRepository;
import com.api.InfluenceConnect.repositories.StateRepository;

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
	
	public InfluencerDTO registerInfluencer(InfluencerDTO iDTO) {
		Influencer inf = new Influencer();
		copyInfluencerDTO(iDTO, inf);
		
		Influencer newInf = influenceRepo.save(inf);
		return new InfluencerDTO(newInf);
	}
	
	private void copyInfluencerDTO(InfluencerDTO iDTO, Influencer inf) {
		inf.setName(iDTO.getName());
		inf.setEmail(iDTO.getEmail());
		inf.setBirthdate(iDTO.getBirthdate());
		inf.setPassword(iDTO.getPassword());
		inf.setStatus(iDTO.getStatus());
		inf.setProfilePhoto(iDTO.getProfilePhoto());
		
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
	    for (InfluencerSocialMediaDTO socialMediaDTO : iDTO.getSocialMediaDTOs()) {
	        SocialMedia socialMedia = socialMediaRepo.getReferenceById(socialMediaDTO.getSocialMediaId());
	        InfluencerSocialMedia influencerSocialMedia = new InfluencerSocialMedia(inf, socialMedia, socialMediaDTO.getLink());
	        influencerSocialMedias.add(influencerSocialMedia);
	    }
	    inf.setInfluencerSocialMedia(influencerSocialMedias);
	}
}
