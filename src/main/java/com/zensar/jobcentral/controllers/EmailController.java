package com.zensar.jobcentral.controllers;

/**
 * @author Gourab Sarkar
 * @modification_date 16 Oct 2019 08:00
 * @creation_date 16 Oct 2019 08:00
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Email Service Controller class.
 */

import com.zensar.jobcentral.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController
{

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendmail")
    public void sendEmail()
    {
        emailService.sendEmail("gourab_recv_test@gmail.com", "Test subject", "Test message");
    }

}