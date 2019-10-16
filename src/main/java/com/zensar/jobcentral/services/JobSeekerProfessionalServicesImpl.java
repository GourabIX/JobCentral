package com.zensar.jobcentral.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.zensar.jobcentral.daos.JobSeekerProfessionalDao;
import com.zensar.jobcentral.entities.JobSeekerProfessional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JobSeekerProfessionalServicesImpl implements JobSeekerProfessionalServices {

    private JobSeekerProfessionalDao jobSeekerProfessionalDao;

    @Override
    public void add(JobSeekerProfessional jobSeekerProfessional) {
        // TODO Auto-generated method stub
        jobSeekerProfessionalDao.insert(jobSeekerProfessional);
    }

    @Override
    public void update(JobSeekerProfessional jobSeekerProfessional) {
        // TODO Auto-generated method stub
        jobSeekerProfessionalDao.update(jobSeekerProfessional);
    }

    @Override
    public void remove(JobSeekerProfessional jobSeekerProfessional) {
        // TODO Auto-generated method stub
        jobSeekerProfessionalDao.delete(jobSeekerProfessional);
    }

    @Override
    public JobSeekerProfessional findJobSeekerProfessionalByUsername(String username) {
        // TODO Auto-generated method stub
    	return jobSeekerProfessionalDao.getByUserName(username);
    }

    @Override
    public List<JobSeekerProfessional> findAllJobSeekerProfessional() {
        // TODO Auto-generated method stub
        return jobSeekerProfessionalDao.getAll();
    }

}
