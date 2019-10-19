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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.jobcentral.entities.Company;
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
	public String updateEmployer(@RequestParam("uname") String username, @RequestParam("name") String name,
			@RequestParam("contact") long contact, @RequestParam("designation") String designation,
			@RequestParam("companyName") String companyName) 
	{
		try 
		{
			Employer employer = new Employer();
			employer.setName(name);
			employer.setContact(contact);
			employer.setDesignation(designation);

			Company company = new Company();
			if (companyService.findCompanyByName(companyName) != null) 
			{
				company = companyService.findCompanyByName(companyName);
			} 
			else 
			{
				company.setCompanyName(companyName);
				company.setLocations(null);
				company.setJobs(null);
				companyService.insertCompany(company);
			}

			employer.setCompany(company);
			employerService.updateEmployer(employer);
			System.err.println("Debug: Employer details have been updated successfully.");
			return "employer_home";
		} 
		catch (EmployerException empEx) 
		{
			empEx.printStackTrace();
			System.err.println("Something went wrong with updating employer with username: " + username);
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
	public String removeEmployerAccount(@RequestParam("uname") String username, @RequestParam("passwd") String password) 
	{
		try {
			if (loginService.findUserByUsername(username) != null && (loginService.findUserByUsername(username).getRoleType().equals("EMP") || loginService.findUserByUsername(username).getRoleType().equals("TMP"))) 
			{
				if (loginService.validateUser(loginService.findUserByUsername(username))) 
				{
					System.err.println("Debug: Employer credentials verified. Proceeding to account deletion...");
					employerService.removeEmployer(loginService.findUserByUsername(username).getUserId());
					loginService.removeUser(loginService.findUserByUsername(username));
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
				System.err.println("No such employer with username: " + username + " exists.");
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