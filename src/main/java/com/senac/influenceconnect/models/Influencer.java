package com.senac.influenceconnect.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_influencers")
public class Influencer {
	
	public static enum StatusType{
		active,
        inactive,
        pending
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id; 
	
	@OneToOne
	@JoinColumn(name="user_id")
    private User user;
	
	private LocalDate birthdate;
	
	@Enumerated(EnumType.STRING)
	private StatusType status = StatusType.pending;
	private String cpf;
	
	//PERGUNTAR SE É UM BOM JEITO DE GUARDAR IMAGENS
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

	public Influencer() {}

	public Influencer( User user, LocalDate birthdate, StatusType status, String cpf, String profilePhoto,
			State state, Set<Niche> niches, Set<InfluencerSocialMedia> influencerSocialMedia) {
		super();
		this.user = user;
		this.birthdate = birthdate;
		this.cpf = cpf;
		this.profilePhoto = profilePhoto;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
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
