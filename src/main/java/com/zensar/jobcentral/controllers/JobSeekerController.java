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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.jobcentral.entities.JobSeeker;
import com.zensar.jobcentral.entities.JobSeekerAcademic;
import com.zensar.jobcentral.entities.JobSeekerPersonal;
import com.zensar.jobcentral.entities.JobSeekerProfessional;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.ServiceException;
import com.zensar.jobcentral.services.JobSeekerAcademicServices;
import com.zensar.jobcentral.services.JobSeekerPersonalServices;
import com.zensar.jobcentral.services.JobSeekerProfessionalServices;
import com.zensar.jobcentral.services.JobSeekerService;
import com.zensar.jobcentral.services.LoginService;

@RestController
public class JobSeekerController 
{

    @Autowired
    private JobSeekerAcademicServices jobSeekerAcademicServices;

    @Autowired
    private JobSeekerPersonalServices jobSeekerPersonalServices;

    @Autowired
    private JobSeekerProfessionalServices jobSeekerProfessionalServices;
    
    @Autowired
    private JobSeekerService jobSeekerService;

    @Autowired
    private LoginService loginService;

    // JobSeeker Registration control is already taken care of in UserRegController.
    // JobSeeker Login control is already taken care of in UserLoginController.

    @PutMapping(value = "/jobseekers/personal/update")
	public String updateJobSeekerPersonalDetails(@RequestParam("uname") String username, @RequestParam("name") String name, @RequestParam("dob") @DateTimeFormat(iso = ISO.DATE) Date dob, @RequestParam("mobile") long mobile)
	{
		try
		{
			if (jobSeekerPersonalServices.findJobSeekerByUsername(username) != null)
			{
				JobSeekerPersonal jobSeekerPersonalUpdated = new JobSeekerPersonal();
				jobSeekerPersonalUpdated.setName(name);
				jobSeekerPersonalUpdated.setMobile(mobile);
				jobSeekerPersonalUpdated.setDob(dob);
				jobSeekerPersonalServices.update(jobSeekerPersonalUpdated);
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
	
	@PutMapping(value = "/jobseekers/academic/update")
	public String updateJobSeekerAcademicDetails(@RequestParam("uname") String username, @RequestParam("sscYear") int sscYear, @RequestParam("sscPercent") double sscPercent, @RequestParam("hscYear") int hscYear, @RequestParam("hscPercent") double hscPercent, @RequestParam("qualification") String qualification, @RequestParam("qualificationYear") int qualificationYear, @RequestParam("cgpa") double cgpa, @RequestParam("summary") String summary)
    {
        try
        {
            if (jobSeekerAcademicServices.findJobSeekerAcademicByUsername(username) != null)
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
                jobSeekerAcademicServices.update(jobSeekerAcademicUpdated);
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

    @PutMapping(value = "/jobSeekers/professional/update")
    public String updateJobSeekerProfessionalDetails(@RequestParam("uname") String username, @RequestParam("lastRole") String lastRole, @RequestParam("fromDateLastRole") Date fromDateLastRole, @RequestParam("toDateLastRole") Date toDateLastRole, @RequestParam("skillset") String skillset, @RequestParam("resume") Blob resume)
    {
        try
        {
            if (jobSeekerProfessionalServices.findJobSeekerProfessionalByUsername(username) != null)
            {
                JobSeekerProfessional jobSeekerProfessionalUpdated = new JobSeekerProfessional();
                jobSeekerProfessionalUpdated.setLastRole(lastRole);
                jobSeekerProfessionalUpdated.setFromDateLastRole(fromDateLastRole);
                jobSeekerProfessionalUpdated.setToDateLastRole(toDateLastRole);
                jobSeekerProfessionalUpdated.setSkillset(skillset);
                jobSeekerProfessionalUpdated.setResume(resume);
                jobSeekerProfessionalServices.update(jobSeekerProfessionalUpdated);
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
            if (loginService.validateUser(login) && login.getRoleType().equals("JSK"))
            {
                System.err.println("Debug: Job Seeker credentials verified. Proceeding to account deletion...");
				jobSeekerAcademicServices.remove(jobSeekerAcademic);
                jobSeekerPersonalServices.remove(jobSeekerPersonal);
                jobSeekerProfessionalServices.remove(jobSeekerProfessional);
				loginService.removeUser(login);
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
            return jobSeekerPersonalServices.findAllJobSeekerPersonalDetails().size();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @GetMapping("/jobseekers/details/personal")
    public List<JobSeekerPersonal> findAllJobSeekersPersonalDetails()
    {
		try
		{
			return jobSeekerPersonalServices.findAllJobSeekerPersonalDetails();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		return null;
    }

    @GetMapping(value = "/jobseekers/details/academic")
    public List<JobSeekerAcademic> findAllJobSeekersAcademicDetails()
    {
		try
		{
			return jobSeekerAcademicServices.findAllJobSeekerAcademicDetails();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		return null;
    }

    @GetMapping("/jobseekers/details/professional")
    public List<JobSeekerProfessional> findAllJobSeekersProfessionalDetails()
    {
		try
		{
			return jobSeekerProfessionalServices.findAllJobSeekerProfessionalDetails();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		return null;
    }
    
    @GetMapping("/jobseekers/details/all")
    public List<JobSeeker> findAllJobSeekers() 
    {
    	try
    	{
    		return jobSeekerService.findAllJobSeekers();
    	}
    	catch (Exception exc)
    	{
    		exc.printStackTrace();
    	}
    	return null;
	}
    
    @GetMapping("/jobseekers/details/individual")
    public JobSeeker findJobSeekerCompleteDetails(String username)
    {
    	try
    	{
    		return jobSeekerService.findJobSeekerByUsername(username);
    	}
    	catch (Exception exc)
    	{
    		exc.printStackTrace();
    	}
    	return null;
    }

}
