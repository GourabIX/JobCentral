package com.zensar.jobcentral.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.jobcentral.entities.JobSeeker;

@Repository
public class JobSeekerDaoImpl implements JobSeekerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(JobSeeker jobSeeker) {
		hibernateTemplate.save(jobSeeker);
	}

	@Override
	public void update(JobSeeker jobSeeker) {
		hibernateTemplate.saveOrUpdate(jobSeeker);
	}

	@Override
	public void delete(JobSeeker jobSeeker) {
		hibernateTemplate.delete(jobSeeker);
	}

	@Override
	public List<JobSeeker> getAllJobSeekers() {
		return (List<JobSeeker>) hibernateTemplate.find("from JobSeeker");
	}

	@Override
	public JobSeeker getJobSeekerById(int jobSeekerId) {
		return hibernateTemplate.get(JobSeeker.class, jobSeekerId);
	}


}
