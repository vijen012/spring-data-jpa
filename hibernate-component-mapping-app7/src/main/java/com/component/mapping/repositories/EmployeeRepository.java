package com.component.mapping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.component.mapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
