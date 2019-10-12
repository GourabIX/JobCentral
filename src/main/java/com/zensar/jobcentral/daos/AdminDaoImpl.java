package com.zensar.jobcentral.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.jobcentral.entities.Admin;

/**
 * @author Priya Mirchandani
 * @creation_date 5 october 2019 5.37pm
 * @modification_date 5 october 2019 5.37pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoimpl class using persistance layer
 *
 */
public class AdminDaoImpl implements AdminDao {

	private Session session;
	public AdminDaoImpl() {
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		session=f.openSession();

	}
	@Override
	public List<Admin> getAll() {
		
		Query q=session.createQuery("from Admin");
		return q.getResultList();
	}

	@Override
	public Admin getById(int userId) {
		return session.get(Admin.class, userId);
	}

	@Override
	public void insert(Admin admin) {
		Transaction t=session.beginTransaction();
		session.save(admin);
		t.commit();
		
		
	}

	@Override
	public void update(Admin admin) {
		Transaction t1=session.beginTransaction();
		 session.update(admin);
		t1.commit();
	}

	@Override
	public void delete(Admin admin) {
		Transaction t2=session.beginTransaction();
		 session.delete(admin);
		t2.commit();
		
	}

}
