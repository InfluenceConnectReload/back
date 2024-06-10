package com.api.InfluenceConnect.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table(name="tb_company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;	
	private String password;
	private String cnpj;
	private String email;
	
	@Column(name = "logo_photo", columnDefinition = "TEXT")
	private String logoPhoto; //base64
	
}
