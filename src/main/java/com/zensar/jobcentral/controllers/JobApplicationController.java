package com.zensar.jobcentral.controllers;

import com.zensar.jobcentral.entities.JobApplications;
import com.zensar.jobcentral.entities.JobSeekerAcademic;
import com.zensar.jobcentral.entities.JobSeekerPersonal;
import com.zensar.jobcentral.entities.JobSeekerProfessional;
import com.zensar.jobcentral.services.JobApplicationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sneha Ojha
 * @modification_date 14 Oct 2019 6:23 PM
 * @creation_date 14 Oct 2019 6:23 PM
 * @version 1.0
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the User Login application Controller class. It is a
 *              part of Business layer of the application.
 */

@RestController
public class JobApplicationController {

    @Autowired
    private JobApplicationsServiceImpl jobApplicationsServiceImpl;

    @Autowired
    private JobApplications jobApplication;

    @Autowired 
    private JobSeekerAcademic jobSeekerAcademic;

    @Autowired 
    private JobSeekerPersonal jobSeekerPersonal;

    @Autowired 
    private JobSeekerProfessional jobSeekerProfessional;

    // this method is for apply job when details are pre filled
    @PutMapping("/jobseekers/application/insert")
	public String insertApplicationDetails()
	{
        try{
            if(jobSeekerAcademic.getJobSeekerAcademicId()==0 && jobSeekerPersonal.getJobSeekerPersonalId()==0 && jobSeekerProfessional.getJobSeekerProfessionalId()== 0) 
            {
                jobApplicationsServiceImpl.insertJobApplication(jobApplication);
                System.out.println("debug: insert is done");
                return "/jobseekers/application/insert";
            }
            else
            {
                System.err.println("Debug: jobseeker with id already exists in the database!");
				return "jobSeekers/application/update";
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        return "errorPage";
    }
    
    // update existing job application
    @PutMapping("/jobseekers/application/update")
	public String updateApplicationDetails(){
        try{
            if(jobSeekerAcademic.getJobSeekerAcademicId()!=0 && jobSeekerPersonal.getJobSeekerPersonalId()!=0 && jobSeekerProfessional.getJobSeekerProfessionalId()!= 0) 
            {
                jobApplicationsServiceImpl.updateJobApplication(jobApplication);
                System.out.println("debug: update is done");
                return "/jobseekers/application/update";
            }
            else
            {
                System.err.println("Debug: jobseeker with id do not exists in the database!");
				return "/jobSeekers/application/insert";
            }
        }
        catch(Exception ee){
            ee.printStackTrace();
        }

       return "errorPage";
    }
    
    // delete existing job application
    @PutMapping("/jobseekers/application/update")
	public String deleteApplicationDetails(){
        try
        {
            if(jobSeekerAcademic.getJobSeekerAcademicId()!=0 && jobSeekerPersonal.getJobSeekerPersonalId()!=0 && jobSeekerProfessional.getJobSeekerProfessionalId()!= 0) 
            {
                jobApplicationsServiceImpl.deleteJobApplication(jobApplication);
                System.out.println("debug: delete is done");
                return "/jobseekers/application/insert";
            }
            else
            {
                System.err.println("Debug: jobseeker with id do not exists in the database!");
				return "/jobSeekers/application/insert";
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        return "errorPage";
    }
}