package com.senac.influenceconnect.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.senac.influenceconnect.enums.StatusType;
import com.senac.influenceconnect.models.Company;

public class CompanyDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
    private String cnpj;
    private String profileLogo;
    private String name;
    private String email;
	@JsonProperty(access = Access.READ_ONLY)
    private StatusType status;
    @JsonProperty(access= Access.WRITE_ONLY)
    private String password;
    private Set<Long> nicheIds;
    private Set<CompanyMarketingChannelDTO> companyMarketingChannels;
    
    public CompanyDTO() {
        
    }
    
	public CompanyDTO(Long id, String cnpj, String profileLogo, String name,StatusType status, String email, String password,
			Set<Long> nicheIds, Set<CompanyMarketingChannelDTO> companyMarketingChannels) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.profileLogo = profileLogo;
		this.status = status;
		this.name = name;
		this.email = email;
		this.password = password;
		this.nicheIds = nicheIds;
		this.companyMarketingChannels = companyMarketingChannels;
	}



	public CompanyDTO(Company comp) {
    	this.id = comp.getId();
    	this.cnpj = comp.getCnpj();
    	this.profileLogo = comp.getProfileLogo();
    	this.name = comp.getUser().getName();
    	this.email = comp.getUser().getEmail();
    	this.password = comp.getUser().getPassword();
    	this.nicheIds = comp.getNiches().stream().map(n -> n.getId()).collect(Collectors.toSet());
    	this.companyMarketingChannels = comp.getCompanyMarketingChannel().stream().map(c -> new CompanyMarketingChannelDTO(c)).collect(Collectors.toSet());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
