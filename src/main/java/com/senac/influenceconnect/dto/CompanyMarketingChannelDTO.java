package com.senac.influenceconnect.dto;

import com.senac.influenceconnect.models.CompanyMarketingChannel;

public class CompanyMarketingChannelDTO {
	private Long marketingChannelId;
	private String link;
	
	public CompanyMarketingChannelDTO() {
		
	}
	
	public CompanyMarketingChannelDTO(Long companyId, Long marketingChannelId, String link) {
		super();
		this.marketingChannelId = marketingChannelId;
		this.link = link;
	}
	
	public CompanyMarketingChannelDTO(CompanyMarketingChannel c) {
		this.marketingChannelId = c.getMarketingChannel().getId();
		this.link = c.getLink();
	}
	

	public Long getMarketingChannelId() {
		return marketingChannelId;
	}

	public void setMarketingChannelId(Long marketingChannelId) {
		this.marketingChannelId = marketingChannelId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
