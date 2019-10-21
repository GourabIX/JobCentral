package com.zensar.jobcentral.controllers;

import java.util.List;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Location;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.services.AdminService;
import com.zensar.jobcentral.services.EmailService;
import com.zensar.jobcentral.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/admin/getalladmins")
	public List<Admin> getAllAdmins() {
		try {
			return adminService.findAllAdmins();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@GetMapping("/admin/getadminbyid")
	public Admin getAdminById(@RequestParam("userId") int userId) 
	{
		try 
		{
			return adminService.findByAdminId(loginService.findUserById(userId).getAdmin().getAdminId());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping("/admin/updateadmin")
	public String updateAdmin(@RequestParam("userId") int userId, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("state") String state,
			@RequestParam("city") String city) 
	{
		try 
		{
			if (loginService.findUserById(userId) != null) 
			{
				System.err.println("User match found. Proceeding to update account properties...");
				Admin admin = adminService.findByAdminId(loginService.findUserById(userId).getAdmin().getAdminId());
				Login login = loginService.findUserById(userId);
				System.err.println("Debug: Login object: " + login.toString());
				login.setUsername(username);
				login.setPassword(password);
				admin.setLogin(login);
				Location location = new Location();
				location.setCity(city);
				location.setState(state);
				admin.setLocation(location);
				adminService.updateAdmin(admin);
				System.err.println("Admin with UserID: " + userId + " has been updated successfully.");
				return "employer_home";
			} 
			else {
				System.err.println("Debug: No such admin exists.Selected admin cannot be updated");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return "errorPage";

	}

	@PostMapping("/verifyemployer")
	public String verifyEmployer(@RequestBody Company company, @RequestBody Employer employer,
			@RequestBody String enteredCode) {
		try {
			String uniqueCode = adminService.getUniqueCode(employer);
			emailService.sendEmail(employer.getName(), "Verification Email", uniqueCode);

			if (enteredCode.equals(uniqueCode)) {
				System.err.println("Employer verified");
				return "employer_home";
			}

			else {
				System.err.println("employer entered wrong code");
				return "/verifyemployer";
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return "errorPage";

	}

}