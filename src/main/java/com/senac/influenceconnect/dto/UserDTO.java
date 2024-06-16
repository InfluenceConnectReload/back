package com.senac.influenceconnect.dto;

import com.senac.influenceconnect.models.User;

public class UserDTO {
	private Long id;
    private Long roleId;
    private String name;
    private String email;
    private String password;
    
    public UserDTO() {
    }

	public UserDTO(Long id, Long roleId, String name, String email, String password) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public UserDTO(User u) {
		this.id = u.getId();
        this.roleId = u.getRole().getId();
        this.name = u.getName();
        this.email = u.getEmail();
        this.password = u.getPassword();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
    
    
	
}
