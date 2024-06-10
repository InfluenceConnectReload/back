package com.api.InfluenceConnect.dto;

import java.util.HashSet;
import java.util.Set;

import com.api.InfluenceConnect.models.Company;
import com.api.InfluenceConnect.models.Niche;

public class CompanyDTO {

	private Long id;
    private String name;
    private String password;
    private String cnpj;
    private String email;
    private String profileLogo; // base64
    private Set<Long> nicheIds = new HashSet<Long>();
    private Set<CompanyMarketingChannelDTO> companyMarketingChannels;
    
    public CompanyDTO() {
    }
    
    public CompanyDTO(Company comp) {
        this.id = comp.getId();
        this.name = comp.getName();
        this.email = comp.getEmail();
        this.profileLogo = comp.getProfileLogo();
        this.password =  comp.getPassword();
        this.cnpj = comp.getCnpj();
        
        this.nicheIds.clear();
        for (Niche niche : comp.getNiches()) {
            this.nicheIds.add(niche.getId());
        }
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
