package com.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdatajpa.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
