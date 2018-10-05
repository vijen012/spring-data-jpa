package com.transaction.repositories;

import org.springframework.data.repository.CrudRepository;

import com.transaction.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
