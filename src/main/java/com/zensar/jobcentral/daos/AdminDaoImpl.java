package com.zensar.jobcentral.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.jobcentral.entities.Admin;

/**
 * @author Priya Mirchandani
 * @creation_date 5 october 2019 5.37pm
 * @modification_date 5 october 2019 5.37pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoimpl class using persistance layer
 *
 */
@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Admin> getAllAdmins() {
		try
		{
			return (List<Admin>) hibernateTemplate.find("from Admin");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public Admin getByAdminId(int adminId) {
		try 
		{
			return hibernateTemplate.get(Admin.class, adminId);
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertAdmin(Admin admin) {
		try
		{
			hibernateTemplate.save(admin);
			System.out.println("Debug: Admin having ID: " + admin.getAdminId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		try
		{
			hibernateTemplate.update(admin);
			System.out.println("Debug: Admin having ID: " + admin.getAdminId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}

	@Override
	public void deleteAdmin(int adminId) {
		try
		{
			hibernateTemplate.delete(getByAdminId(adminId));
			System.out.println("Debug: admin having ID: " + adminId+ " has been deleted successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}

}
