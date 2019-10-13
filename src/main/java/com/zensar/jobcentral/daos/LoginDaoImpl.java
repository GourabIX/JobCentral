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
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl extends DaoAssistant implements LoginDao 
{

	@Override
	public Login getUserById(int userId) 
	{
		try
		{
			beginTx();
			return getCurrentSession().get(Login.class, userId);
		}
		catch (HibernateException hbexc)
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public Login getUserByUsername(String username) 
	{
		try
		{
			beginTx();
			return getCurrentSession().get(Login.class, username);
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
			beginTx();
			getCurrentSession().save(login);
			commitTransaction();
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
			beginTx();
			getCurrentSession().update(login);
			commitTransaction();
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
			beginTx();
			getCurrentSession().delete(login);
			commitTransaction();
			System.out.println("Debug: User having ID: " + login.getUserId() + " has been deleted successfully.");
		}
		catch (HibernateException hbexc)
		{
			hbexc.printStackTrace();
		}	
	}
}
