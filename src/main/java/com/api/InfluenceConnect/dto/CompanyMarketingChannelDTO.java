package com.api.InfluenceConnect.dto;

public class CompanyMarketingChannelDTO {
	private Long companyId;
	private Long marketingChannelId;
	private String link;
	
	public CompanyMarketingChannelDTO() {
		
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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
