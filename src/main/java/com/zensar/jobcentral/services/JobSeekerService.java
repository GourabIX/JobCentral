package com.zensar.jobcentral.services;

import com.zensar.jobcentral.daos.JobSeekerDao;
import com.zensar.jobcentral.entities.Login;

public interface JobSeekerService {

	void setJobSeekerDao(JobSeekerDao jobSeekerDao);
	boolean validateUser(Login loginAuth);

}
