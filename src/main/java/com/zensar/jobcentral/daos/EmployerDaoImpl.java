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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployerDaoImpl implements EmployerDao 
{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Employer> getAllEmployers()
	{
		return (List<Employer>) hibernateTemplate.find("FROM Employer");
	}

	@Override
	public Employer getEmployerById(int employerId) 
	{
		return hibernateTemplate.get(Employer.class, employerId);
	}

	@Override
	public void insertEmployer(Employer employer) 
	{
		hibernateTemplate.save(employer);
		System.out.println("Debug: Employer having ID: " + employer.getEmployerId() + " has been saved successfully.");
	}

	@Override
	public void updateEmployer(Employer employer) 
	{
		hibernateTemplate.update(employer);
		System.out.println("Debug: Employer having ID: " + employer.getEmployerId() + " has been updated successfully.");
	}

	@Override
	public void deleteEmployer(int employerId) 
	{
		hibernateTemplate.delete(getEmployerById(employerId));
		System.out.println("Debug: Employer having ID: " + employerId + " has been deleted successfully.");
	}

	@Override
	public Employer getEmployerByUsername(String username) 
	{
		return hibernateTemplate.get(Employer.class, username);
	}
}