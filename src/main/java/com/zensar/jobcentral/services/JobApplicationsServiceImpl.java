package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.daos.JobApplicationsDao;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.JobApplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gourab Sarkar
 * @modification_date 13 Oct 2019 20:57
 * @creation_date 13 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the JobApplicationsServiceImpl class which implements JobApplicationsService interface and is a part of Business layer of the application.
 */

@Service
@Transactional
public class JobApplicationsServiceImpl implements JobApplicationsService
{

    @Autowired
    private JobApplicationsDao jobApplicationsDao;

    @Override
    public List<JobApplications> findAllJobApplications() 
    {
        return jobApplicationsDao.getAllJobApplications();
    }

    @Override
    public List<JobApplications> findJobApplicationsByCompany(Company company) 
    {
        return jobApplicationsDao.getJobApplicationsByCompany(company);
    }

    @Override
    public JobApplications findByJobApplicationId(String applicationId) 
    {
        return jobApplicationsDao.getByJobApplicationId(applicationId);
    }

    @Override
    public List<JobApplications> findByJobId(String jobId) 
    {
        return jobApplicationsDao.getByJobId(jobId);
    }

    @Override
    public void insertJobApplication(JobApplications jobApplication) 
    {
        jobApplicationsDao.insertJobApplication(jobApplication);
    }

    @Override
    public void updateJobApplication(JobApplications jobApplication) 
    {
        jobApplicationsDao.updateJobApplication(jobApplication);
    }

    @Override
    public void deleteJobApplication(JobApplications jobApplication) 
    {
        jobApplicationsDao.deleteJobApplication(jobApplication);
    }

}