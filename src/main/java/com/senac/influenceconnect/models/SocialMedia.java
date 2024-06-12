package com.senac.influenceconnect.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_social_medias")
public class SocialMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String name;
	
	@OneToMany(mappedBy="id.socialMedia")
	private Set<InfluencerSocialMedia> influencerSocialMedias = new HashSet<InfluencerSocialMedia>();
	
	public SocialMedia() {
        
    }

	public SocialMedia(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<InfluencerSocialMedia> getInfluencerSocialMedias() {
		return influencerSocialMedias;
	}

	public void setInfluencerSocialMedias(Set<InfluencerSocialMedia> influencerSocialMedias) {
		this.influencerSocialMedias = influencerSocialMedias;
	}

    
}
