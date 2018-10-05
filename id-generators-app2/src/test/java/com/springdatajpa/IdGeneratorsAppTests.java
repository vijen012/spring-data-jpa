package com.springdatajpa;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdatajpa.entities.Employee;
import com.springdatajpa.entities.Student;
import com.springdatajpa.repository.EmployeeRepository;
import com.springdatajpa.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdGeneratorsAppTests {

	private static final double DELTA = 1e-8;
	
	@Autowired
	private EmployeeRepository employeeRepository;	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void createEmployee() {
		Employee emp = new Employee();
//		emp.setId(1);
		emp.setName("John");
		Employee savedEmp = employeeRepository.save(emp);
		assertNotNull(savedEmp);
	}	
	
	@Test
	public void createStudent() {
		Student student = new Student();
		student.setName("Rahul Jain");
		student.setEmail("rahul.jain@gmail.com");
		
		Student savedStudent = studentRepository.save(student);
		assertNotNull(savedStudent);
	}
}
