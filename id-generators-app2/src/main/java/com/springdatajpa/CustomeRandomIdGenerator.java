package com.springdatajpa;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomeRandomIdGenerator implements IdentifierGenerator{

	//here object will be Employee class
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Random random = null;
		int id = 0;
		random = new Random();
		id = random.nextInt(1000000);
		return new Long(id);
	}

}
