package com.springdatajpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springdatajpa.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	public List<Customer> findByNameAndEmail(String name, String email);
	public List<Customer> findByEmailLike(String email);
//	public List<Customer> findByIdIn(List<Integer> ids);
}
