package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.JobApplications;

/**
 * @author Gourab Sarkar
 * @modification_date 13 Oct 2019 20:57
 * @creation_date 13 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the JobApplicationsService interface and is a part of Business layer of the application.
 */

public interface JobApplicationsService
{

    List<JobApplications>findAllJobApplications();
	List<JobApplications>findJobApplicationsByCompany(Company company);
	JobApplications findByJobApplicationId(String applicationId);
	List<JobApplications> findByJobId(String jobId);
	void insertJobApplication(JobApplications jobApplication);
	void updateJobApplication(JobApplications jobApplication);
	void deleteJobApplication(JobApplications jobApplication);

}