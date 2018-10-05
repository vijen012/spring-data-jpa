package com.associations.onetoone.repositories;

import org.springframework.data.repository.CrudRepository;

import com.associations.onetoone.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
