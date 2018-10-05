package com.springdatajpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdatajpa.entities.Customer;
import com.springdatajpa.entities.Product;
import com.springdatajpa.repository.CustomerRepository;
import com.springdatajpa.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicCrudOpsAppTests {

	private static final double DELTA = 1e-8;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateProduct() {
		Product product = new Product();
		product.setId(1);
		product.setName("MacBook Pro");
		product.setDesc("Awesome");
		product.setPrice(1500d);
		productRepository.save(product);
	}
	
	@Test
	public void testReadProduct() {
		Product product = productRepository.findOne(1);
		assertNotNull(product);
		assertEquals("Actual and Expected Description Value are not equals", "MacBook Pro", product.getName());
	}
	
	@Test
	public void testUpdateProduct() {
		Product product = productRepository.findOne(1);
		product.setPrice(2000d);
		productRepository.save(product);
		assertEquals("Actual and Expected price value are not equals", 2000d, productRepository.findOne(1).getPrice(), DELTA);
	}
	
/*	@Test
	public void testDeleteProduct() {
		if (productRepository.exists(1)) {
			productRepository.delete(1);
			assertNull(productRepository.findOne(1));
		}
	}*/
	
	@Test
	public void testCountProduct() {
		assertTrue(1 == productRepository.count());
	}
	
	@Test
	public void testCreateCustomr() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Rahul");
		customer.setEmail("rahul.jain@gmail.com");
		customerRepository.save(customer);
	}
	
	@Test
	public void testReadCustomer() {
		Customer customer = customerRepository.findOne(1);
		assertNotNull(customer);
		assertEquals("Actual and Expected email value does not match", "rahul.jain@gmail.com", customer.getEmail());
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerRepository.findOne(1);
		customer.setName("Rahul Jain");
		customerRepository.save(customer);
		assertEquals("Actual and Expected value of Property Name doesn't match ", "Rahul Jain", customerRepository.findOne(1).getName());
	}
	
/*	@Test
	public void testDeleteCustomer() {
		if (customerRepository.exists(1)) {
			customerRepository.delete(1);
			assertNull(customerRepository.findOne(1));
		}
	}*/
	
	@Test
	public void testCountCustomer() {
		assertTrue(1 == customerRepository.count());
	}
	

}
