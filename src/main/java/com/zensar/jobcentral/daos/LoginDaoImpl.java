package com.zensar.jobcentral.daos;

/**
 * @author Gourab Sarkar
 * @modification_date 13 Oct 2019 22:42
 * @creation_date 13 Oct 2019 22:42
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the implementation of JobApplications DAO interface used in the persistence layer.
 */

import com.zensar.jobcentral.entities.Login;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao 
{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Login getUserById(int userId) 
	{
		try
		{
			return hibernateTemplate.get(Login.class, userId);
		}
		catch (HibernateException hbexc)
		{
			hbexc.printStackTrace();
		}
		return null;
	}


	@Override
	public void insertUser(Login login) 
	{
		try
		{
			hibernateTemplate.save(login);
			System.out.println("Debug: User having ID: " + login.getUserId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc)
		{
			hbexc.printStackTrace();
		}
	}

	@Override
	public void updateUser(Login login) 
	{
		try
		{
			hibernateTemplate.update(login);
			System.out.println("Debug: User having ID: " + login.getUserId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc)
		{
			hbexc.printStackTrace();
		}	
	}

	@Override
	public void deleteUser(Login login) 
	{
		try
		{
			hibernateTemplate.delete(login);
			System.out.println("Debug: User having ID: " + login.getUserId() + " has been deleted successfully.");
		}
		catch (HibernateException hbexc)
		{
			hbexc.printStackTrace();
		}	
	}


	@Override
	public List<Login> getAll() {
		// TODO Auto-generated method stub
		return (List<Login>) hibernateTemplate.find("from Login");
	}
}
