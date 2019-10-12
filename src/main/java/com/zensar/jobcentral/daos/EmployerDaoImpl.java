package com.zensar.jobcentral.daos;

/**
 * @author Priya Mirchandani, Gourab Sarkar
 * @modification_date 12 Oct 2019 11:33
 * @creation_date 04 Oct 2019 10:08
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the Employer DAO interface used in the persistence layer.
 * 				This has been modified to adapt to SPB config.
 */

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.zensar.jobcentral.entities.Employer;

@Repository
public class EmployerDaoImpl implements EmployerDao 
{
	
	private Session session;
	
	public EmployerDaoImpl() 
	{
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		session=f.openSession();
	}
	
	@Override
	public List<Employer> getAllEmployers() 
	{
		return session.createQuery("from Employer").getResultList();	
	}
	
	@Override
	public Employer getById(int userId) 
	{
		return session.get(Employer.class, userId);
	}
	
	@Override
	public void insert(Employer employer) {
		Transaction t=session.beginTransaction();
		session.save(employer);
		t.commit();	
	}
	
	@Override
	public void update(Employer employer) 
	{
		Transaction t1=session.beginTransaction();
		session.update(employer);
		t1.commit();
	}
	
	@Override
	public void delete(Employer employer) 
	{
		Transaction t2=session.beginTransaction();
		session.delete(employer);
		t2.commit();	
	}
	
}