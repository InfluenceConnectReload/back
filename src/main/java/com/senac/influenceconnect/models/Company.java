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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_companys")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cnpj;
	
	@Column(name = "profile_logo", columnDefinition = "TEXT")
	private String profileLogo; //base64
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL) //CERTIFICA DE CRIAR O USER QUANDO A COMPANY É CRIADA- DEVE DELETAR TAMBÉM
	@JoinColumn(name="user_id")
    private User user;
	
	@JsonIgnore 
	@ManyToMany
	@JoinTable(name="tb_companys_niche",
			joinColumns=@JoinColumn(name="company_id"),
			inverseJoinColumns = @JoinColumn(name="niche_id"))
	private Set<Niche> niches = new HashSet<>();
	
	@OneToMany(mappedBy = "id.company", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompanyMarketingChannel> companyMarketingChannel = new HashSet<>();

	public Company() {
        
    }

	public Company(Long id, String cnpj, String profileLogo, User user, Set<Niche> niches,
			Set<CompanyMarketingChannel> companyMarketingChannel) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.profileLogo = profileLogo;
		this.user = user;
		this.niches = niches;
		this.companyMarketingChannel = companyMarketingChannel;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
