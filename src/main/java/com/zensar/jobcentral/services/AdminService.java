package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Employer;

/**
 * @author Chaithrodaya BS
 * @creation_date 5th october 2019 10:00AM
 * @modification_date 19th october 2019 10.30AM
 * @version 1.0
 * @copyright Zensar Technologies. All rights reserved
 * @Description It is a Service interface using buisness layer.
 *            
 */
public interface AdminService

{                           
    List <Admin>findAllAdmins();
    Admin findByAdminId(int adminId);
    void updateAdmin(Admin admin);
    public String getUniqueCode(Employer employer);
}
