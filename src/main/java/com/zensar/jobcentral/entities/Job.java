package com.zensar.jobcentral.entities;

/**
 * @author Gourab Sarkar
 * @modification_date 07 Oct 2019 18:56
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Job Class (operates in Persistence layer)
 */

import java.sql.Clob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String jobId;

	private String jobName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyId")
	private Company company;
	
	@Column(nullable = false, updatable = true)
	private String jobType;
	@Column(nullable = false, updatable = true)
	private int numberOfVacancies;
	@Column(nullable = false, updatable = true)
	private Clob jobDescription;
	@Column(nullable = false, updatable = true)
	private String skillsRequired;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employerId")
	private Employer employer;
	
	private String category;
	
	// We only need the Job Seeker's ID.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobSeekerId")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name = "locationId")
	private Location location;
	
	@OneToMany(mappedBy = "jobs")
	private List<JobApplications> jobApplications;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public int getNumberOfVacancies() {
		return numberOfVacancies;
	}

	public void setNumberOfVacancies(int numberOfVacancies) {
		this.numberOfVacancies = numberOfVacancies;
	}

	public Clob getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(Clob jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<JobApplications> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplications> jobApplications) {
		this.jobApplications = jobApplications;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", company=" + company + ", jobType=" + jobType
				+ ", numberOfVacancies=" + numberOfVacancies + ", jobDescription=" + jobDescription
				+ ", skillsRequired=" + skillsRequired + ", employer=" + employer + ", category=" + category
				+ ", jobSeeker=" + jobSeeker + ", location=" + location + ", jobApplications=" + jobApplications + "]";
	}

}
