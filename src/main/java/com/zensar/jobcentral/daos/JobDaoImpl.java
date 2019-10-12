package com.zensar.jobcentral.daos;

import java.util.List;

import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Job;

public class JobDaoImpl  implements JobDao {
     private Session session;
     public JobDaoImpl() {
    Configuration c= new Configuration().configure();
    SessionFactory f=c.buildSessionFactory();
    Session s=f.openSession();
    }
     
	@Override
	public List<Job> getAll() {
		Query q=session.createQuery("from Job");
		return q.getResultList();
	}

	@Override
	public Job getById(int jobId) {
		return session.get(Job.class, jobId);
	}

	@Override
	public Job getByCategory(String category) {
		return session.get(Job.class, category);
	}
	
	@Override
	public Job getByLocation(int locationId) {
		return session.get(Job.class, locationId);
	}
	
	
	@Override
	public void insert(Job job) {
		Transaction t=session.beginTransaction();
		session.save(job);
		t.commit();
		
	}

	@Override
	public void update(Job job) {
		Transaction t=session.beginTransaction();
		session.update(job);
		t.commit();
		
	}

	@Override
	public void delete(Job job) {
		Transaction t=session.beginTransaction();
		session.delete(job);
		t.commit();
		
	}

}
