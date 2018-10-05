package com.associations.onetoone.repositories;

import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Session;
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
	
	@Autowired
	private EntityManager entityManager;
	
	@Test 
	public void testSaveLicense() {
		License license = new License();
		license.setType("Car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("Rahul");
		person.setLastName("Jain");
		person.setAge(29);
		license.setPerson(person);
		
		licenseRepository.save(license);
	}
	
	@Test
	@Transactional
	public void testFindAllLicense() {
		License license = licenseRepository.findOne(400L);
		System.out.println(license);
		System.out.println(license.getPerson());
	}

	@Test
	@Transactional //it's required for Lazy fetch and L1(Session level cache) to work
	public void testLevelOneCache1() {
		//We will see select statement one time only but if we remove @Transactional then we will see select statement two times
		licenseRepository.findOne(400L); 
		licenseRepository.findOne(400L); 
	}
	
	@Test
	@Transactional //it's required for Lazy fetch and L1(Session level cache) to work
	public void testLevelOneCache2() {		
		/*
		 * Level One Cache:-
		 * We will see select statement two times only but if we comment session.evict(license1) then we will select statement 
		 * one time only
		 * 
		 * Second Level Cache:- 
		 * Once we enabled second level cache then we will see select statment again one time only because it will retrive
		 * object from second level cache because we have evicted it from first level cache manually
		 */
		Session session = entityManager.unwrap(Session.class);
		License license1 = licenseRepository.findOne(400L); 
		License license2 = licenseRepository.findOne(400L); 
		
		//It will remove cached object from cache and whenever same request will come for the resource it will query database
		session.evict(license1);
		
		License license3 = licenseRepository.findOne(400L);
	}
}
