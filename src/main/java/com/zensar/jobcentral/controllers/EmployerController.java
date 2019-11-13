package com.zensar.jobcentral.controllers;

/**
 * @author Gourab Sarkar
 * @modification_date 16 Oct 2019 06:01
 * @creation_date 16 Oct 2019 06:01
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Employer Controller class which is a part of Business layer of the application.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.exceptions.EmployerException;
import com.zensar.jobcentral.exceptions.ServiceException;
import com.zensar.jobcentral.services.CompanyService;
import com.zensar.jobcentral.services.EmployerService;
import com.zensar.jobcentral.services.LoginService;

@RestController
public class EmployerController {

	@Autowired
	EmployerService employerService;

	@Autowired
	CompanyService companyService;

	@Autowired
	LoginService loginService;

	// Employer Registration control is already taken care of in UserRegController.
	// Employer Login control is already taken care of in UserLoginController.

	@PutMapping("/employers/update")
	public String updateEmployer(@RequestBody Employer employer) 
	{
		try 
		{
			if (employer.getLogin().equals(employerService.findEmployerByUsername(employer.getLogin().getUsername()).getLogin()))
			{
				employerService.updateEmployer(employer);
				System.err.println("Debug: Employer details have been updated successfully.");
				return "employer_home";
			}
		}
		catch (EmployerException empEx) 
		{
			empEx.printStackTrace();
			System.err.println("Something went wrong with updating employer with username: " + employer.getLogin().getUsername());
		}
		return "errorPage";
	}

	@GetMapping("/employers/allEmployers")
	public List<Employer> findAllEmployers() 
	{
		try 
		{
			return employerService.findAllEmployers();
		} 
		catch (EmployerException empEx) 
		{
			empEx.printStackTrace();
		}
		return null;
	}

	@GetMapping("/employers/count")
	public long findEmployerCount() 
	{
		try {
			return employerService.getEmployerCount();
		} 
		catch (EmployerException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@DeleteMapping("/employers/deleteEmployer")
	public String removeEmployerAccount(@RequestBody Employer employer) 
	{
		try {
			if (loginService.findUserByUsername(employer.getLogin().getUsername()) != null && (loginService.findUserByUsername(employer.getLogin().getUsername()).getRoleType().equals("EMP") || loginService.findUserByUsername(employer.getLogin().getUsername()).getRoleType().equals("TMP"))) 
			{
				if (loginService.validateUser(loginService.findUserByUsername(employer.getLogin().getUsername()))) 
				{
					System.err.println("Debug: Employer credentials verified. Proceeding to account deletion...");
					employerService.removeEmployer(loginService.findUserByUsername(employer.getLogin().getUsername()).getUserId());
					loginService.removeUser(loginService.findUserByUsername(employer.getLogin().getUsername()));
					System.err.println("Debug: Employer account has been deleted successfully.");
					return "jobcentral_home";
				} 
				else 
				{
					System.err.println("Debug: Employer has entered invalid credentials.");
					return "employers/deleteEmployer";
				}
			} 
			else 
			{
				System.err.println("No such employer with username: " + employer.getLogin().getUsername() + " exists.");
				return "errorPage";
			}
		} 
		catch (EmployerException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e) 
		{
			e.printStackTrace();
		}
		return "errorPage";
	}

}