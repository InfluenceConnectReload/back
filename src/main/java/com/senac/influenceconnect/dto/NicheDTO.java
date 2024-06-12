package com.senac.influenceconnect.dto;

import java.util.Set;

public class NicheDTO {

    private Long id;
    private String name;
    private Set<Long> influencerIds; // Assuming you only need the influencer IDs in the DTO

    public NicheDTO() {
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

    public Set<Long> getInfluencerIds() {
        return influencerIds;
    }

    public void setInfluencerIds(Set<Long> influencerIds) {
        this.influencerIds = influencerIds;
    }
}

