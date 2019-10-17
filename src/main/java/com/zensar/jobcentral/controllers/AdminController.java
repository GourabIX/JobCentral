package com.zensar.jobcentral.controllers;

import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class AdminController{
    @Autowired
    private AdminService adminService;
    
    @RequestMapping("employer")
    public boolean employerValid(Employer employer, Company company){
        boolean result = adminService.isEmployerValid(employer,company);
		return result;
        } 
    public String uniqueCode(Employer employer){
        String code = adminService.getUniqueCode(employer);
		return code;
	    }
	}