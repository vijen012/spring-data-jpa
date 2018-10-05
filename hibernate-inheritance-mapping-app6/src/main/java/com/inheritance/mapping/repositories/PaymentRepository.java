package com.inheritance.mapping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.inheritance.mapping.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
