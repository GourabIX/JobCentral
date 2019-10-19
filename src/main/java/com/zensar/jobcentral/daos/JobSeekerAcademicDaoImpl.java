package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.JobSeekerAcademic;

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
public class JobSeekerAcademicDaoImpl implements JobSeekerAcademicDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void insert(JobSeekerAcademic jobSeekerAcademic) {
        // TODO Auto-generated method stub
        hibernateTemplate.save(jobSeekerAcademic);
    }

    @Override
    public void update(JobSeekerAcademic jobSeekerAcademic) {
        // TODO Auto-generated method stub
        hibernateTemplate.update(jobSeekerAcademic);
    }

    @Override
    public void delete(JobSeekerAcademic jobSeekerAcademic) {
        // TODO Auto-generated method stub
        hibernateTemplate.delete(jobSeekerAcademic);
    }

    @Override
    public List<JobSeekerAcademic> getAll() {
        // TODO Auto-generated method stub
        return (List<JobSeekerAcademic>) hibernateTemplate.find("from JobSeeker");
    }

    @Override
    public JobSeekerAcademic getByUserName(String username) {
        // TODO Auto-generated method stub
        return hibernateTemplate.get(JobSeekerAcademic.class, username);
    }

   
	

	
}