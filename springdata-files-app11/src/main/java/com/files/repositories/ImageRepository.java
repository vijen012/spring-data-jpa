package com.files.repositories;

import org.springframework.data.repository.CrudRepository;

import com.files.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {
	

}
