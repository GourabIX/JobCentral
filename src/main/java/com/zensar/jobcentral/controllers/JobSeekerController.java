package com.zensar.jobcentral.controllers;

/**
 * @author Gourab Sarkar
 * @modification_date 17 Oct 2019 06:55
 * @creation_date 17 Oct 2019 06:55
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the JobSeeker Controller class which is a part of Business layer of the application.
 */

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import com.zensar.jobcentral.entities.JobSeekerAcademic;
import com.zensar.jobcentral.entities.JobSeekerPersonal;
import com.zensar.jobcentral.entities.JobSeekerProfessional;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.ServiceException;
import com.zensar.jobcentral.services.JobSeekerAcademicServicesImpl;
import com.zensar.jobcentral.services.JobSeekerPersonalServicesImpl;
import com.zensar.jobcentral.services.JobSeekerProfessionalServicesImpl;
import com.zensar.jobcentral.services.LoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobSeekerController 
{

    @Autowired
    private JobSeekerAcademicServicesImpl jobSeekerAcademicServicesImpl;

    @Autowired
    private JobSeekerPersonalServicesImpl jobSeekerPersonalServicesImpl;

    @Autowired
    private JobSeekerProfessionalServicesImpl jobSeekerProfessionalServicesImpl;

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    // JobSeeker Registration control is already taken care of in UserRegController.
    // JobSeeker Login control is already taken care of in UserLoginController.

    @PutMapping("/jobseekers/personal/update")
	public String updateJobSeekerPersonalDetails(@RequestParam("uname") String username, @RequestParam("name") String name, @RequestParam("dob") Date dob, @RequestParam("mobile") long mobile)
	{
		try
		{
			if (jobSeekerPersonalServicesImpl.findJobSeekerByUsername(username) != null)
			{
				JobSeekerPersonal jobSeekerPersonalUpdated = new JobSeekerPersonal();
				jobSeekerPersonalUpdated.setName(name);
				jobSeekerPersonalUpdated.setMobile(mobile);
				jobSeekerPersonalUpdated.setDob(dob);
				jobSeekerPersonalServicesImpl.update(jobSeekerPersonalUpdated);
				System.err.println("Debug: JobSeeker personal details successfully updated.");
				return "jobseeker_home";
			}
			else
			{
				System.err.println("Debug: No such jobseeker with username: " + username + " exists in the database!");
				return "jobSeekers/personal/update";
			}
		}
		catch (Exception jsexc)
		{
			jsexc.printStackTrace();
		}
		return "errorPage";
	}
	
	@PutMapping("/jobseekers/academic/update")
	public String updateJobSeekerAcademicDetails(@RequestParam("uname") String username, @RequestParam("sscYear") int sscYear, @RequestParam("sscPercent") double sscPercent, @RequestParam("hscYear") int hscYear, @RequestParam("hscPercent") double hscPercent, @RequestParam("qualification") String qualification, @RequestParam("qualificationYear") int qualificationYear, @RequestParam("cgpa") double cgpa, @RequestParam("summary") String summary)
    {
        try
        {
            if (jobSeekerAcademicServicesImpl.findJobSeekerAcademicByUsername(username) != null)
            {
                JobSeekerAcademic jobSeekerAcademicUpdated = new JobSeekerAcademic();
                jobSeekerAcademicUpdated.setSscYear(sscYear);
                jobSeekerAcademicUpdated.setSscPercent(sscPercent);
                jobSeekerAcademicUpdated.setHscYear(hscYear);
                jobSeekerAcademicUpdated.setHscPercent(hscPercent);
                jobSeekerAcademicUpdated.setQualification(qualification);
                jobSeekerAcademicUpdated.setQualificationYear(qualificationYear);
                jobSeekerAcademicUpdated.setCgpa(cgpa);
                jobSeekerAcademicUpdated.setSummary(summary);
                jobSeekerAcademicServicesImpl.update(jobSeekerAcademicUpdated);
                System.err.println("Debug: JobSeeker academic details have successfully updated.");
				return "jobseeker_home";
			}
			else
			{
				System.err.println("Debug: No such jobseeker with username: " + username + " exists in the database!");
				return "jobSeekers/academic/update";
			}
		}
		catch (Exception jsexc)
		{
			jsexc.printStackTrace();
		}
		return "errorPage";
    }

    @PutMapping("/jobSeekers/professional/update")
    public String updateJobSeekerProfessionalDetails(@RequestParam("uname") String username, @RequestParam("lastRole") String lastRole, @RequestParam("fromDateLastRole") Date fromDateLastRole, @RequestParam("toDateLastRole") Date toDateLastRole, @RequestParam("skillset") String skillset, @RequestParam("resume") Blob resume)
    {
        try
        {
            if (jobSeekerProfessionalServicesImpl.findJobSeekerProfessionalByUsername(username) != null)
            {
                JobSeekerProfessional jobSeekerProfessionalUpdated = new JobSeekerProfessional();
                jobSeekerProfessionalUpdated.setLastRole(lastRole);
                jobSeekerProfessionalUpdated.setFromDateLastRole(fromDateLastRole);
                jobSeekerProfessionalUpdated.setToDateLastRole(toDateLastRole);
                jobSeekerProfessionalUpdated.setSkillset(skillset);
                jobSeekerProfessionalUpdated.setResume(resume);
                jobSeekerProfessionalServicesImpl.update(jobSeekerProfessionalUpdated);
                System.err.println("Debug: JobSeeker professional details have successfully updated.");
                return "jobseeker_home";
            }
            else
            {
                System.err.println("Debug: No such jobseeker with username: " + username + " exists in the database!");
                return "jobSeekers/professional/update";
            }
        }
		catch (Exception jsexc)
		{
			jsexc.printStackTrace();
		}
		return "errorPage";
    }

    @DeleteMapping("/jobSeekers/delete")
    public String deleteJobSeekerAccount(@RequestBody Login login, @RequestBody JobSeekerAcademic jobSeekerAcademic, @RequestBody JobSeekerPersonal jobSeekerPersonal, @RequestBody JobSeekerProfessional jobSeekerProfessional) 
    {
        try
        {
            if (loginServiceImpl.validateUser(login) && login.getRoleType().equals("JSK"))
            {
                System.err.println("Debug: Job Seeker credentials verified. Proceeding to account deletion...");
				jobSeekerAcademicServicesImpl.remove(jobSeekerAcademic);
                jobSeekerPersonalServicesImpl.remove(jobSeekerPersonal);
                jobSeekerProfessionalServicesImpl.remove(jobSeekerProfessional);
				loginServiceImpl.removeUser(login);
				System.err.println("Debug: Job Seeker account has been deleted successfully.");
                return "jobcentral_home";
			}
            else
            {
                System.err.println("Debug: JobSeeker has entered invalid credentials.");
                return "jobSeekers/delete";
            }
		}
		catch (ServiceException svcEx)
		{
			svcEx.printStackTrace();
		}
		return "errorPage";
    }

    @GetMapping("/jobseekers/count")
    public long findJobSeekerCount()
    {
        try 
        {
            return jobSeekerPersonalServicesImpl.findAllJobSeekerPersonalDetails().size();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @GetMapping("jobseekers/details/all")
    public List<JobSeekerPersonal> findAllJobSeekersPersonalDetails()
    {
		try
		{
			return jobSeekerPersonalServicesImpl.findAllJobSeekerPersonalDetails();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		return null;
    }

    @GetMapping("jobseekers/details/all")
    public List<JobSeekerAcademic> findAllJobSeekersAcademicDetails()
    {
		try
		{
			return jobSeekerAcademicServicesImpl.findAllJobSeekerAcademicDetails();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		return null;
    }

    @GetMapping("jobseekers/details/all")
    public List<JobSeekerProfessional> findAllJobSeekersProfessionalDetails()
    {
		try
		{
			return jobSeekerProfessionalServicesImpl.findAllJobSeekerProfessionalDetails();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		return null;
    }

}
