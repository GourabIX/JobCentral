package com.zensar.jobcentral.daos;
/**
 * @author Priya Mirchandani
 * @creation_date 9 october 2019 2.12pm
 * @modification_date 9 october 2019 2.12pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a dao class using persistance layer
 *
 */
import java.util.List;

import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.JobApplications;

public interface JobApplicationsDao {
	List<JobApplications>getAll();
	JobApplications getByApplicationId(String applicationId);
     JobApplications getByJobId(String jobId);
	
	
	void insert(JobApplications jobApplication);
	void update(JobApplications jobApplication);
	void delete(JobApplications jobApplication);
}
