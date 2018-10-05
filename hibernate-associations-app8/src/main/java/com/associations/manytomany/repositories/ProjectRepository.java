package com.associations.manytomany.repositories;

import org.springframework.data.repository.CrudRepository;

import com.associations.manytomany.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
