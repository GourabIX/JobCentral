package com.zensar.jobcentral.controllers;

/**
 * @author Gourab Sarkar
 * @modification_date 15 Oct 2019 02:06
 * @creation_date 15 Oct 2019 02:06
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the User Registration Controller class which is a part of Business layer of the application.
 */

import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.EmployerException;
import com.zensar.jobcentral.exceptions.ServiceException;
import com.zensar.jobcentral.services.EmployerServiceImpl;
import com.zensar.jobcentral.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegController
{

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @Autowired
    private EmployerServiceImpl employerServiceImpl;

    @PostMapping("/JobSeekerSignup")
    public String registerJobSeeker(@RequestParam("uname") String username, @RequestParam("passwd") String password)
    {
        try
        {
            Login login = new Login();
            login.setUsername(username);
            login.setPassword(password);
            login.setRoleType("JSK");
            loginServiceImpl.addUser(login);
            System.err.println("Debug: JobSeeker with username " + username + " has been successfully added to the database!");
            return "jobSeeker_home";
        }
        catch (ServiceException svcEx)
        {
            svcEx.printStackTrace();
        }
        return "errorPage";
    }

    @PostMapping("/EmployerSignup")
    public String registerEmployer(@RequestParam("uname") String username, @RequestParam("passwd") String password, @RequestParam("contact") long contact, @RequestParam("companyName") String companyName)
    {
        try
        {
            // Set the Login instance variables
            Login login = new Login();
            login.setUsername(username);
            login.setPassword(password);
            login.setRoleType("TEMP");                  // Employer just signed up -- could be a fraud -- is a TEMP employer.
            loginServiceImpl.addUser(login);

            // Set the Employer instance variables
            Employer employer = new Employer();
            employer.setContact(contact);
            employer.setName("TEMP");
            employer.setDesignation("TEMP");
            employer.setCompany(null);
            employer.setLogin(login);
            employer.setJobs(null);
            employerServiceImpl.addEmployer(employer);

            System.err.println("Debug: Employer with username " + username + " has been successfully added to the database!");
            return "userVerify";                // proceed to verify employer
        }
        catch (ServiceException | EmployerException svcEx)
        {
            svcEx.printStackTrace();
        }
        return "errorPage";
    }

}