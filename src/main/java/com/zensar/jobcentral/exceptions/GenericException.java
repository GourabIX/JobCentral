package com.zensar.jobcentral.exceptions;

public class GenericException extends Exception
{
	
	private String errormessage;
	
	public GenericException() 
	{
		System.out.println("Something went wrong. We can't quite make out what.");
	}

	public GenericException(String errormessage) 
	{
		super(errormessage);
		this.errormessage = errormessage;
	}
	
}
