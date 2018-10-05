package com.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdatajpa.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
