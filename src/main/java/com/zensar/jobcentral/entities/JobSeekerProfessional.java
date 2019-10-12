package com.zensar.jobcentral.entities;

import java.sql.Blob;

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
	
	private String lastRole;
	private int fromDateLastRole;
	private int toDateLastRole;
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
	
	public int getFromDateLastRole() {
		return fromDateLastRole;
	}
	
	public void setFromDateLastRole(int fromDateLastRole) {
		this.fromDateLastRole = fromDateLastRole;
	}
	
	public int getToDateLastRole() {
		return toDateLastRole;
	}
	
	public void setToDateLastRole(int toDateLastRole) {
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
