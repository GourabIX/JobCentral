package com.zensar.jobcentral.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.jobcentral.daos.AdminDao;
import com.zensar.jobcentral.daos.AdminDaoImpl;
import com.zensar.jobcentral.daos.EmployerDao;
import com.zensar.jobcentral.daos.EmployerDaoImpl;
import com.zensar.jobcentral.daos.JobSeekerDao;
import com.zensar.jobcentral.daos.JobSeekerDaoImpl;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.EmployerException;
import com.zensar.jobcentral.exceptions.LoginException;
import com.zensar.jobcentral.services.AdminService;
import com.zensar.jobcentral.services.AdminServiceImpl;
import com.zensar.jobcentral.services.EmployerService;
import com.zensar.jobcentral.services.EmployerServiceImpl;
import com.zensar.jobcentral.services.JobSeekerService;
import com.zensar.jobcentral.services.JobSeekerServiceImpl;

/**
 * @author Gourab Sarkar
 * @modification_date 08 Oct 2019 15:26
 * @creation_date 07 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the User Authentication Controller class which is a part of Business layer of the application.
 */

@WebServlet("/uac")
public class UserAuthController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// Call User business layer components: DAO and Service
	// User may be JobSeeker, Employer or Admin
	
	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	private AdminService adminService;
	
	private JobSeekerDao jobSeekerDao;
	private EmployerDao employerDao;
	private AdminDao adminDao;

	public JobSeekerService getJobSeekerService() {
		return jobSeekerService;
	}

	public void setJobSeekerService(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}

	public EmployerService getEmployerService() {
		return employerService;
	}

	public void setEmployerService(EmployerService employerService) {
		this.employerService = employerService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void init(ServletConfig config) throws ServletException {
		
		// Create session objects for each user type.
		// Depending on which user type actually logs in, the other objects will be destroyed.
		
		try {
			// For the JobSeeker
			jobSeekerDao = new JobSeekerDaoImpl();
			jobSeekerService = new JobSeekerServiceImpl();
			jobSeekerService.setJobSeekerDao(jobSeekerDao);
			setJobSeekerService(jobSeekerService);
			
			// For the Employer
			employerDao = new EmployerDaoImpl();
			employerService = new EmployerServiceImpl();
			employerService.setEmployerDao(employerDao);
			setEmployerService(employerService);
			
			// For the Admin
			adminDao = new AdminDaoImpl();
			adminService = new AdminServiceImpl();
			adminService.setAdminDao(adminDao);
			setAdminService(adminService);
		} 
		catch (EmployerException e) 
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");				// This should EXACTLY match in spelling & case with the form-field name.
		String password = request.getParameter("password");				// This should EXACTLY match in spelling & case with the form-field name.
		Login loginAuth = new Login();
		loginAuth.setUsername(username);
		loginAuth.setPassword(password);
		PrintWriter outUI = response.getWriter();
		
		// Process user authentication for each user type
		try {
			if (jobSeekerService.validateUser(loginAuth))
			{
				outUI.println("Login successful!");
				System.out.println("Debug: Login succeeded as type: JobSeeker");
				RequestDispatcher dispatcher = request.getRequestDispatcher("jobseeker_home.html");
				dispatcher.forward(request, response);
				
				// Destroy redundant user type objects
				employerService = null;
				adminService = null;
				employerDao = null;
				adminDao = null;
			}
			else if (employerService.validateUser(loginAuth))
			{
				outUI.println("Login successful!");
				System.out.println("Debug: Login succeeded as type: Employer");
				RequestDispatcher dispatcher = request.getRequestDispatcher("employer_home.html");
				dispatcher.forward(request, response);
				
				// Destroy redundant user type objects
				jobSeekerService = null;
				adminService = null;
				jobSeekerDao = null;
				adminDao = null;
			}
			else if (adminService.validateUser(loginAuth))
			{
				outUI.println("Login successful!");
				System.out.println("Debug: Login succeeded as type: Admin");
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin_home.html");
				dispatcher.forward(request, response);
				
				// Destroy redundant user type objects
				jobSeekerService = null;
				employerService = null;
				jobSeekerDao = null;
				employerDao = null;
			}
			else
			{
				outUI.println("Login failed! Wrong credentials maybe?");
				System.out.println("Debug: Credentials did not match any user type. Possible cause: Wrong credentials.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			}
		} 
		catch (EmployerException | LoginException exc) 
		{
			exc.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
