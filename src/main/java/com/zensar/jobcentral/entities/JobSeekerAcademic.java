package com.zensar.jobcentral.entities;

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
public class JobSeekerAcademic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobSeekerAcademicId;
	
	@OneToOne
	@JoinColumn(name = "jobSeekerId")
	private JobSeeker jobSeeker;
	
	@Column(nullable = false, updatable = true)
	private int sscYear;
	@Column(nullable = false, updatable = true)
	private double sscPercent;
	@Column(nullable = false, updatable = true)
	private int hscYear;
	@Column(nullable = false, updatable = true)
	private double hscPercent;
	@Column(nullable = false, updatable = true)
	private String qualification;
	@Column(nullable = false, updatable = true)
	private int qualificationYear;
	@Column(nullable = false, updatable = true)
	private double cgpa;
	@Column(nullable = false, updatable = true)
	private String summary;
	
	public int getJobSeekerAcademicId() {
		return jobSeekerAcademicId;
	}
	
	public void setJobSeekerAcademicId(int jobSeekerAcademicId) {
		this.jobSeekerAcademicId = jobSeekerAcademicId;
	}
	
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	
	public int getSscYear() {
		return sscYear;
	}
	
	public void setSscYear(int sscYear) {
		this.sscYear = sscYear;
	}
	
	public double getSscPercent() {
		return sscPercent;
	}
	
	public void setSscPercent(double sscPercent) {
		this.sscPercent = sscPercent;
	}
	
	public int getHscYear() {
		return hscYear;
	}
	
	public void setHscYear(int hscYear) {
		this.hscYear = hscYear;
	}
	
	public double getHscPercent() {
		return hscPercent;
	}
	
	public void setHscPercent(double hscPercent) {
		this.hscPercent = hscPercent;
	}
	
	public String getQualification() {
		return qualification;
	}
	
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public int getQualificationYear() {
		return qualificationYear;
	}
	
	public void setQualificationYear(int qualificationYear) {
		this.qualificationYear = qualificationYear;
	}
	
	public double getCgpa() {
		return cgpa;
	}
	
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "JobSeekerAcademic [jobSeekerAcademicId=" + jobSeekerAcademicId + ", jobSeeker=" + jobSeeker
				+ ", sscYear=" + sscYear + ", sscPercent=" + sscPercent + ", hscYear=" + hscYear + ", hscPercent="
				+ hscPercent + ", qualification=" + qualification + ", qualificationYear=" + qualificationYear
				+ ", cgpa=" + cgpa + ", summary=" + summary + "]";
	}	
	
}
