package com.senac.influenceconnect.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_niche")
public class Niche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy="niches")
	private Set<Influencer> influencers = new HashSet<>();
	
	@OneToMany(mappedBy="niche")
	private Set<Campaign> campaigns = new HashSet<>();
	
	public Niche() {
        
    }

	public Niche(Long id, String name, Set<Influencer> influencers) {
		super();
		this.id = id;
		this.name = name;
		this.influencers = influencers;
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

	public Set<Influencer> getInfluencers() {
		return influencers;
	}

	public void setInfluencers(Set<Influencer> influencers) {
		this.influencers = influencers;
	}
	
	
}
