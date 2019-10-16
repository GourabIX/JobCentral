package com.zensar.jobcentral.services;

import java.util.List;
import com.zensar.jobcentral.services.JobService;
import com.zensar.jobcentral.daos.JobDao;
import com.zensar.jobcentral.entities.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author: Chaithrodaya B S
 * @creation_date: 4th Oct 2019 10.05 AM
 * @modification_date: 15th Oct 2019 7.55 PM
 * @version: 3.0
 * @copyright Zensar Technologies. All Rights Reserved
 * @description: It is a  CompanyService Implementation used in business layer.
 * 				
 *
 */

@Service
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDao;

    @Override
	public List<Job> getAllJobs() {
	
		List<Job> list = jobDao.getAllJobs();
		return list;
	}

	@Override
	public Job getByJobId(int jobId) {
		
		return jobDao.getByJobId(jobId);
		
	}

    @Override
	public Job getByJobCategory(String category) {
		
		return jobDao.getByCategory(category);
		
	}

    @Override
	public Job getByJobLocation(int locationId) {
		
		return jobDao.getByLocation(locationId);
		
	}

	@Override
	public void insertJob(Job job) {
		
        jobDao.insertJobs(job);
        System.out.println("Job "+job.getJobId()+" is Inserted");

	}

	@Override
	public void updateJob(Job job) {
	
        jobDao.updateJobs(job);
        System.out.println("Job "+job.getJobId()+" is Updated");

	}

	@Override
	public void deleteJob(Job job) {
	
        jobDao.deleteJobs(job);
        System.out.println("Job "+job.getJobId()+" is Deleted");

	}
}