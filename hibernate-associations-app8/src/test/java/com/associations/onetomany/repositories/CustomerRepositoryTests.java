package com.associations.onetomany.repositories;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.associations.onetomany.entities.Customer;
import com.associations.onetomany.entities.PhoneNumber;
import com.associations.onetomany.repositories.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Rahul");
		
		//Set<PhoneNumber> numbers = new HashSet<PhoneNumber>();
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setMobile_number("9980434455");
		ph1.setType("Home");
		//ph1.setCustomer(customer); //for setting the foriegn key in phone number table
		//numbers.add(ph1);
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setMobile_number("9980434466");
		ph2.setType("Work");
		//ph2.setCustomer(customer); //for setting the foriegn key in phone number table
		//numbers.add(ph2); 
		
		customer.addPhoneNumber(ph1); //here we are adding phonenumber to set and setting customer on phone number as well
		customer.addPhoneNumber(ph2);
		//customer.setNumbers(numbers);
		customerRepository.save(customer);
	}
	
	@Test
	@Transactional //Needed when we are fetching records with Lazy Loading
	public void testLoadCustomer() {
		Customer c = customerRepository.findOne(260L);
		System.out.println(c.getName());
		
		Set<PhoneNumber> numbers = c.getNumbers();
		numbers.forEach(number -> System.out.println(number.getMobile_number()));
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer c = customerRepository.findOne(240L);
		c.setName("Mohit");
		
		Set<PhoneNumber> numbers = c.getNumbers();
		numbers.forEach(number -> number.setType("Office"));
		customerRepository.save(c);
	}
	
	@Test
	public void testDeleteCustomer() {
		//It will delete records first from child table(Phone_Number) then parent table(Customer)
		customerRepository.delete(240L);
	}

}
