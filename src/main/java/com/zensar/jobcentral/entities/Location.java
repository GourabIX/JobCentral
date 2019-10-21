package com.zensar.jobcentral.entities;

/**
 * @author Gourab Sarkar
 * @modification_date 12 Oct 2019 20:08
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Location Class (operates in Persistence layer)
 */

import java.util.List;

import javax.persistence.CascadeType;

/**
 * @author Gourab Sarkar
 * @modification_date 07 Oct 2019 18:58
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Location Class (operates in Persistence layer)
 */

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int locationId;
	private String city;
	private String state;
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employer> employer;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Company> companies;
	
	@OneToOne(mappedBy = "location", fetch = FetchType.LAZY)
	@JoinColumn(name = "locationId")
	private Admin admin;
	
	// Additional to posting the Jobs employer should also have option to search
	// for the employees by providing key requirements.
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobSeeker> jobSeeker;
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Job> jobs;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Employer> getEmployer() {
		return employer;
	}

	public void setEmployer(List<Employer> employer) {
		this.employer = employer;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<JobSeeker> getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(List<JobSeeker> jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", city=" + city + ", state=" + state + ", employer=" + employer
				+ ", companies=" + companies + ", admin=" + admin + ", jobSeeker=" + jobSeeker + ", jobs=" + jobs + "]";
	}	

}
