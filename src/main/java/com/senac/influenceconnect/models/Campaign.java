package com.senac.influenceconnect.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.influenceconnect.enums.CampaignStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_campaigns")
public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private double budget;
	@Column(name = "logo", columnDefinition = "TEXT")
	private String logo;
	private int expecLikes;
	private int expecComments;
	private int expecSaves;
	
	@Enumerated(EnumType.STRING)
	private CampaignStatus status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "niche_id")
	private Niche niche;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(name="tb_campaigns_marketing_channels",
            joinColumns=@JoinColumn(name="campaign_id"),
            inverseJoinColumns = @JoinColumn(name="marketing_channel_id"))
	private Set<MarketingChannel> marketingChannels;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="tb_campaigns_influencers",
            joinColumns=@JoinColumn(name="campaign_id"),
            inverseJoinColumns = @JoinColumn(name="influencer_id"))
	private Set<Influencer> influencers = new HashSet<>();
	
	public Campaign() {
        
    }

	public Campaign(Long id, String name, String description, LocalDate startDate, LocalDate endDate, double budget,
			int expecLikes, int expecComments, int expecSaves, Niche niche, Set<MarketingChannel> marketingChannels,
			Company company, Set<Influencer> influencers) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
		this.expecLikes = expecLikes;
		this.expecComments = expecComments;
		this.expecSaves = expecSaves;
		this.niche = niche;
		this.marketingChannels = marketingChannels;
		this.company = company;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getExpecLikes() {
		return expecLikes;
	}

	public void setExpecLikes(int expecLikes) {
		this.expecLikes = expecLikes;
	}

	public int getExpecComments() {
		return expecComments;
	}

	public void setExpecComments(int expecComments) {
		this.expecComments = expecComments;
	}

	public int getExpecSaves() {
		return expecSaves;
	}

	public void setExpecSaves(int expecSaves) {
		this.expecSaves = expecSaves;
	}
	
	public CampaignStatus getStatus() {
		return status;
	}

	public void setStatus(CampaignStatus status) {
		this.status = status;
	}

	public Niche getNiche() {
		return niche;
	}

	public void setNiche(Niche niche) {
		this.niche = niche;
	}

	public Set<MarketingChannel> getMarketingChannels() {
		return marketingChannels;
	}

	public void setMarketingChannels(Set<MarketingChannel> marketingChannels) {
		this.marketingChannels = marketingChannels;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Influencer> getInfluencers() {
		return influencers;
	}

	public void setInfluencers(Set<Influencer> influencers) {
		this.influencers = influencers;
	}
}
