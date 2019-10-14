package com.zensar.jobcentral.exceptions;

@SuppressWarnings("serial")
public class LoginException extends Exception
{
	private String errormessage;
	
	public LoginException() 
	{
		System.out.println("Login Denied.Please try again.");
	}

	public LoginException(String errormessage) 
	{
		super(errormessage);
		this.errormessage = errormessage;
	}
	
}