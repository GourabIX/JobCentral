package com.zensar.jobcentral.services;

import java.util.Properties;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Employer;
import java.util.*;
import javax.activation.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AdminServiceImpl implements AdminService {

	public boolean isEmployerValid(Employer employer,Company company) 
	{

		//	mail verification code starts

		// Recipient's email ID needs to be mentioned.
		String to = "vejefa@appmaillist.com";

		// Sender's email ID needs to be mentioned
		String from = "bzyprjcg@sharklasers.com";

		// Assuming you are sending email from localhost
		String host = "sharklasers.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");

		} 

		catch (MessagingException mex) 
		{
			mex.printStackTrace();
		}

		String c1=getUniqueCode(employer);
		// sendEmail(c1, otherArgs...);
		System.out.println("enter your pincode");
		
		if(userCode.equals(c1)) {
			return true;
		}
		else 
			return false;
	}


	@Override
	public String getUniqueCode(Employer employer)

	{
		String name=employer.getName();

		String name1=name.substring(0, 3);

		int con=employer.getContact();

		String str= Integer.toString(con);

		String str1=str.substring(6);

		String str2=name1+str1;		

		return str2;
	}        
}



