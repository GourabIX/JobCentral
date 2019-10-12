package com.zensar.jobcentral.services;

/**
 * @author Gourab Sarkar
 * @modification_date 11 Oct 2019 20:57
 * @creation_date 08 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Employer Service class which implements the EmployerService interface and is a part of Business layer of the application.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.jobcentral.daos.EmployerDao;
import com.zensar.jobcentral.daos.LoginDao;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.EmployerException;
import com.zensar.jobcentral.exceptions.LoginException;

@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	private EmployerDao employerDao;
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean validateUser(Login loginAuth) throws EmployerException, LoginException 
	{
		Login dbEmployer = findEmployerCredentialsByUsername(loginAuth.getUsername());
		
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
	public void addEmployer(Employer employer) throws EmployerException 
	{
		employerDao.insertEmployer(employer);
	}

	@Override
	public void updateEmployer(Employer employer) throws EmployerException 
	{
		employerDao.updateEmployer(employer);
	}

	@Override
	public void removeEmployer(int employerId) throws EmployerException 
	{
		employerDao.deleteEmployer(employerId);
	}

	@Override
	public Employer findEmployerByUsername(String username) throws EmployerException 
	{
		return employerDao.getEmployerByUsername(username);
	}

	@Override
	public Login findEmployerCredentialsByUsername(String username) throws LoginException 
	{
		Employer employer = employerDao.getEmployerByUsername(username);
		return loginDao.getUserById(employer.getEmployerId());
	}

	@Override
	public List<Employer> findAllEmployers() throws EmployerException 
	{
		List<Employer> listOfAllEmployers = employerDao.getAllEmployers();
		return listOfAllEmployers;
	}

	@Override
	public long getEmployerCount() throws EmployerException 
	{
		List<Employer> listOfAllEmployers = findAllEmployers();
		return listOfAllEmployers.size();
	}

	@Override
	public Employer findEmployerById(int employerId) throws EmployerException 
	{
		return employerDao.getEmployerById(employerId);
	}

}
