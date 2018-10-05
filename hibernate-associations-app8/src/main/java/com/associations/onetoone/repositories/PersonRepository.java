package com.associations.onetoone.repositories;

import org.springframework.data.repository.CrudRepository;

import com.associations.onetoone.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
