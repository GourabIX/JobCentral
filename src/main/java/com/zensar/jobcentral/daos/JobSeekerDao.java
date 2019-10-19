package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.JobSeeker;

/**
 * @author Gourab Sarkar
 * @modification_date 08 Oct 2019 00:26
 * @creation_date 08 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the JobSeeker DAO interface which is a part of persistence layer of the application.
 */

public interface JobSeekerDao {
	
	void insert(JobSeeker jobSeeker);
	void update(JobSeeker jobSeeker);
	void delete(JobSeeker jobSeeker);
	List<JobSeeker> getAllJobSeekers();
	JobSeeker getJobSeekerById(int jobSeekerId);

}
