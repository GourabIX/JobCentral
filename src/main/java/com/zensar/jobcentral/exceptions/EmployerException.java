package com.zensar.jobcentral.exceptions;

@SuppressWarnings("serial")
public class EmployerException extends Exception
{
	private String errormessage;
	
	public EmployerException() 
	{
		System.out.println("Operation Failed. Please try again");
	}

	public EmployerException(String errormessage) 
	{
		super(errormessage);
		this.errormessage = errormessage;
	}
	
	
}
