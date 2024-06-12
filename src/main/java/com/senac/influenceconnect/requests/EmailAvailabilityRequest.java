package com.senac.influenceconnect.requests;

public class EmailAvailabilityRequest {
	private String email;

	public EmailAvailabilityRequest() {}
	
	public EmailAvailabilityRequest(String email) {
        super();
        this.email = email;
    }
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
