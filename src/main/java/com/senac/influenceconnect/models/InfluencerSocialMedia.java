package com.senac.influenceconnect.models;

import com.senac.influenceconnect.models.pk.InfluencerSocialMediaPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_influencer_social_media")
public class InfluencerSocialMedia {
	
	@EmbeddedId
	private InfluencerSocialMediaPK id = new InfluencerSocialMediaPK();
	
	private String link;
	
	public InfluencerSocialMedia() {
    }
	
	public InfluencerSocialMedia(Influencer inf, SocialMedia social, String link) {
		super();
		this.id.setInfluencer(inf);
		this.id.setSocialMedia(social);
		this.link = link;
	}

	public Influencer getInfluencer() {
		return id.getInfluencer();
	}
	
	public void setInfluencer(Influencer influencer) {
        this.id.setInfluencer(influencer);
    }
	
	public SocialMedia getSocialMedia() {
        return id.getSocialMedia();
    }
	
	public void setSocialMedia(SocialMedia socialMedia) {
		this.id.setSocialMedia(socialMedia);
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
