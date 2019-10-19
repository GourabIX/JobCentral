package com.zensar.jobcentral.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.services.CompanyService;

/**
 * @author PriyaMirchandani
 * @modification_date 16 Oct 2019 2.47pm
 * @creation_date 16 Oct 2019 2.47pm
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the company Service Controller class.
 */

@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@PostMapping("/company/add")
	public String insertCompany(@RequestParam("companyName") String companyName) {
		try {
			if (companyService.findCompanyByName(companyName) == null) {
				Company company = new Company();
				company.setCompanyName(companyName);
				companyService.insertCompany(company);
				System.err.println("insertion is done");
				return "employer_home";
			} else {
				System.err.println("Company already exists in the database!");
				return "employer_home";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "errorPage";
	}

	@PutMapping("/company/update")
	public String updateCompany(@RequestParam("companyName") String companyName) {
		try {
			if (companyService.findCompanyByName(companyName) != null) {
				Company company = new Company();
				company.setCompanyName(companyName);
				companyService.updateCompany(company); 			// updating company data
				System.out.println("updation success");
				return "employer_home";

			} else {
				System.out.println("updation failure: company with name: " + companyName + " does not exist in database.");
				return "employer_home";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "errorPage";
	}

	@DeleteMapping("/company/delete")
	public String deleteCompany(@RequestParam("companyName") String companyName) {
		try {
			if (companyService.findCompanyByName(companyName) != null) {
				Company company = companyService.findCompanyByName(companyName);
				companyService.deleteCompany(company); 		// deleting company data
				System.out.println("Company with name: " + companyName + " is deleted.");
				return "employer_home";
			} else {
				System.out.println("Company with name: " + companyName + " does not exist.");
				return "employer_home";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "errorPage";

	}

	@GetMapping("/company/findCompany")
	public Company findCompanyByName(@RequestParam("companyName") String companyName) {
		try {
			if (companyService.findCompanyByName(companyName) != null) {
				return companyService.findCompanyByName(companyName);
			} else {
				System.out.println("company not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/company")
	public List<Company> getAllCompanies() {
		try {
			companyService.getAllCompanies();
			System.out.println("list of all comapnies displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/company/findCompanyById")
	public Company findCompanyById(@RequestParam("companyId") int companyId) {
		try {
			if (companyService.findById(companyId) != null) {
				return companyService.findById(companyId);
			} else {
				System.out.println("company not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
