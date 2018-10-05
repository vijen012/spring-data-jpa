package com.component.mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.component.mapping.entities.Address;
import com.component.mapping.entities.Employee;
import com.component.mapping.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateComponentMappingAppTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void createEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("John");
		
		Address address = new Address();
		address.setStreet("25 Lavington Street");
		address.setCity("London");
		address.setState("London");
		address.setZipcode("SE10JN");
		address.setCountry("England");
		
		employee.setAddress(address);
		
		employeeRepository.save(employee);
	}
}
