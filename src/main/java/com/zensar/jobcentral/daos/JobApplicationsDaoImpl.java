package com.zensar.jobcentral.daos;

import java.util.ArrayList;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobApplicationsDaoImpl implements JobApplicationsDao 
{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void deleteJobApplication(JobApplications jobApplication) 
	{
		try
		{
			hibernateTemplate.delete(jobApplication);
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
			return (List<JobApplications>) hibernateTemplate.find("from JobApplications");
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
			return hibernateTemplate.get(JobApplications.class, applicationId);
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
			List<JobApplications> listOfAllJobApplications = getAllJobApplications();
			List<JobApplications> listOfJobApplicationsByJobId = new ArrayList<JobApplications>();
			for (JobApplications jobApplication : listOfAllJobApplications)
			{
				if (jobApplication.getJobs().getJobId().equalsIgnoreCase(jobId))
				{
					listOfJobApplicationsByJobId.add(jobApplication);
				}
			}
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
			List<JobApplications> listOfJobApplications = getAllJobApplications();
			List<JobApplications> listOfJobApplicationsByCompanyId = new ArrayList<JobApplications>();
			for (JobApplications jobApplication : listOfJobApplications)
			{
				if (jobApplication.getJobs().getCompany().equals(company))
				{
					listOfJobApplicationsByCompanyId.add(jobApplication);
				}
			}
			return listOfJobApplicationsByCompanyId;
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
			hibernateTemplate.saveOrUpdate(jobApplication);
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
			hibernateTemplate.saveOrUpdate(jobApplication);
			System.out.println("Debug: Job Application having ID: " + jobApplication.getApplicationId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}
	
}
