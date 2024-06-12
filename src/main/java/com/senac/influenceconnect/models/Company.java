package com.senac.influenceconnect.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_companys")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;	
	private String password;
	private String cnpj;
	private String email;
	
	@Column(name = "profile_logo", columnDefinition = "TEXT")
	private String profileLogo; //base64
	
	@JsonIgnore 
	@ManyToMany
	@JoinTable(name="tb_companys_niche",
			joinColumns=@JoinColumn(name="company_id"),
			inverseJoinColumns = @JoinColumn(name="niche_id"))
	private Set<Niche> niches = new HashSet<>();
	
	@OneToMany(mappedBy = "id.company", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompanyMarketingChannel> companyMarketingChannel = new HashSet<>();

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

	public Set<Niche> getNiches() {
		return niches;
	}

	public void setNiches(Set<Niche> niches) {
		this.niches = niches;
	}

	public Set<CompanyMarketingChannel> getCompanyMarketingChannel() {
		return companyMarketingChannel;
	}

	public void setCompanyMarketingChannel(Set<CompanyMarketingChannel> companyMarketingChannel) {
		this.companyMarketingChannel = companyMarketingChannel;
	}
	
	
	
}
