package com.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.entities.BankAccount;
import com.transaction.repositories.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository repository;
	
	@Override
	@Transactional //For transactional management - commit and rollback
	public void transfer(int amount) {
		BankAccount account1 = repository.findOne(1);
		account1.setBalance(account1.getBalance() - amount);
		repository.save(account1);
		
		/* When any exception occurs before function finishing it's execution then database will be in incosistency state
		 * to avoid this situation we use @Transactional annotation which do commit once whole code executed and if not 
		 * then roll back  */
		if (true) {
			throw new RuntimeException();
		}
		
		BankAccount account2 = repository.findOne(2);
		account2.setBalance(account2.getBalance() + amount);
		repository.save(account2);
	}

}
