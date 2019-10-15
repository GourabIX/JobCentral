package com.zensar.jobcentral.daos;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.zensar.jobcentral.entities.Job;

@Repository
public class JobDaoImpl extends DaoAssistant  implements JobDao {
     
     
	@Override
	public List<Job> getAllJobs() {
		try 
		{
			beginTx();
			Query query = getCurrentSession().createQuery("From Jobs");
			List<Job> listOfJobs = query.list();
			return listOfJobs;
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public Job getByJobId(int jobId) {
		try
		{
			beginTx();
			return getCurrentSession().get(Job.class, jobId);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public Job getByCategory(String category) {
		try
		{
			beginTx();
			return getCurrentSession().get(Job.class, category);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Job getByLocation(int locationId) {
		try
		{
			beginTx();
			return getCurrentSession().get(Job.class, locationId);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public void insertJobs(Job job) {
		try
		{
			beginTx();
			getCurrentSession().save(job);
			commitTransaction();
			System.out.println("Debug: job having ID: " + job.getJobId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}

	@Override
	public void updateJobs(Job job) {
		try
		{
			beginTx();
			getCurrentSession().update(job);
			commitTransaction();
			System.out.println("Debug: Job  having ID: " + job.getJobId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}

	@Override
	public void deleteJobs(Job job) {
		try
		{
			beginTx();
			getCurrentSession().delete(job);
			commitTransaction();
			System.out.println("Debug: Job  having ID: " + job.getJobId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}

}
