package com.senac.influenceconnect.models.pk;

import java.io.Serializable;

import com.senac.influenceconnect.models.Company;
import com.senac.influenceconnect.models.Influencer;
import com.senac.influenceconnect.models.MarketingChannel;
import com.senac.influenceconnect.models.SocialMedia;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CompanyMarketingChannelPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name ="company_id")
	private Company company;
	
	@ManyToOne
    @JoinColumn(name ="marketing_channel_id")
    private MarketingChannel marketingChannel;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public MarketingChannel getMarketingChannel() {
		return marketingChannel;
	}

	public void setMarketingChannel(MarketingChannel marketingChannel) {
		this.marketingChannel = marketingChannel;
	}
	
	
}
