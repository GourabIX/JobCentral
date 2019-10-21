package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.daos.AdminDao;
import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> findAllAdmins() {
        List<Admin> list = adminDao.getAllAdmins();
        return list;
    }

    public Admin findByAdminId(int adminId) 
    {
        return adminDao.getByAdminId(adminId);

    }
    @Override
    public void updateAdmin(Admin admin) 
    {
        adminDao.updateAdmin(admin);

    }
  

    @Override
    public String getUniqueCode(Employer employer)

    {
        String name = employer.getName();

        String name1 = name.substring(0, 3);

        long con = employer.getContact();

        String str = Long.toString(con);

        String str1 = str.substring(6);

        String str2 = name1 + str1;

        return str2;
    }

	@Override
	public Admin findByUserId(int userId) {
		List<Admin> listOfAllAdmins = findAllAdmins();
		for (Admin admin : listOfAllAdmins)
		{
			if (admin.getLogin().getUserId() == userId)
			{
				return admin;
			}
		}
		return null;
	}

}
