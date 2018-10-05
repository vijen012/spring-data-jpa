package com.springdatajpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
