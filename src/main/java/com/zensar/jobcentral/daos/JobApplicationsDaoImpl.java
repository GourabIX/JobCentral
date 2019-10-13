package com.zensar.jobcentral.daos;

/**
 * @author Priya Mirchandani, Gourab Sarkar
 * @modification_date 13 Oct 2019 11:33
 * @creation_date 04 Oct 2019 10:08
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the implementation of JobApplications DAO interface used in the persistence layer.
 */

import java.util.List;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.JobApplications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobApplicationsDaoImpl implements JobApplicationsDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void deleteJobApplication(JobApplications jobApplication) 
	{
		hibernateTemplate.delete(jobApplication);
		System.out.println("Debug: Job Application having ID: " + jobApplication.getApplicationId() + " has been deleted successfully.");
	}

	@Override
	public List<JobApplications> getAllJobApplications() 
	{
		return (List<JobApplications>) hibernateTemplate.find("FROM JobApplications");
	}

	@Override
	public JobApplications getByJobApplicationId(String applicationId) 
	{
		return hibernateTemplate.get(JobApplications.class, applicationId);
	}

	@Override
	public List<JobApplications> getByJobId(String jobId) 
	{
		return (List<JobApplications>) hibernateTemplate.find("FROM JobApplications WHERE jobId=?", jobId);
	}

	@Override
	public List<JobApplications> getJobApplicationsByCompany(Company company) 
	{
		return (List<JobApplications>) hibernateTemplate.find("FROM JobApplications WHERE companyId=?", company.getCompanyId());
	}

	@Override
	public void insertJobApplication(JobApplications jobApplication) 
	{
		hibernateTemplate.save(jobApplication);
		System.out.println("Debug: Job Application having ID: " + jobApplication.getApplicationId() + " has been saved successfully.");
	}

	@Override
	public void updateJobApplication(JobApplications jobApplication) 
	{
		hibernateTemplate.update(jobApplication);
		System.out.println("Debug: Job Application having ID: " + jobApplication.getApplicationId() + " has been updated successfully.");
	}
	
}
