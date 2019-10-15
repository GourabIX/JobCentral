package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Job;

public interface JobDao {

	List <Job>getAllJobs();
	Job getByJobId(int jobId);
	Job getByCategory(String category);
	Job getByLocation(int locationId);
	void insertJobs(Job job);
	void updateJobs(Job job);
	void deleteJobs(Job job);
}
