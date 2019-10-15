package com.zensar.jobcentral.controllers;

/**
 * @author Gourab Sarkar
 * @modification_date 14 Oct 2019 23:26
 * @creation_date 14 Oct 2019 22:48
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the User Login Controller class which is a part of Business layer of the application.
 */

import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.ServiceException;
import com.zensar.jobcentral.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @PostMapping("/login")
    public String loginGateway(@RequestParam("uname") String username, @RequestParam("passwd") String password) 
    {
        try 
        {
            Login login = new Login();
            login.setUsername(username);
            login.setPassword(password);
            String userRole = loginServiceImpl.findUserRoleTypeByUsername(login.getUsername());

            if (userRole.equalsIgnoreCase("JSK"))
            {
                login.setRoleType("JSK");                   // Attach UserRoleType tag to current user trying to login.
                if (loginServiceImpl.validateUser(login))
                {
                    System.err.println("Debug: Login Succeeded as JobSeeker. Redirecting to JobSeeker Home page...");
                    return "jobSeeker_home";            // use viewResolver to resolve mapping to .html page.
                }
            }
            else if (userRole.equalsIgnoreCase("EMP"))
            {
                login.setRoleType("EMP");
                if (loginServiceImpl.validateUser(login))
                {
                    System.err.println("Debug: Login Succeeded as Employer. Redirecting to Employer Home page...");
                    return "employer_home";
                }
            }
            else if (userRole.equalsIgnoreCase("ADM"))
            {
                login.setRoleType("ADM");
                if (loginServiceImpl.validateUser(login))
                {
                    System.err.println("Debug: Login Succeeded as Admin. Redirecting to Admin Home page...");
                    return "admin_home";
                }
            }
            else if (userRole.equalsIgnoreCase("TEMP"))
            {
                login.setRoleType("TEMP");
                System.err.println("Debug: User trying to login is an unverified user. Redirecting to verification page...");
                return "userVerify";
            }
            else
            {
                System.err.println("User has entered invalid credentials. Redirecting to Login page...");
                return "login";
            }
        } 
        catch (ServiceException svcEx)
        {
            svcEx.printStackTrace();
        }
        return "errorPage";                             // If all else fails, this is the nuclear option.
    }

}