package com.senac.influenceconnect.models.pk;

import java.io.Serializable;
import java.util.Objects;

import com.senac.influenceconnect.models.Company;
import com.senac.influenceconnect.models.MarketingChannel;

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

	@Override
	public int hashCode() {
		return Objects.hash(company, marketingChannel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyMarketingChannelPK other = (CompanyMarketingChannelPK) obj;
		return Objects.equals(company, other.company) && Objects.equals(marketingChannel, other.marketingChannel);
	}
}
