package com.senac.influenceconnect.models.pk;

import java.io.Serializable;
import java.util.Objects;

import com.senac.influenceconnect.models.Influencer;
import com.senac.influenceconnect.models.SocialMedia;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfluencerSocialMediaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name ="influencer_id")
	private Influencer influencer;
	
	@ManyToOne
    @JoinColumn(name ="social_media_id")
    private SocialMedia socialMedia;

	public Influencer getInfluencer() {
		return influencer;
	}

	public void setInfluencer(Influencer influencer) {
		this.influencer = influencer;
	}

	public SocialMedia getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof InfluencerSocialMediaPK)) return false;
	    InfluencerSocialMediaPK that = (InfluencerSocialMediaPK) o;
	    return Objects.equals(getInfluencer(), that.getInfluencer()) &&
	           Objects.equals(getSocialMedia(), that.getSocialMedia());
	}

	@Override
	public int hashCode() {
	    return Objects.hash(getInfluencer(), getSocialMedia());
	}
}
