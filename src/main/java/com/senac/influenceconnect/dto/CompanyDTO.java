package com.senac.influenceconnect.dto;

import java.util.HashSet;
import java.util.Set;

import com.senac.influenceconnect.models.User;

public class CompanyDTO {

	private Long id;
    private User user;
    private String cnpj;
    private String profileLogo; // base64
    private Set<Long> nicheIds = new HashSet<Long>();
    private Set<CompanyMarketingChannelDTO> companyMarketingChannels;
    
    public CompanyDTO() {
    }

	public CompanyDTO(Long id, User user, String cnpj, String profileLogo, Set<Long> nicheIds,
			Set<CompanyMarketingChannelDTO> companyMarketingChannels) {
		super();
		this.id = id;
		this.user = user;
		this.cnpj = cnpj;
		this.profileLogo = profileLogo;
		this.nicheIds = nicheIds;
		this.companyMarketingChannels = companyMarketingChannels;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getProfileLogo() {
		return profileLogo;
	}

	public void setProfileLogo(String profileLogo) {
		this.profileLogo = profileLogo;
	}

	public Set<Long> getNicheIds() {
		return nicheIds;
	}

	public void setNicheIds(Set<Long> nicheIds) {
		this.nicheIds = nicheIds;
	}

	public Set<CompanyMarketingChannelDTO> getCompanyMarketingChannels() {
		return companyMarketingChannels;
	}

	public void setCompanyMarketingChannels(Set<CompanyMarketingChannelDTO> companyMarketingChannels) {
		this.companyMarketingChannels = companyMarketingChannels;
	}
    
    
    
    
}
