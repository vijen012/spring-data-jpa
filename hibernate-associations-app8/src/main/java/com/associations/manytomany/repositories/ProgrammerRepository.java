package com.associations.manytomany.repositories;

import org.springframework.data.repository.CrudRepository;

import com.associations.manytomany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
