package com.associations.onetomany.repositories;

import org.springframework.data.repository.CrudRepository;

import com.associations.onetomany.entities.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {

}
