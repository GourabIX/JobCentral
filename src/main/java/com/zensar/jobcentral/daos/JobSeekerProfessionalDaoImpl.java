package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.JobSeekerProfessional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Sushma Kumari
 * @creation_date 15 Oct 2019 02:32 PM
 * @version 1.0
 * @modification_date 15 Oct 2019 02:42 PM
 * @copyright All rights are reserver by Zensar.
 * @description It is JobSeeker Dao Implementation class. It is used in
 *              Persistence layer.
 * 
 */
@Repository
public class JobSeekerProfessionalDaoImpl implements JobSeekerProfessionalDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void insert(JobSeekerProfessional jobSeekerProfessional) {
        // TODO Auto-generated method stub
        hibernateTemplate.save(jobSeekerProfessional);
    }

    @Override
    public void update(JobSeekerProfessional jobSeekerProfessional) {
        // TODO Auto-generated method stub
        hibernateTemplate.saveOrUpdate(jobSeekerProfessional);
    }

    @Override
    public void delete(JobSeekerProfessional jobSeekerProfessional) {
        // TODO Auto-generated method stub
        hibernateTemplate.delete(jobSeekerProfessional);
    }

    @Override
    public List<JobSeekerProfessional> getAll() {
        // TODO Auto-generated method stub
        return (List<JobSeekerProfessional>) hibernateTemplate.find("from JobSeekerProfessional");
    }

    @Override
    public JobSeekerProfessional getByUserName(String username) {
        // TODO Auto-generated method stub
        return hibernateTemplate.get(JobSeekerProfessional.class, username);
    }
	

	
}