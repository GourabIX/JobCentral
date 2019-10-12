package com.zensar.jobcentral.services;

import java.util.List;

/**
 * @author Gourab Sarkar
 * @modification_date 11 Oct 2019 20:57
 * @creation_date 08 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Employer Service class which implements the EmployerService interface and is a part of Business layer of the application.
 */

import com.zensar.jobcentral.daos.EmployerDao;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.EmployerException;
import com.zensar.jobcentral.exceptions.LoginException;

public class EmployerServiceImpl implements EmployerService {

	private EmployerDao employerDao;
	
	public EmployerDao getEmployerDao() throws EmployerException{
		return employerDao;
	}

	@Override
	public void setEmployerDao(EmployerDao employerDao) throws EmployerException {
		this.employerDao = employerDao;
	}

	@Override
	public boolean validateUser(Login loginAuth) throws EmployerException, LoginException {
		
		Login dbEmployer = getEmployerCredentialsByUsername(loginAuth.getUsername());
		
		if (dbEmployer != null)
		{
			if (dbEmployer.getPassword().equals(loginAuth.getPassword()))
			{
				System.out.println("Debug: Credentials checks out. User login is successful.");
				return true;
			}
		}
		else
		{
			System.out.println("Debug: No such user found.");
		}
		
		return false;
	}

	@Override
	public void addEmployer(Employer employer) throws EmployerException {
		
	}

	@Override
	public void updateEmployer(Employer employer) throws EmployerException {
		
	}

	@Override
	public void removeEmployer(Employer employer) throws EmployerException {
		
	}

	@Override
	public Employer getEmployerByUsername(String username) throws EmployerException {
		return null;
	}

	@Override
	public Employer getEmployerByUserId(int userId) throws EmployerException {
		return null;
	}

	@Override
	public Login getEmployerCredentialsByUsername(String username) throws LoginException {
		return null;
	}

	@Override
	public List<Employer> findAllEmployers() throws EmployerException {
		return null;
	}

	@Override
	public void getEmployerDao(EmployerDao employerDao) throws EmployerException {
		// TODO Auto-generated method stub
		
	}

}
