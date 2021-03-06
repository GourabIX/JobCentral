package com.zensar.jobcentral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.zensar.jobcentral.services.LoginService;

@RestController
@CrossOrigin
public class UserAuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
//    public String loginGateway(@RequestParam("username") String username, @RequestParam("password") String password)
    public String loginGateway(@RequestBody Login login)
    {
        try 
        {        	
        	if (loginService.findUserByUsername(login.getUsername()) != null)
        	{
//	        	String userRole = loginService.findUserRoleTypeByUsername(login.getUsername());
//	        	Login login = new Login();
//	        	login.setUsername(username);
//	        	login.setPassword(password);
        		String userRole = login.getRoleType();
	        	
	            if (userRole.equalsIgnoreCase("JSK"))
	            {
	                login.setRoleType("JSK");                   // Attach UserRoleType tag to current user trying to login.
	                if (loginService.validateUser(login))
	                {
	                    System.err.println("Debug: Login Succeeded as JobSeeker. Redirecting to JobSeeker Home page...");
	                    return "jobSeeker_home";            // use viewResolver to resolve mapping to .html page.
	                }
	            }
	            else if (userRole.equalsIgnoreCase("EMP"))
	            {
	                login.setRoleType("EMP");
	                if (loginService.validateUser(login))
	                {
	                    System.err.println("Debug: Login Succeeded as Employer. Redirecting to Employer Home page...");
	                    return "employer_home";
	                }
	            }
	            else if (userRole.equalsIgnoreCase("ADM"))
	            {
	                login.setRoleType("ADM");
	                if (loginService.validateUser(login))
	                {
	                    System.err.println("Debug: Login Succeeded as Admin. Redirecting to Admin Home page...");
	                    return "admin_home";
	                }
	            }
	            else if (userRole.equalsIgnoreCase("TMP"))
	            {
	                login.setRoleType("TMP");
	                System.err.println("Debug: Employer trying to login is an unverified employer. Redirecting to verification page...");
	                return "userVerify";
	            }
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