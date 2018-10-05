package com.inheritance.mapping.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "ch")
@Table(name = "BANKCHECK")
@PrimaryKeyJoinColumn(name = "ID")
public class Check extends Payment {
	
	@Column(name = "CHECKNUMBER")
	private String checkNumber;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	
}
