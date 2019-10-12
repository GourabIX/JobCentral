package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Job;

public interface JobDao {

	List <Job>getAll();
	Job getById(int jobId);
	Job getByCategory(String category);
	Job getByLocation(int locationId);
	void insert(Job job);
	void update(Job job);
	void delete(Job job);
}
