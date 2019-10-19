package com.zensar.jobcentral.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.jobcentral.entities.JobSeekerPersonal;
import com.zensar.jobcentral.entities.Login;

/**
 * @author Sushma Kumari
 * @creation_date 15 Oct 2019 02:32 PM
 * @version 1.0
 * @modification_date 15 Oct 2019 02:42 PM
 * @copyright All rights are reserver by Zensar.
 * @description It is JobSeeker Dao Implementation class.
 * 				It is used in Persistence layer.
 * 		
 */
@Repository
public class JobSeekerPersonalDaoImpl implements JobSeekerPersonalDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void insert(JobSeekerPersonal jobSeekerPersonal) {
        // TODO Auto-generated method stub
        hibernateTemplate.save(jobSeekerPersonal);
    }

    @Override
    public void update(JobSeekerPersonal jobSeekerPersonal) {
        // TODO Auto-generated method stub
        hibernateTemplate.saveOrUpdate(jobSeekerPersonal);
    }

    @Override
    public void delete(JobSeekerPersonal jobSeekerPersonal) {
        // TODO Auto-generated method stub
        hibernateTemplate.delete(jobSeekerPersonal);
    }

	@Override
	public JobSeekerPersonal getById(int jobSeekerId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(JobSeekerPersonal.class, jobSeekerId);
	}

	@Override
	public Login getByUsername(String username) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Login.class, username);
	}

	@Override
	public List<JobSeekerPersonal> getAllJobSeekersPersonalDetails() {
		// TODO Auto-generated method stub
		return (List<JobSeekerPersonal>) hibernateTemplate.find("from JobSeekerPersonal");
	}
	

	
}