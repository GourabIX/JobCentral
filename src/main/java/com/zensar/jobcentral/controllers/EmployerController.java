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
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.EmployerException;
import com.zensar.jobcentral.exceptions.LoginException;
import com.zensar.jobcentral.exceptions.ServiceException;
import com.zensar.jobcentral.services.CompanyServiceImpl;
import com.zensar.jobcentral.services.EmployerServiceImpl;
import com.zensar.jobcentral.services.LoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployerController
{

    @Autowired
    EmployerServiceImpl employerServiceImpl;

    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @Autowired
    LoginServiceImpl loginServiceImpl;

    // Employer Registration control is already taken care of in UserRegController.
    // Employer Login control is already taken care of in UserLoginController.

    @PutMapping("/employers/update")
    public String updateEmployer(@RequestParam("uname") String username, @RequestParam("name") String name, @RequestParam("contact") long contact, @RequestParam("designation") String designation, @RequestParam("companyName") String companyName)
    {
        try
        {
            if (employerServiceImpl.findEmployerByUsername(username) != null)
            {
                Employer employer = new Employer();
                employer.setName(name);
                employer.setContact(contact);
                employer.setDesignation(designation);

                Company company = new Company();
                if (companyServiceImpl.findCompanyByName(companyName) != null)
                {
                    company = companyServiceImpl.findCompanyByName(companyName);
                }
                else
                {
                    company.setCompanyName(companyName);
                    company.setLocations(null);
                    company.setJobs(null);
                    companyServiceImpl.insertCompany(company);
                }

                employer.setCompany(company);
                employerServiceImpl.updateEmployer(employer);
                System.err.println("Debug: Employer details have been updated successfully.");
                return "employer_home";
            }
            else
            {
                System.err.println("Debug: No such employer exists. Posssible cause: Wrong username.");
                return "employer_home";
            }
        }
        catch (EmployerException empEx)
        {
            empEx.printStackTrace();
        }
        return "errorPage";
    }

    @GetMapping("/employers/allEmployers")
    public List<Employer> findAllEmployers()
    {
        try
        {
            return employerServiceImpl.findAllEmployers();
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
        try 
        {
            return employerServiceImpl.getEmployerCount();
        }
        catch (EmployerException e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @DeleteMapping("/employers/deleteEmployer")
    public String removeEmployerAccount(@RequestBody Login login, @RequestBody Employer employer)
    {
        try 
        {
			if (loginServiceImpl.validateUser(login) && login.getRoleType().equals("EMP"))
			{
				System.err.println("Debug: Employer credentials verified. Proceeding to account deletion...");
			    employerServiceImpl.removeEmployer(login.getUserId());
			    loginServiceImpl.removeUser(login);
                System.err.println("Debug: Employer account has been deleted successfully.");
                return "jobcentral_home";
			}
            else
            {
                System.err.println("Debug: Employer has entered invalid credentials.");
                return "employers/deleteEmployer";
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