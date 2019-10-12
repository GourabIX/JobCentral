package com.zensar.jobcentral.services;

import java.util.List;

/**
 * @author Gourab Sarkar
 * @modification_date 08 Oct 2019 00:26
 * @creation_date 08 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Employer Service interface which is a part of Business layer of the application.
 */

import com.zensar.jobcentral.daos.EmployerDao;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.EmployerException;
import com.zensar.jobcentral.exceptions.LoginException;

public interface EmployerService {

	void setEmployerDao(EmployerDao employerDao) throws EmployerException;
	void getEmployerDao(EmployerDao employerDao) throws EmployerException;
	Login getEmployerCredentialsByUsername(String username) throws LoginException;
	boolean validateUser(Login loginAuth) throws EmployerException, LoginException;
	
	void addEmployer(Employer employer) throws EmployerException;
	void updateEmployer(Employer employer) throws EmployerException;
	void removeEmployer(Employer employer) throws EmployerException;
	Employer getEmployerByUsername(String username) throws EmployerException;
	Employer getEmployerByUserId(int userId) throws EmployerException;
	List<Employer> findAllEmployers() throws EmployerException;

}
