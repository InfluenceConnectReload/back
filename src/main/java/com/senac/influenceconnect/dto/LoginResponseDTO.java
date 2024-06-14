package com.senac.influenceconnect.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.senac.influenceconnect.models.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponseDTO {
	private User user;
	private String sucess;
	private String message;
	private String token;
	
	public LoginResponseDTO() {}
	
	public LoginResponseDTO(User user, String sucess, String message, String token) {
		super();
		this.user = user;
		this.sucess = sucess;
		this.message = message;
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSucess() {
		return sucess;
	}

	public void setSucess(String sucess) {
		this.sucess = sucess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
