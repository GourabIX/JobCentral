package com.zensar.jobcentral.entities;

import java.sql.Blob;
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
public class JobSeekerProfessional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobSeekerProfessionalId;
	
	@OneToOne
	@JoinColumn(name = "jobSeekerId")
	private JobSeeker jobSeeker;
	
	@Column(nullable = false, updatable = true)
	private String lastRole;
	private Date fromDateLastRole;
	private Date toDateLastRole;
	@Column(nullable = false, updatable = true)
	private String skillset;
	@Column(nullable = false, updatable = true)
	private Blob resume;
	
	public int getJobSeekerProfessionalId() {
		return jobSeekerProfessionalId;
	}
	
	public void setJobSeekerProfessionalId(int jobSeekerProfessionalId) {
		this.jobSeekerProfessionalId = jobSeekerProfessionalId;
	}
	
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	
	public String getLastRole() {
		return lastRole;
	}
	
	public void setLastRole(String lastRole) {
		this.lastRole = lastRole;
	}
	
	public Date getFromDateLastRole() {
		return fromDateLastRole;
	}
	
	public void setFromDateLastRole(Date fromDateLastRole) {
		this.fromDateLastRole = fromDateLastRole;
	}
	
	public Date getToDateLastRole() {
		return toDateLastRole;
	}
	
	public void setToDateLastRole(Date toDateLastRole) {
		this.toDateLastRole = toDateLastRole;
	}
	
	public String getSkillset() {
		return skillset;
	}
	
	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}
	
	public Blob getResume() {
		return resume;
	}
	
	public void setResume(Blob resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "JobSeekerProfessional [jobSeekerProfessionalId=" + jobSeekerProfessionalId + ", jobSeeker=" + jobSeeker
				+ ", lastRole=" + lastRole + ", fromDateLastRole=" + fromDateLastRole + ", toDateLastRole="
				+ toDateLastRole + ", skillset=" + skillset + ", resume=" + resume + "]";
	}	
	
}
