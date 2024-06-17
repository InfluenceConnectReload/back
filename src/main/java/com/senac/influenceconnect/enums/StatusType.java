package com.senac.influenceconnect.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusType {
	ACTIVE,
    INACTIVE,
    PENDING;
    
    @JsonValue
    public String toLowerCase() {
        return name().toLowerCase();
    }
}
