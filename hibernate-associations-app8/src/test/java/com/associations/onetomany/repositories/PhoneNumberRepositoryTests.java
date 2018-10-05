package com.associations.onetomany.repositories;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.associations.onetomany.entities.Customer;
import com.associations.onetomany.entities.PhoneNumber;
import com.associations.onetomany.repositories.PhoneNumberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneNumberRepositoryTests {

	@Autowired
	private PhoneNumberRepository numberRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreatePhoneNumber() {
		PhoneNumber number = new PhoneNumber();
		number.setMobile_number("9980445566");
		number.setType("Office");
		
		Customer customer  = new Customer();
		customer.setName("Rahul Jain");
		customer.addPhoneNumber(number);
		
		numberRepository.save(number);
	}
	
	@Test
	@Transactional //Needed when we are fetching records with Lazy Loading
	public void testLoadPhoneNumber() {
		PhoneNumber number = numberRepository.findOne(320L);
		System.out.println(number.getMobile_number());
		System.out.println(number.getCustomer().getName());
	}
	
	@Test
	public void testDeletePhoneNumber() {
		//It will delete records first from child table(Phone_Number) then parent table(Customer)
		numberRepository.delete(320L);
	}
	
	@Test
	public void testUpdatePhoneNumber() {
		PhoneNumber number = numberRepository.findOne(320L);
		number.setType("Home");
		numberRepository.save(number);
	}

}
