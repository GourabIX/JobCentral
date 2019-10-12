package com.zensar.jobcentral.services;

import com.zensar.jobcentral.daos.AdminDao;
import com.zensar.jobcentral.entities.Login;

public interface AdminService {

	void setAdminDao(AdminDao adminDao);
	boolean validateUser(Login loginAuth);
	
}
