package com.senac.influenceconnect.dto;

import com.senac.influenceconnect.models.InfluencerSocialMedia;

public class InfluencerSocialMediaDTO {
    private Long influencerId;
    private Long socialMediaId;
    private String link;

    // Construtor
    public InfluencerSocialMediaDTO() {
    }
    
    

    public InfluencerSocialMediaDTO(Long influencerId, Long socialMediaId, String link) {
		super();
		this.influencerId = influencerId;
		this.socialMediaId = socialMediaId;
		this.link = link;
	}
    
    public InfluencerSocialMediaDTO(InfluencerSocialMedia infSocialMedia) {
    	this.influencerId = infSocialMedia.getInfluencer().getId();
        this.socialMediaId = infSocialMedia.getSocialMedia().getId();
        this.link = infSocialMedia.getLink();
    }



	// Getters e Setters
    public Long getInfluencerId() {
        return influencerId;
    }

    public void setInfluencerId(Long influencerId) {
        this.influencerId = influencerId;
    }

    public Long getSocialMediaId() {
        return socialMediaId;
    }

    public void setSocialMediaId(Long socialMediaId) {
        this.socialMediaId = socialMediaId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

