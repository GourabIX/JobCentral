package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.JobApplications;
import com.zensar.jobcentral.entities.JobSeeker;

public interface JobSeekerDao {
	List<JobSeeker>getAll();
	JobSeeker getById(String locationId);
	
	
	
	void insert(JobSeeker jobSeeker);
	void update(JobSeeker jobSeeker);
	void delete(JobSeeker jobSeeker);
}
