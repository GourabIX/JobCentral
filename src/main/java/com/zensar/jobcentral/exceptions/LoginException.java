package com.zensar.jobcentral.exceptions;

@SuppressWarnings("serial")
public class LoginException extends Exception
{

	public LoginException() 
	{
		System.out.println("Login Denied.Please try again.");
	}

	public LoginException(String errormessage) 
	{
		super(errormessage);
	}
	
}