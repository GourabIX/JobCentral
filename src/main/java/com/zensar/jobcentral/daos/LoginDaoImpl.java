package com.zensar.jobcentral.daos;
/**
 * @author Priya Mirchandani
 * @creation_date 7 october 2019 6.52pm
 * @modification_date 7 october 2019 6.52pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoimpl class using persistance layer
 *
 */
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.jobcentral.entities.Location;
import com.zensar.jobcentral.entities.Login;



public class LoginDaoImpl implements LoginDao {
	private Session session;
	public LoginDaoImpl() {
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		session=f.openSession();
	}
	@Override
	public Login getUserById(int userId) {
		return session.get(Login.class, userId);
	}

	@Override
	public void insert(Login login) {
		Transaction t=session.beginTransaction();
		session.save(login);
		t.commit();
		
	}

	@Override
	public void update(Login login) {
		Transaction t=session.beginTransaction();
		session.update(login);
		t.commit();
	}

	@Override
	public void delete(Login login) {
		Transaction t=session.beginTransaction();
		session.delete(login);
		t.commit();
	}
	

}
