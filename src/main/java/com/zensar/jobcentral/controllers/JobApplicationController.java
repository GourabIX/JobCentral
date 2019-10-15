package com.zensar.jobcentral.controllers;

import com.zensar.jobcentral.entities.JobApplications;
import com.zensar.jobcentral.services.JobApplicationsServiceImpl;
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

    private JobApplicationsServiceImpl jobApplicationsServiceImpl;
    private JobApplications jobApplication;

    public void jobApplication(){

    // apply for job
    jobApplicationsServiceImpl.insertJobApplication(jobApplication);
    System.out.println("insert is done");
    
    // update job application
    jobApplicationsServiceImpl.updateJobApplication(jobApplication);
    System.out.println("update is done");
    
    // delete job application
    jobApplicationsServiceImpl.deleteJobApplication(jobApplication);
    System.out.println("delete is done");
    }
}