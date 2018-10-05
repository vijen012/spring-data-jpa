package com.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdatajpa.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
}
