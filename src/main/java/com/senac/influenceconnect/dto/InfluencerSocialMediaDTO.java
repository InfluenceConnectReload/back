package com.senac.influenceconnect.dto;

public class InfluencerSocialMediaDTO {
    private Long influencerId;
    private Long socialMediaId;
    private String link;

    // Construtor
    public InfluencerSocialMediaDTO() {
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

