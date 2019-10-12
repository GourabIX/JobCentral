package com.zensar.jobcentral.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.JobApplications;
import com.zensar.jobcentral.entities.Location;

/**
 * @author Priya Mirchandani
 * @creation_date 5 october 2019 5.37pm
 * @modification_date 5 october 2019 5.37pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoimpl class using persistance layer
 *
 */
public class JobApplicationsDaoImpl implements JobApplicationsDao {
	private Session session;
	public JobApplicationsDaoImpl() {
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		session=f.openSession();
}
	@Override
	public List<JobApplications> getAll() {
		Query q=session.createQuery("from JobApplications");
		return q.getResultList();
	}

	@Override
	public JobApplications getByApplicationId(String applicationId) {
		return session.get(JobApplications.class, applicationId);
	}

	@Override
	public JobApplications getByJobId(String jobId) {
		return session.get(JobApplications.class, jobId);
	}

	@Override
	public void insert(JobApplications jobApplication) {
		Transaction t=session.beginTransaction();
		session.save( jobApplication);
		t.commit();
		
	}

	@Override
	public void update(JobApplications jobApplication) {
		Transaction t=session.beginTransaction();
		session.update( jobApplication);
		t.commit();
		
	}

	@Override
	public void delete(JobApplications jobApplication) {
		Transaction t=session.beginTransaction();
		session.delete( jobApplication);
		t.commit();
		
	}
	
	
}
