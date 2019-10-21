package com.zensar.jobcentral.controllers;
import java.util.List;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Employer;
import com.zensar.jobcentral.entities.Location;
import com.zensar.jobcentral.services.AdminService;
import com.zensar.jobcentral.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
 public class AdminController
 {
    @Autowired
        private AdminService adminService;

    @Autowired
    private EmailService emailService;

     @PostMapping("/admin/getalladmins")
     public List<Admin> getAllAdmins()  
     {
        try
        {
            adminService.findAllAdmins();
        }
       catch (Exception e) 
       {
            e.printStackTrace();
       }
       return null;
      
     }

     
     @PostMapping("/admin/getadminbyid")
      public List<Admin> getAdminById(int adminId)  
     {
        try
        {
            adminService.findByAdminId(adminId);
        }
       catch (Exception e) 
       {
            e.printStackTrace();
       }
       return null;
      
     }

     @PostMapping("/admin/updateadmin")
     public String updateAdmin(@RequestParam("adminId") int adminId, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("state") String state, @RequestParam("city") String city )
     {
        try
       {
            if(adminService.findByAdminId(adminId) != null)
            {
                Admin admin = new Admin();
                admin.setAdminId(adminId);
                Location location = new Location();
                location.setCity(city);
                location.setState(state);
                admin.setLocation(location);
                adminService.updateAdminById(adminService.findByAdminId(adminId));
            }
            else
            {
                 System.err.println("Debug: No such admin exists.Selected admin cannot be updated");
                 return "employer_home";
            }

        }
            
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return "errorPage";
      
     }
        
     @PostMapping("/verifyemployer")
     public String  verifyEmployer(@RequestBody Company company, @RequestBody Employer employer, @RequestBody String enteredCode) 
     {
         try
         {
            String uniqueCode = adminService.getUniqueCode(employer);
            emailService.sendEmail(employer.getName(),"Verification Email", uniqueCode);

            if(enteredCode.equals(uniqueCode))
            {
                System.err.println("Employer verified");
                return "employer_home";
            }

            else
            {
                System.err.println("employer entered wrong code");
                return "/verifyemployer";
            }
               
         }

         catch(Exception e)
         {
             e.printStackTrace();
         }

         return "errorPage";



     }    

     }


 }