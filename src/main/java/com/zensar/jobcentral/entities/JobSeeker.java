package com.zensar.jobcentral.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobSeekerId;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Login login;
	
	@OneToOne(mappedBy = "jobSeeker")
	@JoinColumn(name = "userId")
	private JobSeekerAcademic jobSeekerAcademic;
	
	@OneToOne(mappedBy = "jobSeeker")
	@JoinColumn(name = "userId")
	private JobSeekerPersonal jobSeekerPersonal;
	
	@OneToOne(mappedBy = "jobSeeker")
	@JoinColumn(name = "userId")
	private JobSeekerProfessional jobSeekerProfessional;
	
	@ManyToOne								// Many JobSeekers can have one location because Location is (City, State, Country)
	@JoinColumn(name = "locationId")
	private Location location;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobApplications> jobApplications;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Job> jobs;

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public JobSeekerAcademic getJobSeekerAcademic() {
		return jobSeekerAcademic;
	}

	public void setJobSeekerAcademic(JobSeekerAcademic jobSeekerAcademic) {
		this.jobSeekerAcademic = jobSeekerAcademic;
	}

	public JobSeekerPersonal getJobSeekerPersonal() {
		return jobSeekerPersonal;
	}

	public void setJobSeekerPersonal(JobSeekerPersonal jobSeekerPersonal) {
		this.jobSeekerPersonal = jobSeekerPersonal;
	}

	public JobSeekerProfessional getJobSeekerProfessional() {
		return jobSeekerProfessional;
	}

	public void setJobSeekerProfessional(JobSeekerProfessional jobSeekerProfessional) {
		this.jobSeekerProfessional = jobSeekerProfessional;
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

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "JobSeeker [jobSeekerId=" + jobSeekerId + ", login=" + login + ", jobSeekerAcademic=" + jobSeekerAcademic
				+ ", jobSeekerPersonal=" + jobSeekerPersonal + ", jobSeekerProfessional=" + jobSeekerProfessional
				+ ", location=" + location + ", jobApplications=" + jobApplications + ", jobs=" + jobs + "]";
	}

}
