package com.springdatajpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdatajpa.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	/*
	 * When we are selecting all the columns then we don't need to use Select * From Student but
	 * When we are selecting partial columns then we need to use Select field1, field2 from Student
	 * 
	 * For DML queries we have to use extra annotation @Modifying
	 */
	
	/*@Query("from Student")
	public List<Student> findAllStudents();*/
	
	@Query("from Student")
	public List<Student> findAllStudents(Pageable pageable);
	
	@Query("select st.firstName, st.lastName from Student st")
	public List<Object[]> findAllStudentsPartialData();
	
	//Named query parameter
	@Query("from Student where firstName = :firstName")
	public List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);
	
	@Query("from Student where score > :min and score < :max")
	public List<Student> findAllStudentsForGivenScores(@Param("min") int min, @Param("max") int max);
	
	@Modifying
	@Query("delete from Student where firstName = :firstName ")
	public void deleteStudentsByFirstName(@Param("firstName") String firstName);
	
	@Modifying
	@Query("update Student s set s.score = :score where s.firstName = :firstName and s.lastName = :lastName")
	public void updateStudentsScoreByFirstNameAndLastName(@Param("score") int score, @Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Query(value = "SELECT * FROM STUDENT_1", nativeQuery = true)
	public List<Student> findAllStudentsNQ();
	
	@Query(value = "SELECT * FROM STUDENT_1 WHERE FNAME = :firstName", nativeQuery = true)
	public List<Student> finaAllStudentsByFirstNameNQ(@Param("firstName") String firstName);
}
