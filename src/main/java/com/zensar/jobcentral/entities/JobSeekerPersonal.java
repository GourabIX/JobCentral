package com.zensar.jobcentral.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class JobSeekerPersonal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobSeekerPersonalId;
	
	@OneToOne
	@JoinColumn(name = "jobSeekerId")
	private JobSeeker jobSeeker;
	
	@Column(nullable = false, updatable = true)
	private String name;
	@Column(nullable = false, updatable = true)
	private Date dob;
	@Column(unique = true , nullable = false, updatable = true)
	private long mobile;
	
	public int getJobSeekerPersonalId() {
		return jobSeekerPersonalId;
	}
	
	public void setJobSeekerPersonalId(int jobSeekerPersonalId) {
		this.jobSeekerPersonalId = jobSeekerPersonalId;
	}
	
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public long getMobile() {
		return mobile;
	}
	
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "JobSeekerPersonal [jobSeekerPersonalId=" + jobSeekerPersonalId + ", jobSeeker=" + jobSeeker + ", name="
				+ name + ", dob=" + dob + ", mobile=" + mobile + "]";
	}
	
}
