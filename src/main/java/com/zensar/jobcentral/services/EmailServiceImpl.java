package com.zensar.jobcentral.services;

/**
 * @author Gourab Sarkar
 * @modification_date 16 Oct 2019 07:57
 * @creation_date 16 Oct 2019 07:57
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Email Service Implementation class which implements the Email Service interface.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService
{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String toAddress, String subject, String message)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        
        mailMessage.setTo(toAddress);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("gourab-test@jobcentral.com");

        javaMailSender.send(mailMessage);

        System.err.println("Debug: Email has been sent successfully.");
    }

}