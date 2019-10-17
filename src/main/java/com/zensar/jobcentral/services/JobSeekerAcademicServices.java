package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.entities.JobSeekerAcademic;

/**
 * @author Sushma Kumari
 * @creation_date 04 Oct 2019 02:47 PM
 * @version 1.0
 * @modification_date 15 Oct 2019 02:32 PM
 * @copyright All rights are reserver by Zensar.
 * @description It is JobSeeker Personal Service class. It is used in Business
 *              Layer.
 * 
 */
public interface JobSeekerAcademicServices {
	void add(JobSeekerAcademic jobSeekerAcademic);
    void update(JobSeekerAcademic jobSeekerAcademic);
    void remove(JobSeekerAcademic jobSeekerAcademic);
    JobSeekerAcademic findJobSeekerAcademicByUsername(String username);
    List<JobSeekerAcademic> findAllJobSeekerAcademicDetails();
}
