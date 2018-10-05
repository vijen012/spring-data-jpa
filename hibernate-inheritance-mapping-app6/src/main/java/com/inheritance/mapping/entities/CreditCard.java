package com.inheritance.mapping.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity

//@DiscriminatorValue(value = "cc")
@Table(name = "CARD")
@PrimaryKeyJoinColumn(name = "ID")
public class CreditCard extends Payment {

	@Column(name = "CARDNUMBER")
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
}
