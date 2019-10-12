package com.zensar.jobcentral.daos;

/**
 * @author Priya Mirchandani, Gourab Sarkar
 * @creation_date October 5, 2019 17:36
 * @modification_date October 12, 2019 21:57 
 * @version 1.0
 * @copyright Zensar Technologies. All rights reserved
 *
 */

import com.zensar.jobcentral.entities.Login;

public interface LoginDao {
	Login getUserById(int userId);
	void insert(Login login);
	void update(Login login);
	void delete(Login login);
}
