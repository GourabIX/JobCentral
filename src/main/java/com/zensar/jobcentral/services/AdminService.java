package com.zensar.jobcentral.services;

import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Employer;

/**
 * @author Samraddhi Khare
 * @creation_date 5th october 2019 10:00AM
 * @modification_date 5th october 2019 11:37AM
 * @version 1.0
 * @copyright Zensar Technologies. All rights reserved
 * @Description It is a Service interface using buisness layer.
 *            
 */
public interface AdminService

{                           
   public boolean isEmployerValid(Employer employer, Company company);
   
   public String getUniqueCode(Employer employer);
		
}
