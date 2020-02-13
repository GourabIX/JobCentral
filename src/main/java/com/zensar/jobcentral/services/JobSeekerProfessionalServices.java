package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.entities.JobSeekerProfessional;
/**
 * @author Sushma Kumari
 * @creation_date 04 Oct 2019 02:47 PM
 * @version 1.0
 * @modification_date 15 Oct 2019 02:32 PM
 * @copyright All rights are reserved by Zensar.
 * @description It is JobSeeker Personal Service class.
 * 		It is used in Business Layer.
 * 		
 */
public interface JobSeekerProfessionalServices {
    void add(JobSeekerProfessional jobSeekerProfessional);
    void update(JobSeekerProfessional jobSeekerProfessional);
    void remove(JobSeekerProfessional jobSeekerProfessional);
    JobSeekerProfessional findJobSeekerProfessionalByUsername(String username);
    List<JobSeekerProfessional> findAllJobSeekerProfessionalDetails();
}
