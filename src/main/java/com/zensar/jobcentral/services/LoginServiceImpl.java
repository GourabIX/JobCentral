package com.zensar.jobcentral.services;

import com.zensar.jobcentral.daos.LoginDao;
import com.zensar.jobcentral.entities.Login;
import com.zensar.jobcentral.exceptions.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gourab Sarkar
 * @modification_date 13 Oct 2019 20:57
 * @creation_date 13 Oct 2019 18:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the LoginServiceImpl class which implements LoginService interface and is a part of Business layer of the application.
 */

@Service
@Transactional
public class LoginServiceImpl implements LoginService
{

    @Autowired
    private LoginDao loginDao;

    @Override
    public Login findUserById(int userId) throws ServiceException
    {
        return loginDao.getUserById(userId);
    }

    @Override
    public Login findUserByUsername(String username) throws ServiceException
    {
        return loginDao.getUserByUsername(username);
    }

    @Override
    public void addUser(Login login) throws ServiceException
    {
        loginDao.insertUser(login);
    }

    @Override
    public void modifyUser(Login login) throws ServiceException
    {
        loginDao.updateUser(login);
    }

    @Override
    public void removeUser(Login login) throws ServiceException
    {
        loginDao.deleteUser(login);
    }

    @Override
    public boolean validateUser(Login login) throws ServiceException 
    {
        Login dbLoginCredentials = findUserByUsername(login.getUsername());

        if (dbLoginCredentials != null)
        {
            if (login.getUsername().equals(dbLoginCredentials.getUsername()) && login.getPassword().equals(dbLoginCredentials.getPassword()) && !(dbLoginCredentials.getRoleType().equals("TEMP")))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String findUserRoleTypeByUsername(String username) throws ServiceException 
    {
        Login login = findUserByUsername(username);
        return login.getRoleType();
    }

}