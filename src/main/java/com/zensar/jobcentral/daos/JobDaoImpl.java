package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.Job;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobDaoImpl implements JobDao {
     
	@Autowired
	private HibernateTemplate hibernateTemplate;
     
	@Override
	public List<Job> getAllJobs() {
		try 
		{
			return (List<Job>) hibernateTemplate.find("from Job");
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
			return hibernateTemplate.get(Job.class, jobId);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Job> getByCategory(String category) {
		try
		{
			Object[] values = {category};
			return (List<Job>) hibernateTemplate.find("from Job J WHERE J.category=?", values);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Job> getByLocation(int locationId) {
		try
		{
			Object[] values = {locationId};
			return (List<Job>) hibernateTemplate.find("from Job J WHERE J.locationId=?", values);	
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
			hibernateTemplate.save(job);
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
			hibernateTemplate.update(job);
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
			hibernateTemplate.delete(job);
			System.out.println("Debug: Job  having ID: " + job.getJobId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}

}
