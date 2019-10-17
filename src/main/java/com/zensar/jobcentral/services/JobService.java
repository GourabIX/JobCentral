package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.entities.Job;

public interface JobService {

	List <Job>getAllJobs();
	Job getByJobId(int jobId);
	Job getByJobCategory(String category);
	Job getByJobLocation(int locationId);
	void insertJob(Job job);
	void updateJob(Job job);
	void deleteJob(Job job);
}
