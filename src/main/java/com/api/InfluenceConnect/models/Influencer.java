package com.api.InfluenceConnect.models;

import java.time.LocalDate;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_influencers")
public class Influencer {

	//ESTÁ FALTANDO O CPF
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id; 
	
	private String name;
	private String email;
	private LocalDate birthdate;
	private String password;
	private String status;
	
	@Column(name = "profile_photo", columnDefinition = "TEXT")
	private String profilePhoto;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;
	
	//JsonIgnore previne uma recursividade na hora de passar o json para o FRONTEND
	@JsonIgnore 
	@ManyToMany
	@JoinTable(name="tb_influencers_niche",
			joinColumns=@JoinColumn(name="influencer_id"),
			inverseJoinColumns = @JoinColumn(name="niche_id"))
	private Set<Niche> niches = new HashSet<>();
	
	@OneToMany(mappedBy = "id.influencer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<InfluencerSocialMedia> influencerSocialMedia = new HashSet<>();

	public Influencer() {
		
	}
	
	public Influencer(Long id, String name, String email, LocalDate birthdate, String profilePhoto, String password,
			String status, State state, Set<Niche> niches, Set<InfluencerSocialMedia> influencerSocialMedia) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.profilePhoto = profilePhoto;
		this.password = password;
		this.status = status;
		this.state = state;
		this.niches = niches;
		this.influencerSocialMedia = influencerSocialMedia;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<Niche> getNiches() {
		return niches;
	}

	public void setNiches(Set<Niche> niches) {
		this.niches = niches;
	}

	public Set<InfluencerSocialMedia> getInfluencerSocialMedia() {
		return influencerSocialMedia;
	}

	public void setInfluencerSocialMedia(Set<InfluencerSocialMedia> influencerSocialMedia) {
		this.influencerSocialMedia = influencerSocialMedia;
	}
	
	
	
	
}
