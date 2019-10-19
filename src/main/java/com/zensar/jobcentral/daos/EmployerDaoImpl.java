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

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.jobcentral.entities.Employer;

@Repository
public class EmployerDaoImpl implements EmployerDao
{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Employer> getAllEmployers()
	{
		try 
		{
			return (List<Employer>) hibernateTemplate.find("from Employer");
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
			return hibernateTemplate.get(Employer.class, employerId);	
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
			hibernateTemplate.save(employer);
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
			hibernateTemplate.saveOrUpdate(employer);
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
			hibernateTemplate.delete(getEmployerById(employerId));
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
			List<Employer> allEmployers = getAllEmployers();
			for (Employer currentEmployer : allEmployers)
			{
				if (currentEmployer.getLogin().getUsername().equals(username))
				{
					return currentEmployer;
				}
			}
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}
}