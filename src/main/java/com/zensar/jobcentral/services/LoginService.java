package com.zensar.jobcentral.services;

import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.ServiceException;

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
    Login findUserById(int userId) throws ServiceException;
	Login findUserByUsername(String username) throws ServiceException;
	void addUser(Login login) throws ServiceException;
	void modifyUser(Login login) throws ServiceException;
	void removeUser(Login login) throws ServiceException;
	boolean validateUser(Login login) throws ServiceException;
	String findUserRoleTypeByUsername(String username) throws ServiceException;
}