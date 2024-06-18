package com.senac.influenceconnect.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.senac.influenceconnect.dto.CampaignDTO;
import com.senac.influenceconnect.models.Campaign;
import com.senac.influenceconnect.models.Company;
import com.senac.influenceconnect.models.Influencer;
import com.senac.influenceconnect.models.MarketingChannel;
import com.senac.influenceconnect.models.Niche;
import com.senac.influenceconnect.repositories.CampaignRepository;
import com.senac.influenceconnect.repositories.CompanyRepository;
import com.senac.influenceconnect.repositories.InfluencerRepository;
import com.senac.influenceconnect.repositories.MarketingChannelRepository;
import com.senac.influenceconnect.repositories.NicheRepository;

@Service
public class CampaignService {
	@Autowired
	private CampaignRepository campaignRepo;
	@Autowired
	private NicheRepository nicheRepo;
	@Autowired
	private MarketingChannelRepository markChannelRepo;
	@Autowired 
	private CompanyRepository companyRepo;
	@Autowired
    private InfluencerRepository infRepo;
	
	public CampaignDTO createCampaign(CampaignDTO campaignDTO) {
		Campaign c = campaignRepo.save(copyIntoEntity(campaignDTO));
		return new CampaignDTO(c);
	}
	
	public List<CampaignDTO> getAllCampaigns() {
		List<Campaign> allCampaigns = campaignRepo.findAll();
        List<CampaignDTO> allCampaignsDTO = new ArrayList<>();
        
        for (Campaign c : allCampaigns) {
            allCampaignsDTO.add(new CampaignDTO(c));
        }
        
        return allCampaignsDTO;
	}
	
	public List<CampaignDTO> getPageableCampaigns(int page, int pageSize) {
		PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("id"));
		List<Campaign> listC = campaignRepo.findAll(pageRequest).getContent();
		
		List<CampaignDTO> allCampaigns = new ArrayList<>();
		for( Campaign c: listC ) {
			allCampaigns.add(new CampaignDTO(c));
		}
		
		return allCampaigns;		
	}
	
	private Campaign copyIntoEntity(CampaignDTO dto) {
		Campaign c = new Campaign();
		
		c.setName(dto.getName());
		c.setDescription(dto.getDescription());
		c.setBudget(dto.getBudget());
		c.setStartDate(dto.getStartDate());
		c.setEndDate(dto.getEndDate());
		c.setExpecLikes(dto.getExpecLikes());
		c.setExpecComments(dto.getExpecComments());
		c.setExpecSaves(dto.getExpecSaves());

		Niche campNiche = nicheRepo.getReferenceById(dto.getNicheId());
		c.setNiche(campNiche);
		Company campCompany = companyRepo.getReferenceById(dto.getCompanyId());
		c.setCompany(campCompany);
		
		Set<Influencer> listInf = new HashSet<>();
		for (Long id : dto.getInfluencerIds()) {
            Influencer inf = infRepo.getReferenceById(id);
            listInf.add(inf);
        }
		c.setInfluencers(listInf);
		
		Set<MarketingChannel> listMarketing = new HashSet<>();
		for(Long id: dto.getMarketingChannelIds()) {
			MarketingChannel mc = markChannelRepo.getReferenceById(id);
			listMarketing.add(mc);
		}
		c.setMarketingChannels(listMarketing);
		
		return c;
	}
}
