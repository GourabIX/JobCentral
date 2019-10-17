package com.zensar.jobcentral.daos;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.query.Query;
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
public class AdminDaoImpl extends DaoAssistant implements AdminDao {

	
	@Override
	public List<Admin> getAllAdmins() {
		
		try 
		{
			beginTx();
			Query query = getCurrentSession().createQuery("From Admin");
			List<Admin> listOfAdmin = query.list();
			return listOfAdmin;
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public Admin getByAdminId(int adminId) {
		try {
			beginTx();
			return getCurrentSession().get(Admin.class, adminId);
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
			beginTx();
			getCurrentSession().save(admin);
			commitTransaction();
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
			beginTx();
			getCurrentSession().update(admin);
			commitTransaction();
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
			beginTx();
			getCurrentSession().delete(getByAdminId(adminId));;
			commitTransaction();
			System.out.println("Debug: admin having ID: " + adminId+ " has been deleted successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}

}
