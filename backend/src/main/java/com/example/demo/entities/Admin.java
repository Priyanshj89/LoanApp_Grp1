package com.example.demo.entities;

import jakarta.persistence.Column;
import javax.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column(name="admin_id")
	private String admin_id;
	
	@Column(name="name")
	@Size(min=1, message="required")
	private String name;
	
	@Column(name="password")
	@Size(min=1, message="required")
	private String password;
	
	public Admin() {
		super();
	}
	
	public Admin(String admin_id, String name, String password) {
		super();
		this.admin_id = admin_id;
		this.name = name;
		this.password = password;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
