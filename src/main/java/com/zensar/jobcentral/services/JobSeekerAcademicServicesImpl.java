package com.zensar.jobcentral.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.jobcentral.daos.JobSeekerAcademicDao;
import com.zensar.jobcentral.entities.JobSeekerAcademic;

@Service
@Transactional
public class JobSeekerAcademicServicesImpl implements JobSeekerAcademicServices {

	@Autowired
    private JobSeekerAcademicDao jobSeekerAcademicDao;

    @Override
    public void add(JobSeekerAcademic jobSeekerAcademic) {
        // TODO Auto-generated method stub
        jobSeekerAcademicDao.insert(jobSeekerAcademic);
    }

    @Override
    public void update(JobSeekerAcademic jobSeekerAcademic) {
        // TODO Auto-generated method stub
        jobSeekerAcademicDao.update(jobSeekerAcademic);
    }

    @Override
    public void remove(JobSeekerAcademic jobSeekerAcademic) {
        // TODO Auto-generated method stub
        jobSeekerAcademicDao.delete(jobSeekerAcademic);
    }

    @Override
    public List<JobSeekerAcademic> findAllJobSeekerAcademicDetails() {
        // TODO Auto-generated method stub
        return jobSeekerAcademicDao.getAll();
    }

	

}
