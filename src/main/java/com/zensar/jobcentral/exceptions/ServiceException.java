package com.zensar.jobcentral.exceptions;

@SuppressWarnings("serial")
public class ServiceException extends Exception
{
	
	public ServiceException() 
	{
		System.out.println("Service Interrupted. We'll come back as soon as possible.");
	}

	public ServiceException(String errormessage) 
	{
		super(errormessage);
	}
	
}
