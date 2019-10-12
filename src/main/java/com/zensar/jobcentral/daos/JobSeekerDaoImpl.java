package com.zensar.jobcentral.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.jobcentral.entities.JobApplications;
import com.zensar.jobcentral.entities.JobSeeker;

public class JobSeekerDaoImpl implements JobSeekerDao {
	private Session session;
	 {
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		session=f.openSession();
}
	@Override
	public List<JobSeeker> getAll() {
		Query q=session.createQuery("from JobSeeker");
		return q.getResultList();
	}
	@Override
	public JobSeeker getById(String locationId) {
		return session.get(JobSeeker.class, locationId);
	}
	@Override
	public void insert(JobSeeker jobSeeker) {
		Transaction t=session.beginTransaction();
		session.save( jobSeeker);
		t.commit();
		
	}
	@Override
	public void update(JobSeeker jobSeeker) {
		Transaction t=session.beginTransaction();
		session.update( jobSeeker);
		t.commit();
		
		
	}
	@Override
	public void delete(JobSeeker jobSeeker) {
		Transaction t=session.beginTransaction();
		session.delete( jobSeeker);
		t.commit();
		
		
	}
	
	
}
