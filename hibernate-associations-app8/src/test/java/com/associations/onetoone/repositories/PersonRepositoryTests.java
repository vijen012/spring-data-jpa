package com.associations.onetoone.repositories;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.associations.onetoone.entities.License;
import com.associations.onetoone.entities.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

	@Autowired
	private PersonRepository personRepository;
	
	@Test 
	public void testSavePerson() {
		Person person = new Person();
		person.setFirstName("Mayank");
		person.setLastName("Agarwal");
		person.setAge(29);
		
		License license = new License();
		license.setType("Bike");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		license.setPerson(person);
		
		person.setLicense(license);
		
		personRepository.save(person);
	}
	
	@Test
	@Transactional
	public void testFindAllPerson() {
		Person person = personRepository.findOne(440L);
//		System.out.println(person);
//		System.out.println(person.getLicense());
	}

}
