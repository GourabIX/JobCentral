package com.zensar.jobcentral.services;

/**
 * @author Gourab Sarkar
 * @modification_date 17 Oct 2019 20:12
 * @creation_date 17 Oct 2019 20:12
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Employer Service interface which is a part of Business layer of the application.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.jobcentral.entities.JobSeeker;

@Service
@Transactional
public class JobSeekerServiceImpl implements JobSeekerService 
{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public JobSeeker findJobSeekerByUsername(String username) 
	{
		return hibernateTemplate.get(JobSeeker.class, username);
	}

	@Override
	public List<JobSeeker> findAllJobSeekers() 
	{
		return (List<JobSeeker>) hibernateTemplate.find("from JobSeeker");
	}

}
