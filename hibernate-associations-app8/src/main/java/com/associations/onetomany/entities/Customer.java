package com.associations.onetomany.entities;

import javax.persistence.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;

	//cascade = CascadeType.ALL - tell the save Phone_Number records as well while saving the customer records
	//OneToMany - Default fetch type is Lazy Loading, It's optional to mention explicitly
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<PhoneNumber> numbers;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PhoneNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<PhoneNumber> numbers) {
		this.numbers = numbers;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}	
	
	public void addPhoneNumber(PhoneNumber number) {
		if (number != null) {
			if (numbers == null) {
				numbers = new HashSet<>();
			}
			number.setCustomer(this);
			//numbers.add(number);
			getNumbers().add(number);
		}
	}
	
	public void removePhoneNumber(PhoneNumber number) {
		if (number != null) {
			//numbers.remove(number);
			getNumbers().remove(number);
			number.setCustomer(null);
		}
	}	

}
