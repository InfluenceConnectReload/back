package com.senac.influenceconnect.dto;

import com.senac.influenceconnect.enums.StatusType;

public class StatusTypeDTO {

	private StatusType statusType;
	
	public StatusTypeDTO() {}

	public StatusTypeDTO(StatusType statusType) {
		super();
		this.statusType = statusType;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}
}
