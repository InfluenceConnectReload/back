package com.senac.influenceconnect.dto;

import com.senac.influenceconnect.models.InfluencerSocialMedia;

public class InfluencerSocialMediaDTO {
    private Long socialMediaId;
    private String link;

    // Construtor
    public InfluencerSocialMediaDTO() {
    }
    
    

    public InfluencerSocialMediaDTO(Long socialMediaId, String link) {
		super();
		this.socialMediaId = socialMediaId;
		this.link = link;
	}
    
    public InfluencerSocialMediaDTO(InfluencerSocialMedia infSocialMedia) {
        this.socialMediaId = infSocialMedia.getSocialMedia().getId();
        this.link = infSocialMedia.getLink();
    }



	// Getters e Setters

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

