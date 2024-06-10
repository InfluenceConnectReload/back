package com.api.InfluenceConnect.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.api.InfluenceConnect.models.Influencer;
import com.api.InfluenceConnect.models.Niche;

public class InfluencerDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthdate;
    private String profilePhoto;
    private String password;
    private String status;
    private Long stateId; // Assuming you only need the state ID in the DTO
    private Set<Long> nicheIds = new HashSet<Long>(); // Assuming you only need the niche IDs in the DTO

    public InfluencerDTO() {
    }
    
    public InfluencerDTO(Influencer inf) {
    	this.id = inf.getId();
        this.name = inf.getName();
        this.email = inf.getEmail();
        this.birthdate = inf.getBirthdate();
        this.profilePhoto = inf.getProfilePhoto();
        this.password = inf.getPassword();
        this.status = inf.getStatus();
        
        if (inf.getState() != null) {
            this.stateId = inf.getState().getId();
        }
        
        this.getNicheIds().clear();
        // Assuming you have getter method for niches in Influencer class
        for (Niche niche : inf.getNiches()) {
            this.nicheIds.add(niche.getId());
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}

