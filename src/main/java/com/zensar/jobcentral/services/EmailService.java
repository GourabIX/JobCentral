package com.zensar.jobcentral.services;

/**
 * @author Gourab Sarkar
 * @modification_date 16 Oct 2019 07:57
 * @creation_date 16 Oct 2019 07:57
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the Email Service interface.
 */

public interface EmailService
{
    void sendEmail(String toAddress, String subject, String message);
}