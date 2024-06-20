package com.senac.influenceconnect.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.senac.influenceconnect.enums.StatusType;
import com.senac.influenceconnect.models.Campaign;
import com.senac.influenceconnect.models.Influencer;
import com.senac.influenceconnect.models.InfluencerSocialMedia;
import com.senac.influenceconnect.models.Niche;

public class InfluencerDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    private String name;
    private LocalDate birthdate;
    @JsonProperty(access = Access.READ_ONLY)
    private String status;
    private String cpf;
    private String profilePhoto;
    private Long stateId;
    private Set<Long> nicheIds;
    private Set<InfluencerSocialMediaDTO> influencerSocialMedia;
    private Set<CampaignDTO> influencerCampaigns;
    
    public InfluencerDTO() {
    }
	
	public InfluencerDTO(Influencer inf) {
		this.id = inf.getId();
		 this.email = inf.getUser().getEmail();
	        this.password = inf.getUser().getPassword();
	        this.name = inf.getUser().getName();
	        this.birthdate = inf.getBirthdate();
	        this.status = inf.getStatus().toString();
	        this.cpf = inf.getCpf();
	        this.profilePhoto = inf.getProfilePhoto();
	        this.stateId = inf.getState().getId();
	        this.nicheIds = inf.getNiches().stream()
	                            .map(Niche::getId)
	                            .collect(Collectors.toSet());
	        
	        // Inicializa a lista de influencerSocialMedia
	        this.influencerSocialMedia = new HashSet<>();
	        for (InfluencerSocialMedia media : inf.getInfluencerSocialMedia()) {
	            this.influencerSocialMedia.add(new InfluencerSocialMediaDTO(media));
	        }
	        
	        // Inicializa a lista de influencerCampaigns
	        this.influencerCampaigns = new HashSet<>();
	        for(Campaign campaign : inf.getCampaigns()) {
	        	this.influencerCampaigns.add(new CampaignDTO(campaign));
	        }
            // Preenche a lista de influencerCampaigns com os DTOs correspondentes
	    }

	public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
        this.id = id;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Set<Long> getNicheIds() {
		return nicheIds;
	}

	public void setNicheIds(Set<Long> nicheIds) {
		this.nicheIds = nicheIds;
	}

	public Set<InfluencerSocialMediaDTO> getInfluencerSocialMedia() {
		return influencerSocialMedia;
	}

	public void setInfluencerSocialMedia(Set<InfluencerSocialMediaDTO> influencerSocialMedia) {
		this.influencerSocialMedia = influencerSocialMedia;
	}

	public Set<CampaignDTO> getInfluencerCampaigns() {
		return influencerCampaigns;
	}

	public void setInfluencerCampaigns(Set<CampaignDTO> influencerCampaigns) {
		this.influencerCampaigns = influencerCampaigns;
	}
    
	
    
}

