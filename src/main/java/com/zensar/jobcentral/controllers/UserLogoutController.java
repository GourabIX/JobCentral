package com.zensar.jobcentral.controllers;

import java.io.IOException;

/**
 * @author Gourab Sarkar
 * @modification_date 13 Oct 2019 23:26
 * @creation_date 13 Oct 2019 23:26
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the User Logout Controller class which is a part of Business layer of the application.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLogoutController 
{

    @RequestMapping(value = "logout.html", method = RequestMethod.GET)
    public String userLogout(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.html");
            return "Debug: User has been logged out successfully.";
        } 
        catch (IllegalStateException | IOException lgexc)
        {
            lgexc.printStackTrace();
        }
        return "Something probably went wrong with the Logout process...";
    }

}