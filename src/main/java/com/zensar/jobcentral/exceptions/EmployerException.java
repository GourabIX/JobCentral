package com.zensar.jobcentral.exceptions;

@SuppressWarnings("serial")
public class EmployerException extends Exception
{	
	public EmployerException() 
	{
		System.out.println("Operation Failed. Please try again");
	}

	public EmployerException(String errormessage) 
	{
		super(errormessage);
	}
	
	
}
