package com.zensar.jobcentral.daos;

import java.util.List;


import com.zensar.jobcentral.entities.JobSeeker;

public interface JobSeekerDao {
	
	List<JobSeeker>getAllJobSeekers();
	JobSeeker getByJobSeekerId(int jobSeekerId);	
	void insertJobSeeker(JobSeeker jobSeeker);
	void updateJobSeeker(JobSeeker jobSeeker);
	void deleteJobSeeker(JobSeeker jobSeeker);
	
}
