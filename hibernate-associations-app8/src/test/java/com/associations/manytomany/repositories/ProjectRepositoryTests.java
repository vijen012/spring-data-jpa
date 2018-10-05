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
public class ProjectRepositoryTests {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Test
	public void testSaveProject() {
		Project project = new Project();
		project.setName("IBM Watson");
		
		Programmer programmer = new Programmer();
		programmer.setName("Jitesh");
		programmer.setSalary(3000);
		
		project.addProgrammer(programmer);
		projectRepository.save(project);
	}
	
	@Test
	@Transactional
	public void testFindAllProject() {
		Project project = projectRepository.findOne(380);
		System.out.println(project);
		System.out.println(project.getProgrammers());
	}
 
}
