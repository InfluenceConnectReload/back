package com.api.InfluenceConnect.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_marketing_channels")
public class MarketingChannel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="id.marketingChannel")
	private Set<CompanyMarketingChannel> companyMarketingChannel= new HashSet<>();
	
	public MarketingChannel() {
        
    }
	
	public MarketingChannel(Long id, String name) {
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

	public Set<CompanyMarketingChannel> getCompanyMarketingChannel() {
		return companyMarketingChannel;
	}

	public void setCompanyMarketingChannel(Set<CompanyMarketingChannel> companyMarketingChannel) {
		this.companyMarketingChannel = companyMarketingChannel;
	}
	
	
}
