package com.zensar.jobcentral.services;

/**
 * @author Gourab Sarkar
 * @modification_date 08 Oct 2019 00:26
 * @creation_date 08 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Employer Service interface which is a part of Business layer of the application.
 */

import java.util.List;

import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.EmployerException;
import com.zensar.jobcentral.exceptions.LoginException;

public interface EmployerService {

	Login findEmployerCredentialsByUsername(String username) throws LoginException;
	boolean validateUser(Login loginAuth) throws EmployerException, LoginException;
	void addEmployer(Employer employer) throws EmployerException;
	void updateEmployer(Employer employer) throws EmployerException;
	void removeEmployer(int employerId) throws EmployerException;
	Employer findEmployerByUsername(String username) throws EmployerException;
	Employer findEmployerById(int employerId) throws EmployerException;
	List<Employer> findAllEmployers() throws EmployerException;
	long getEmployerCount() throws EmployerException;

}
