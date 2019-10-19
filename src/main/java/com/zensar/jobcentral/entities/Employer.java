package com.zensar.jobcentral.entities;

/**
 * @author Gourab Sarkar
 * @modification_date 07 Oct 2019 20:08
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Employer Class (operates in Persistence layer)
 */

import java.util.List;

/**
 * @author Gourab Sarkar
 * @modification_date 07 Oct 2019 18:55
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Employer Class (operates in Persistence layer)
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Employer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employerId;
	@OneToOne
	@JoinColumn(name = "userId")
	private Login login;
	
	@Column(nullable = false, updatable = true)
	private String name;
	@Column(unique = true ,nullable = false, updatable = true)
	private long contact;											// Can be either mobile phone or desk-phone
	@Column(nullable = false, updatable = true)
	private String designation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyId")
	private Company company;
	
	@OneToMany(mappedBy = "employer")
	private List<Job> jobs;
	
	@ManyToOne
	@JoinColumn(name = "locationId")
	private Location location;

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employer [employerId=" + employerId + ", login=" + login + ", name=" + name + ", contact=" + contact
				+ ", designation=" + designation + ", company=" + company + ", jobs=" + jobs + "]";
	}

}
