package com.zensar.jobcentral.daos;

/**
 * @author Priya Mirchandani, Gourab Sarkar
 * @modification_date 12 Oct 2019 21:05
 * @creation_date 04 Oct 2019 10:08
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the Employer DAO interface used in the persistence layer.
 */

import java.util.List;
import com.zensar.jobcentral.entities.Employer;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EmployerDaoImpl extends DaoAssistant implements EmployerDao
{

	@Override
	public List<Employer> getAllEmployers()
	{
		try 
		{
			beginTx();
			Query query = getCurrentSession().createQuery("FROM Employer");
			List<Employer> listOfEmployers = query.list();
			return listOfEmployers;
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public Employer getEmployerById(int employerId) 
	{
		try 
		{
			beginTx();
			return getCurrentSession().get(Employer.class, employerId);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertEmployer(Employer employer) 
	{
		try
		{
			beginTx();
			getCurrentSession().save(employer);
			commitTransaction();
			System.out.println("Debug: Employer having ID: " + employer.getEmployerId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}

	@Override
	public void updateEmployer(Employer employer) 
	{
		try
		{
			beginTx();
			getCurrentSession().update(employer);
			commitTransaction();
			System.out.println("Debug: Employer having ID: " + employer.getEmployerId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}

	@Override
	public void deleteEmployer(int employerId) 
	{
		try
		{
			beginTx();
			getCurrentSession().delete(getEmployerById(employerId));
			commitTransaction();
			System.out.println("Debug: Employer having ID: " + employerId + " has been deleted successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}

	@Override
	public Employer getEmployerByUsername(String username) 
	{
		try
		{
			beginTx();
			return getCurrentSession().get(Employer.class, username);
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}
}