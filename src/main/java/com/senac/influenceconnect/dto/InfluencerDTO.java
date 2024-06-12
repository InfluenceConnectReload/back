package com.senac.influenceconnect.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.senac.influenceconnect.models.Influencer;
import com.senac.influenceconnect.models.InfluencerSocialMedia;
import com.senac.influenceconnect.models.Niche;

public class InfluencerDTO {
	private String email;
    private String password;
    private String name;
    private LocalDate birthdate;
    private String status;
    private String cpf;
    private String profilePhoto;
    private Long stateId;
    private Set<Long> nicheIds;
    private Set<InfluencerSocialMediaDTO> influencerSocialMedia;
    
    public InfluencerDTO() {
    }
    
	public InfluencerDTO(String email, String password, String name, LocalDate birthdate, String status, String cpf,
			String profilePhoto, Long stateId, Set<Long> nicheIds,
			Set<InfluencerSocialMediaDTO> influencerSocialMedia) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.birthdate = birthdate;
		this.status = status;
		this.cpf = cpf;
		this.profilePhoto = profilePhoto;
		this.stateId = stateId;
		this.nicheIds = nicheIds;
		this.influencerSocialMedia = influencerSocialMedia;
	}
	
	public InfluencerDTO(Influencer inf) {
		 this.email = inf.getUser().getEmail();
	        this.password = inf.getUser().getPassword();
	        this.name = inf.getUser().getName();
	        this.birthdate = inf.getBirthdate();
	        this.status = inf.getStatus();
	        this.cpf = inf.getCpf();
	        this.profilePhoto = inf.getProfilePhoto();
	        this.stateId = inf.getState().getId();
	        this.nicheIds = inf.getNiches().stream()
	                            .map(Niche::getId)
	                            .collect(Collectors.toSet());
	     // Inicializa a lista de influencerSocialMedia
	        this.influencerSocialMedia = new HashSet<>();

	        // Preenche a lista de influencerSocialMedia com os DTOs correspondentes
	        for (InfluencerSocialMedia media : inf.getInfluencerSocialMedia()) {
	            this.influencerSocialMedia.add(new InfluencerSocialMediaDTO(media));
	        }
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
    
	
    
}

