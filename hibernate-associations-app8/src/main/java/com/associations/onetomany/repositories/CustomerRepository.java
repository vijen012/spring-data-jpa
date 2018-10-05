package com.associations.onetomany.repositories;

import org.springframework.data.repository.CrudRepository;

import com.associations.onetomany.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
