package com.zensar.jobcentral.daos;

/**
 * @author Priya Mirchandani, Gourab Sarkar
 * @modification_date 13 Oct 2019 11:33
 * @creation_date 04 Oct 2019 10:08
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the JobApplications DAO interface used in the persistence layer.
 */

import java.util.List;

import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.JobApplications;

public interface JobApplicationsDao 
{
	List<JobApplications>getAllJobApplications();
	List<JobApplications>getJobApplicationsByCompany(Company company);
	JobApplications getByJobApplicationId(String applicationId);
	List<JobApplications> getByJobId(String jobId);
	void insertJobApplication(JobApplications jobApplication);
	void updateJobApplication(JobApplications jobApplication);
	void deleteJobApplication(JobApplications jobApplication);
}
