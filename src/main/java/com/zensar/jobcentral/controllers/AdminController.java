package com.zensar.jobcentral.controllers;

import java.util.Properties;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.services.AdminService;
import com.zensar.jobcentral.services.AdminServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class AdminController{
    @Autowired
    private AdminService adminService;
    @RequestMapping("employer")
    public boolean isEmployerValid(Employer employer, Company company){
        
		return false;

        } 
    public String getUniqueCode(Employer employer){
		return null;
	    }
	}