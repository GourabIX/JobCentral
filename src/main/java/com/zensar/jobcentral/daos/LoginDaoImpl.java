package com.zensar.jobcentral.daos;

/**
 * @author Priya Mirchandani, Gourab Sarkar
 * @modification_date 13 Oct 2019 11:42
 * @creation_date 04 Oct 2019 10:08
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the implementation of Login DAO interface used in the persistence layer.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.jobcentral.entities.Login;

@Repository
public class LoginDaoImpl implements LoginDao 
{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Login getUserById(int userId) 
	{
		return hibernateTemplate.get(Login.class, userId);
	}

	@Override
	public Login getUserByUsername(String username) 
	{
		return hibernateTemplate.get(Login.class, username);
	}

	@Override
	public void insert(Login login) 
	{
		hibernateTemplate.save(login);
		System.out.println("Debug: User having ID: " + login.getUserId() + " has been saved successfully.");
	}

	@Override
	public void update(Login login) 
	{
		hibernateTemplate.update(login);
		System.out.println("Debug: User having ID: " + login.getUserId() + " has been updated successfully.");
	}

	@Override
	public void delete(Login login) 
	{
		hibernateTemplate.delete(login);
		System.out.println("Debug: User having ID: " + login.getUserId() + " has been deleted successfully.");
	}
}
