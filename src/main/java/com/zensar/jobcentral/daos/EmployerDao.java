package com.zensar.jobcentral.daos;

/**
 * @author Priya Mirchandani, Gourab Sarkar
 * @modification_date 12 Oct 2019 11:33
 * @creation_date 04 Oct 2019 10:08
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the Employer DAO interface used in the persistence layer.
 */

import java.util.List;

import com.zensar.jobcentral.entities.Employer;

public interface EmployerDao
{
	List<Employer> getAllEmployers();
	Employer getById(int userId);
	void insert(Employer employer);
	void update(Employer employer) ;
	void delete(Employer employer);
}
