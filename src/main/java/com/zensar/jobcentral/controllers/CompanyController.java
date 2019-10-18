package com.zensar.jobcentral.controllers;

import java.util.List;

import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Job;
import com.zensar.jobcentral.entities.Location;
import com.zensar.jobcentral.services.CompanyServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private CompanyServiceImpl companyServiceImpl;
    @Autowired
    private Company company;

    private int companyId;
    String companyName;
    List<Job> jobs;
    List<Location> locations;

    @PutMapping("/company/add")
    public String insertCompany() {
        try {
            if (companyServiceImpl.findById(companyId) == null) {
                companyServiceImpl.insertCompany(company);
                System.out.println("insertion is done");
                return "success";
            } else {
                System.out.println("insertion can't be done");
                return "/company/update";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "errorPage";
    }

    @PutMapping("/company/update")
    public String updateCompany() {

        try {
            if (companyServiceImpl.findById(companyId) != null) {
                Company company = new Company();
                company.setCompanyId(companyId);
                company.setCompanyName(companyName);
                company.setJobs(jobs);
                company.setLocations(locations);
                companyServiceImpl.updateCompany(company); //updating company data
                System.out.println("updation success");
                return "success";
              
          }
          else
          {
              System.out.println("updation failure");
               return "/company/add";
          }
      }
    catch(Exception e)
    {
       e.printStackTrace();
    }
     return "erroprPage";
}
        
        @DeleteMapping("/company/delete")
        public String deleteCompany()
        {
        try{
            if(companyServiceImpl.findById(companyId) != null)
            {
                companyServiceImpl.deleteCompany(company);  //deleting company data
                System.out.println("deletion is done");
                return "success";
        }
            else
            {
                  System.out.println("deletion failure");
                  return "/company/add";
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       return "errorPage";


        }
        @GetMapping("/company/id")
         public String getById(int companyId)
          {
              try{

              if(companyServiceImpl.findById(companyId)!=null)
              {
              companyServiceImpl.findById(companyId);
              System.out.println("id found");
              return "company";
              }
              else
              {
                  System.out.println("id not found");
                  return "/company/id";
              }
            }
            catch(Exception e)
                {
                  e.printStackTrace();
                 }
          

                 return "errorPage";
}
@GetMapping("/company")
              public String getAllCompanies()
{
try{
                     companyServiceImpl.getAllCompanies();
                     System.out.println("list of all comapnies displayed");
                     return "company";
}
catch(Exception e)
{
e.printStackTrace();
}
return "errorPage";
}
 @GetMapping("/company/name")
public String getByName(String name)
{
try{
    if(companyServiceImpl.findById(companyId)!=null)
    {
        companyServiceImpl.findCompanyByName(name);
        System.out.println("company"+name+"is found");
        return "company";
    }
    else
    {
      System.out.println("comapny not found");
      return "/company/name";
    }
}
catch(Exception e)
{
e.printStackTrace();
}
return "errorPage";
}



















}
