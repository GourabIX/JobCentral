package com.zensar.jobcentral.entities;

/**
 * @author Gourab Sarkar
 * @modification_date 07 Oct 2019 18:56
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent JobApplications Class (operates in Persistence layer)
 */

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class JobApplications {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String applicationId;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Login login;
	
	@OneToOne(mappedBy = "jobApplications")
	@JoinColumn(name = "jobId")
	private Job jobs;
	
	private Timestamp dateTimeOfApplication;		// Check if import is proper -- Found no Hibernate module!
	
	// Employer will need to see the JobSeeker's complete profile
	@OneToOne
	@JoinColumn(name = "userId")
	private JobSeeker jobSeeker;

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Job getJobs() {
		return jobs;
	}

	public void setJobs(Job jobs) {
		this.jobs = jobs;
	}

	public Timestamp getDateTimeOfApplication() {
		return dateTimeOfApplication;
	}

	public void setDateTimeOfApplication(Timestamp dateTimeOfApplication) {
		this.dateTimeOfApplication = dateTimeOfApplication;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	@Override
	public String toString() {
		return "JobApplications [applicationId=" + applicationId + ", login=" + login + ", jobs=" + jobs
				+ ", dateTimeOfApplication=" + dateTimeOfApplication + ", jobSeeker=" + jobSeeker + "]";
	}

}
