package com.zensar.jobcentral.entities;

import java.util.List;

/**
 * @author Gourab Sarkar
 * @modification_date 07 Oct 2019 18:55
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Company Class (operates in Persistence layer)
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyId;
	private String companyName;
	
	@ManyToMany
	private List<Location> locations;
	
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
	
	@OneToMany(mappedBy = "company")
	List<Employer> employers;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", locations=" + locations
				+ ", jobs=" + jobs + "]";
	}
	
}
