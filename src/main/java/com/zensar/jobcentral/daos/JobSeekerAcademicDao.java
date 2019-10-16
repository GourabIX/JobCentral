package com.zensar.jobcentral.daos;

import java.util.List;


import com.zensar.jobcentral.entities.JobSeekerAcademic;
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
public interface JobSeekerAcademicDao {
	void insert(JobSeekerAcademic jobSeekerAcademic);
	void update(JobSeekerAcademic jobSeekerAcademic);
	void delete(JobSeekerAcademic jobSeekerAcademic);
	List<JobSeekerAcademic> getAll();
	JobSeekerAcademic getByUserName(String username);

}
