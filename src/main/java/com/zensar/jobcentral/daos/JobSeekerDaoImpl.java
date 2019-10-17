package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.JobSeeker;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public class JobSeekerDaoImpl extends DaoAssistant implements JobSeekerDao {

	@Override
	public List<JobSeeker> getAllJobSeekers() {
		
			try 
			{
				beginTx();
				Query query = getCurrentSession().createQuery("from Company");
				List<JobSeeker> listOfJobSeekers =  query.list();
				return listOfJobSeekers;
			}
			catch (HibernateException hbexc) 
			{
				hbexc.printStackTrace();
			}
			return null;
	
	}

	@Override
	public JobSeeker getByJobSeekerId(int jobSeekerId) {
		try 
		{
			beginTx();
			return getCurrentSession().get(JobSeeker.class, jobSeekerId);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertJobSeeker(JobSeeker jobSeeker) {
		try
		{
			beginTx();
			getCurrentSession().save(jobSeeker);
			commitTransaction();
			System.out.println("Debug: JobSeeker  having ID: " + jobSeeker.getJobSeekerId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}

	@Override
	public void updateJobSeeker(JobSeeker jobSeeker) {
		try
		{
			beginTx();
			getCurrentSession().update(jobSeeker);
			commitTransaction();
			System.out.println("Debug: JobSeeker  having ID: " + jobSeeker.getJobSeekerId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteJobSeeker(JobSeeker jobSeeker) {
		try
		{
			beginTx();
			getCurrentSession().delete(jobSeeker);
			commitTransaction();
			System.out.println("Debug: JobSeeker  having ID: " + jobSeeker.getJobSeekerId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
		
	}
	
	
	
}
