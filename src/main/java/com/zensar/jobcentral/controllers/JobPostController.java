package com.zensar.jobcentral.controllers;

import java.sql.Clob;
import java.util.List;

import com.zensar.jobcentral.entities.Job;
import com.zensar.jobcentral.entities.Location;
import com.zensar.jobcentral.services.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Chaithrodaya BS
 * @modification_date 16 Oct 2019 11.35
 * @creation_date 16 Oct 2019 11.35
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the User Login Controller class which is a part of Business layer of the application.
 */

 @RestController
 public class JobPostController
 {
     
     @Autowired
        private JobServiceImpl jobServiceImpl;

      

     @PostMapping("/jobs/postjob")
     public String postJob( @RequestParam("jobname") String jobName,  @RequestParam("jobtype") String jobType, @RequestParam("noofvacancies") int numberofVacancies, @RequestParam("jobdesc") Clob jobDescription,  @RequestParam("jobskills") String skillsRequired, @RequestParam("joblocation") String state, @RequestParam("joblocation") String city ) 
     {
       
        Job job = new Job();
        job.setJobName(jobName);
        job.setJobType(jobType);
        job.setNumberOfVacancies(numberofVacancies);
        job.setJobDescription(jobDescription);
        job.setSkillsRequired(skillsRequired);
        Location location = new Location();
        location.setCity(city);
        location.setState(state);
        job.setLocation(location);
        jobServiceImpl.insertJob(job);
     
        return "employer_home";


     }
     @PostMapping("/jobs/deletejobpost")
     public String deleteJob(@RequestParam("jobId") int jobId) 
     {
       try
       {
            if(jobServiceImpl.getByJobId(jobId) != null)
            {
                jobServiceImpl.deleteJob(jobServiceImpl.getByJobId(jobId));
            }

            else
            {
                 System.err.println("Debug: No such jobpost exists.Selected post cannot be deleted");
                 return "employer_home";
            }

        }
            
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return "errorPage";
      
     }
     @PostMapping("/jobs/updatejobpost")
     public String updateJob(@RequestParam("jobId") int jobId, @RequestParam("jobname") String jobName,  @RequestParam("jobtype") String jobType, @RequestParam("noofvacancies") int numberofVacancies, @RequestParam("jobdesc") Clob jobDescription,  @RequestParam("jobskills") String skillsRequired, @RequestParam("state") String state, @RequestParam("city") String city ) 
     {
       try
       {
            if(jobServiceImpl.getByJobId(jobId) != null)
            {
                Job job = new Job();
                job.setJobName(jobName);
                job.setJobType(jobType);
                job.setNumberOfVacancies(numberofVacancies);
                job.setJobDescription(jobDescription);
                job.setSkillsRequired(skillsRequired);
                Location location = new Location();
                location.setCity(city);
                location.setState(state);
                job.setLocation(location);
                jobServiceImpl.updateJob(jobServiceImpl.getByJobId(jobId));
            }
            else
            {
                 System.err.println("Debug: No such jobpost exists.Selected post cannot be updated");
                 return "employer_home";
            }

        }
            
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return "errorPage";
      
     }
     
     @PostMapping("/jobs/getalljobposts")
     public List<Job> getAllJob()  
     {
        try
        {
            jobServiceImpl.getAllJobs();
        }
       catch (Exception e) 
       {
            e.printStackTrace();
       }
       return null;
      
     }
        

 }