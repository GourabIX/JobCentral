package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.JobSeekerPersonal;
import com.zensar.jobcentral.entities.Login;
/**
 * @author Sushma Kumari
 * @creation_date 15 Oct 2019 02:32 PM
 * @version 1.0
 * @modification_date 15 Oct 2019 02:42 PM
 * @copyright All rights are reserver by Zensar.
 * @description It is JobSeeker Dao class.
 * 				It is used in Persistence layer.
 * 		
 */
public interface JobSeekerPersonalDao {
	void insert(JobSeekerPersonal jobSeekerPersonal);
	void update(JobSeekerPersonal jobSeekerPersonal);
	void delete(JobSeekerPersonal jobSeekerPersonal);
	JobSeekerPersonal getById(int jobSeekerId);
	Login getByUsername(String username);
	List<JobSeekerPersonal> getAllJobSeekersPersonalDetails();
	

}
