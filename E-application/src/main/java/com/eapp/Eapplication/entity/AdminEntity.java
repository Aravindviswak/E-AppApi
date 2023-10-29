package com.eapp.Eapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntity {

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long admin_id;
	
	private String admin_name;
	private String admin_email;
	private String admin_contact;
	private String admin_password;
	
}
