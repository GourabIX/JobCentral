package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Login;

/**
 * @author Priya Mirchandani
 * @creation_date 5 october 2019 5.36pm
 * @modification_date 5 october 2019 5.36pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a dao class using persistance layer
 *
 */
public interface LoginDao {
	Login getById(int userId);
	void insert(Login login);
	void update(Login login);
	void delete(Login login);
}
