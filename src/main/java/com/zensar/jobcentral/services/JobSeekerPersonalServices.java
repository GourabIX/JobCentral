package com.zensar.jobcentral.services;

import com.zensar.jobcentral.daos.JobSeekerPersonalDao;
import org.springframework.transaction.annotation.Transactional;
import com.zensar.jobcentral.entities.JobSeekerPersonal;
import com.zensar.jobcentral.entities.Login;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class JobSeekerPersonalServices implements JobSeekerPersonalService {

	private JobSeekerPersonalDao jobSeekerPersonalDao;

    @Override
    public void add(JobSeekerPersonal jobSeekerPersonal) {
        // TODO Auto-generated method stub
        jobSeekerPersonalDao.insert(jobSeekerPersonal);
    }

    @Override
    public void update(JobSeekerPersonal jobSeekerPersonal) {
        // TODO Auto-generated method stub
        jobSeekerPersonalDao.update(jobSeekerPersonal);
    }

    @Override
    public void remove(JobSeekerPersonal jobSeekerPersonal) {
        // TODO Auto-generated method stub
        jobSeekerPersonalDao.delete(jobSeekerPersonal);
    }

	@Override
	public Login findJobSeekerByUsername(String username) {
		// TODO Auto-generated method stub
		return jobSeekerPersonalDao.getByUsername(username);
	}
	
	public List<JobSeekerPersonal> findAllJobSeekerPersonalDetails() 
	{
		return jobSeekerPersonalDao.getAllJobSeekersPersonalDetails();
	}

	@Override
	public JobSeekerPersonal findJobSeekerById(int jobSeekerId) {
		return jobSeekerPersonalDao.getById(jobSeekerId);
	}
	

}
