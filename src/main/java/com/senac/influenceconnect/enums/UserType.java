package com.senac.influenceconnect.enums;

public enum UserType {
	ADM(1, "Administrador"),
	INFLUENCER(2, "Influenciador"),
	COMPANY(3,"Empresa");
	
	private int index;
	private String type;
	
	private UserType(int index, String type) {
		this.index = index;
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public String getType() {
		return type;
	}
}
