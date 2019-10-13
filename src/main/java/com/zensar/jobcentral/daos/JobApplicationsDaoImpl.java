package com.zensar.jobcentral.daos;

/**
 * @author Gourab Sarkar
 * @modification_date 13 Oct 2019 22:33
 * @creation_date 13 Oct 2019 22:33
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the implementation of JobApplications DAO interface used in the persistence layer.
 */

import java.util.List;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.JobApplications;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class JobApplicationsDaoImpl extends DaoAssistant implements JobApplicationsDao 
{
	
	@Override
	public void deleteJobApplication(JobApplications jobApplication) 
	{
		try
		{
			beginTx();
			getCurrentSession().delete(jobApplication);
			commitTransaction();
			System.out.println("Debug: Job Application having ID: " + jobApplication.getApplicationId() + " has been deleted successfully.");
		}
		catch (HibernateException hbexc)
		{
			hbexc.printStackTrace();
		}
	}

	@Override
	public List<JobApplications> getAllJobApplications() 
	{
		try
		{
			beginTx();
			Query query = getCurrentSession().createQuery("FROM JobApplications");
			List<JobApplications> listOfAllJobApplications = query.list();
			return listOfAllJobApplications;
		}
		catch (HibernateException hbexc)
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public JobApplications getByJobApplicationId(String applicationId) 
	{
		try
		{
			beginTx();
			return getCurrentSession().get(JobApplications.class, applicationId);
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public List<JobApplications> getByJobId(String jobId) 
	{
		try
		{
			beginTx();
			Query query = getCurrentSession().createQuery("FROM JobApplications JA WHERE JA.jobId = :jobId");
			query.setParameter("jobId", jobId);
			List<JobApplications> listOfJobApplicationsByJobId = query.list();
			return listOfJobApplicationsByJobId;
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public List<JobApplications> getJobApplicationsByCompany(Company company) 
	{
		try
		{
			beginTx();
			Query query = getCurrentSession().createQuery("FROM JobApplications JA WHERE JA.companyId = :companyId");
			query.setParameter("companyId", company.getCompanyId());
			List<JobApplications> listOfJobApplicationsByCompany = query.list();
			return listOfJobApplicationsByCompany;
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertJobApplication(JobApplications jobApplication) 
	{
		try
		{
			beginTx();
			getCurrentSession().save(jobApplication);
			System.out.println("Debug: Job Application having ID: " + jobApplication.getApplicationId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}

	@Override
	public void updateJobApplication(JobApplications jobApplication) 
	{
		try
		{
			beginTx();
			getCurrentSession().update(jobApplication);
			System.out.println("Debug: Job Application having ID: " + jobApplication.getApplicationId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}
	
}
