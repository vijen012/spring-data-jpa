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
public class LicenseRepositoryTests {

	@Autowired
	private LicenseRepository licenseRepository;
	
	@Test 
	public void testSaveLicense() {
		License license = new License();
		license.setType("Car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("Rahul");
		person.setLastName("Agarwal");
		person.setAge(29);
		license.setPerson(person);
		
		licenseRepository.save(license);
	}
	
	@Test
	@Transactional
	public void testFindAllLicense() {
		License license = licenseRepository.findOne(400L);
//		System.out.println(license);
//		System.out.println(license.getPerson());
	}

}
