package com.associations.manytomany.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.associations.manytomany.entities.Programmer;
import com.associations.manytomany.entities.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgrammerRepositoryTests {

	@Autowired
	private ProgrammerRepository programmerRepository;
	
	@Test
	public void testCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("Sunil Jain");
		programmer.setSalary(2000);
		
		//Set <Project> projects = new HashSet<>();
		Project project1 = new Project();
		project1.setName("Morgan Stanley");
		//projects.add(project1);
		
		//programmer.setProjects(projects);
		programmer.addProject(project1);
		programmerRepository.save(programmer);
	}
	
	@Test
	@Transactional //need when we are using child class
	public void testFindAllProgrammer() {
		Programmer programmer = programmerRepository.findOne(340);
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

}
