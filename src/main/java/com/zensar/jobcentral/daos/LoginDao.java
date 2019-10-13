package com.zensar.jobcentral.daos;

/**
 * @author Priya Mirchandani, Gourab Sarkar
 * @modification_date 13 Oct 2019 11:33
 * @creation_date 04 Oct 2019 10:08
 * @version 0.1
 * @copyright Zensar Technologies 2019. All rights reserved.
 * @description This is the Login DAO interface used in the persistence layer.
 */

import com.zensar.jobcentral.entities.Login;

public interface LoginDao 
{
	Login getUserById(int userId);
	Login getUserByUsername(String username);
	void insert(Login login);
	void update(Login login);
	void delete(Login login);
}
