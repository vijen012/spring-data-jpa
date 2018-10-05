package com.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdatajpa.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
