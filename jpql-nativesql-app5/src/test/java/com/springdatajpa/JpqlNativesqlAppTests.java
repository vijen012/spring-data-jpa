package com.springdatajpa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdatajpa.entities.Student;
import com.springdatajpa.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpqlNativesqlAppTests {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testStudentCreate() {
		List<Student> studentList = new ArrayList<>();
		Student student1 = new Student();
		student1.setFirstName("Myank");
		student1.setLastName("Jain");
		student1.setScore(88);
		studentList.add(student1);
		
		Student student2 = new Student();
		student2.setFirstName("Mayank");
		student2.setLastName("Gupta");
		student2.setScore(75);
		studentList.add(student2);
		
		Iterable<Student> it = studentRepository.save(studentList);
//		it.forEach(student -> System.out.println(student.getFirstName()));
		List<Student> studentListNew = new ArrayList<>();
		it.forEach(studentListNew::add);
		assertTrue(studentList.containsAll(studentListNew));
	}
	
	@Test
	public void testFindAllStudendts() {
		//studentRepository.findAllStudents().forEach(System.out::println);
		
		//Enable paging
		//studentRepository.findAllStudents(new PageRequest(0, 4)).forEach(System.out::println);
		
		//Enable paging and sorting
		studentRepository.findAllStudents(new PageRequest(1, 4, Direction.ASC, "id")).forEach(System.out::println);
	}
	
	@Test
	public void testFindAllStudentsPartialData() {
		List<Object[]> studentsPartialData = studentRepository.findAllStudentsPartialData();
		studentsPartialData.forEach(objectArr -> System.out.println(objectArr[0] + " : " + objectArr[1]));
	}
	
	@Test
	public void testFindAllStudentsByFirstName() {
		List<Student> studentList = studentRepository.findAllStudentsByFirstName("Mayank");
		studentList.forEach(System.out::println);
	}
	
	@Test
	public void testFindAllStudentsForGivenScores() {
		List<Student> studentList = studentRepository.findAllStudentsForGivenScores(80, 90);
		studentList.forEach(System.out::println);
	}
	
	@Test
	@Rollback(false) //Default it's true so it won't commit changes in database
	@Transactional
	public void testDeleteStudentsByFirstName() {
		studentRepository.deleteStudentsByFirstName("Mayank");
	}
	
	@Test
	@Rollback(false) //Default it's true so it won't commit changes in database
	@Transactional
	public void testUpdateStudentsScoreByFirstNameAndLastName() {
		studentRepository.updateStudentsScoreByFirstNameAndLastName(78, "Rahul", "Jain");
	}
	
	@Test
	public void testFindAllStudentsNQ() {
		studentRepository.findAllStudentsNQ().forEach(System.out::println);
	}

	@Test
	public void testFindAllStudentsByFirstNameNQ() {
		studentRepository.finaAllStudentsByFirstNameNQ("Rahul").forEach(System.out::println);
	}
}
