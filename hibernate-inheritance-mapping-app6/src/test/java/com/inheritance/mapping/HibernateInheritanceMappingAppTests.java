package com.inheritance.mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inheritance.mapping.entities.Check;
import com.inheritance.mapping.entities.CreditCard;
import com.inheritance.mapping.repositories.PaymentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateInheritanceMappingAppTests {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCardPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(1);
		cc.setAmount(1000);
		cc.setCardNumber("123456789");
		paymentRepository.save(cc);
	}
	
	@Test
	public void testCreateCheckPayment() {
		Check ch = new Check();
		ch.setId(2);
		ch.setAmount(1000);
		ch.setCheckNumber("123456789");
		paymentRepository.save(ch);
	}

}
