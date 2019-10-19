package com.zensar.jobcentral.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.JobApplications;
import com.zensar.jobcentral.services.CompanyService;
import com.zensar.jobcentral.services.JobApplicationsService;

/**
 * @author Sneha Ojha
 * @modification_date 17 Oct 2019 12:57 PM
 * @creation_date 14 Oct 2019 6:23 PM
 * @version 1.0
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the User Login application Controller class. It is a
 *              part of Business layer of the application.
 */

@RestController
public class JobApplicationController {

    @Autowired
    private JobApplicationsService jobApplicationsService;
    
    @Autowired
    private CompanyService companyService;

    // this method is for apply job when details are pre-filled
    @PostMapping("/jobseekers/applications/new")
	public String newJobApplication(@RequestParam("timestamp") Timestamp timestamp, @RequestParam("jobId") String jobId)
	{
        try
        {
            if(jobApplicationsService.findByJobId(jobId) == null) 
            {
            	JobApplications jobApplication = new JobApplications();
            	jobApplication.setDateTimeOfApplication(timestamp);
                jobApplicationsService.insertJobApplication(jobApplication);
                System.out.println("debug: insertion is done");
                return "/jobseekers_home";
            }
            else
            {
                System.err.println("Debug: JobApplication for JobID: " + jobId + " already exists in the database!");
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        return "errorPage";
    }
    
    // delete existing job application
    @DeleteMapping("/jobseekers/application/delete")
	public String deleteJobApplication(@RequestParam("jobApplicationId") String applicationId)
    {
        try
        {
            if(jobApplicationsService.findByJobApplicationId(applicationId) != null) 
            {
            	JobApplications jobApplication = jobApplicationsService.findByJobApplicationId(applicationId);
                jobApplicationsService.deleteJobApplication(jobApplication);
                System.err.println("Debug: JobApplication with ID: " + applicationId + " has been deleted successfully.");
                return "/jobseekers_home";
            }
            else
            {
                System.err.println("Debug: JobApplication with ID: " + applicationId + " does not exist in the database.");
				return "/jobSeekers/application/delete";
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        return "errorPage";
    }
    
    @GetMapping("/jobseekers/application/all")
    public List<JobApplications> findAllJobApplications()
    {
    	try
    	{
    		return jobApplicationsService.findAllJobApplications();
    	}
    	catch(Exception exc)
    	{
    		exc.printStackTrace();
    	}
    	return null;
    }
    
    @GetMapping("/jobseekers/application/company")
    public List<JobApplications> findJobApplicationsByCompany(@RequestParam("companyName") String companyName)
    {
    	try
    	{
    		Company company = companyService.findCompanyByName(companyName);
    		return jobApplicationsService.findJobApplicationsByCompany(company);
    	}
    	catch(Exception exc)
    	{
    		exc.printStackTrace();
    	}
    	return null;
    }
    
    @GetMapping("/jobseekers/application/aidlookup")
    public JobApplications findByApplicationId(@RequestParam("applicationId") String applicationId)
    {
    	try
    	{
    		return jobApplicationsService.findByJobApplicationId(applicationId);
    	}
    	catch(Exception exc)
    	{
    		exc.printStackTrace();
    	}
    	return null;
    }
    
    @GetMapping("/jobseekers/application/lookupJobId")
    public List<JobApplications> findByJobId(String jobId)
    {
    	try
    	{
    		return jobApplicationsService.findByJobId(jobId);
    	}
    	catch(Exception exc)
    	{
    		exc.printStackTrace();
    	}
    	return null;
    }
    
    
}