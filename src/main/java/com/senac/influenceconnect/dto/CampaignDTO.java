package com.senac.influenceconnect.dto;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.senac.influenceconnect.models.Campaign;
import com.senac.influenceconnect.models.MarketingChannel;

public class CampaignDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    private int expecLikes;
    private int expecComments;
    private int expecSaves;

    private Long nicheId; //CAMPANHA É SÓ UM NICHO
    private Set<Long> marketingChannelIds;
    private Long companyId;
    private Set<Long> influencerIds;
    
    public CampaignDTO() {
        
    }

    public CampaignDTO(Campaign c) {
    	this.id = c.getId();
    	this.name = c.getName();
    	this.description = c.getDescription();
    	this.startDate = c.getStartDate();
    	this.endDate = c.getEndDate();
    	this.budget = c.getBudget();
    	this.expecLikes = c.getExpecLikes();	
    	this.expecComments = c.getExpecComments();
    	this.expecSaves = c.getExpecSaves();
    	this.nicheId = c.getNiche().getId(); //CAMPANHA É SÓ UM NICHO 	
    	this.marketingChannelIds = c.getMarketingChannels().stream().map(ce -> ce.getId()).collect(Collectors.toSet());
    	this.companyId = c.getCompany().getId();
    	this.influencerIds = c.getInfluencers().stream().map(i -> i.getId()).collect(Collectors.toSet());
    }	
    
	public CampaignDTO(Long id, String name, String description, LocalDate startDate, LocalDate endDate, double budget,
			int expecLikes, int expecComments, int expecSaves, Long nicheId, Set<Long> marketingChannelIds,
			Long companyId, Set<Long> influencerIds) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
		this.expecLikes = expecLikes;
		this.expecComments = expecComments;
		this.expecSaves = expecSaves;
		this.nicheId = nicheId;
		this.marketingChannelIds = marketingChannelIds;
		this.companyId = companyId;
		this.influencerIds = influencerIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getExpecLikes() {
		return expecLikes;
	}

	public void setExpecLikes(int expecLikes) {
		this.expecLikes = expecLikes;
	}

	public int getExpecComments() {
		return expecComments;
	}

	public void setExpecComments(int expecComments) {
		this.expecComments = expecComments;
	}

	public int getExpecSaves() {
		return expecSaves;
	}

	public void setExpecSaves(int expecSaves) {
		this.expecSaves = expecSaves;
	}

	public Long getNicheId() {
		return nicheId;
	}

	public void setNicheId(Long nicheId) {
		this.nicheId = nicheId;
	}

	public Set<Long> getMarketingChannelIds() {
		return marketingChannelIds;
	}

	public void setMarketingChannelIds(Set<Long> marketingChannelIds) {
		this.marketingChannelIds = marketingChannelIds;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Set<Long> getInfluencerIds() {
		return influencerIds;
	}

	public void setInfluencerIds(Set<Long> influencerIds) {
		this.influencerIds = influencerIds;
	}
}
