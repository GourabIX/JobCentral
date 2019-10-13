package com.zensar.jobcentral.services;

import com.zensar.jobcentral.entities.Login;

/**
 * @author Gourab Sarkar
 * @modification_date 13 Oct 2019 20:57
 * @creation_date 13 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the LoginService interface and is a part of Business layer of the application.
 */

public interface LoginService
{
    Login findUserById(int userId);
	Login findUserByUsername(String username);
	void addUser(Login login);
	void modifyUser(Login login);
	void removeUser(Login login);
}