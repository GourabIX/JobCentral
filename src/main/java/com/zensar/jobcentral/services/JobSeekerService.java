package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.entities.JobSeeker;

/**
 * @author Gourab Sarkar
 * @modification_date 08 Oct 2019 00:26
 * @creation_date 08 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Employer Service interface which is a part of Business layer of the application.
 */

public interface JobSeekerService 
{
	JobSeeker findJobSeekerByUsername(String username);
	List<JobSeeker> findAllJobSeekers();
}
