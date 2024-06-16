package com.senac.influenceconnect.models;

import com.senac.influenceconnect.models.pk.CompanyMarketingChannelPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_company_marketing_channel")
public class CompanyMarketingChannel {

	@EmbeddedId
	private CompanyMarketingChannelPK id = new CompanyMarketingChannelPK();
	
	private String link;
	
	public CompanyMarketingChannel() {
		
	}
	
	public CompanyMarketingChannel (MarketingChannel marketingChannel,
			String link) 
	{
		super();
        this.id.setMarketingChannel(marketingChannel);
        this.link = link;
	}
	
	public CompanyMarketingChannel(Company company, MarketingChannel marketingChannel, String link) {
		super();
		this.id.setCompany(company);
		this.id.setMarketingChannel(marketingChannel);
		this.link = link;
    }
	
	public Company getCompany() {
        return id.getCompany();
    }
	
    public void setCompany(Company company) {
        this.id.setCompany(company);
    }
    
    public MarketingChannel getMarketingChannel() {
        return id.getMarketingChannel();
    }
    
    public void setMarketingChannel(MarketingChannel marketingChannel) {
        this.id.setMarketingChannel(marketingChannel);
    }
    
    public String getLink() {
        return link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
}
