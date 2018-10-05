package com.springdatajpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springdatajpa.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public List<Product> findByName(String name);
	public List<Product> findByNameAndDesc(String name, String desc);
	public List<Product> findByPriceGreaterThan(Double price);
	public List<Product> findByDescContains(String desc);
	public List<Product> findByPriceBetween(Double price1, Double price2);
	public List<Product> findByDescLike(String desc);
	public List<Product> findByIdIn(List<Integer> ids);
}
