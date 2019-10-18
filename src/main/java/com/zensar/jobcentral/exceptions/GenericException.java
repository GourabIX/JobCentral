package com.zensar.jobcentral.exceptions;

@SuppressWarnings("serial")
public class GenericException extends Exception
{
	
	
	public GenericException() 
	{
		System.out.println("Something went wrong. We can't quite make out what.");
	}

	public GenericException(String errormessage) 
	{
		super(errormessage);
	}
	
}
