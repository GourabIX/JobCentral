package com.zensar.jobcentral.entities;

/**
 * @author Gourab Sarkar
 * @modification_date 07 Oct 2019 18:58
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Login Class (operates in Persistence layer)
 */

import javax.persistence.Column;

/**
 * @author Gourab Sarkar
 * @modification_date 04 Oct 2019 09:18
 * @creation_date 01 Oct 2019 21:02
 * @version 1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Login Class (operates in Persistence layer)
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Login {
	
	// Instance Variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(unique = true, nullable = false, updatable = true)
	private String username;
	@Column(nullable = false, updatable = true)
	private String password;
	@Column(nullable = false, updatable = false, length = 3)				// can be either JSK, EMP or ADM.
	private String roleType;
	
	@OneToOne(mappedBy = "login")
	@JoinColumn(name = "userId")
	private JobSeeker jobSeeker;
	
	@OneToOne(mappedBy = "login")
	@JoinColumn(name = "userId")
	private Employer employer;
	
	@OneToOne(mappedBy = "login")
	@JoinColumn(name = "userId")
	private Admin admin;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Login [userId=" + userId + ", username=" + username + ", password=" + password + ", roleType="
				+ roleType + ", jobSeeker=" + jobSeeker + ", employer=" + employer + ", admin=" + admin + "]";
	}
	
}
