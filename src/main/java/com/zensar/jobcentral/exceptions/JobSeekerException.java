package com.zensar.jobcentral.exceptions;

@SuppressWarnings("serial")
public class JobSeekerException extends Exception
{
	
	private String errormessage;
	
	public JobSeekerException() 
	{
		System.out.println("Unable to process your request. Please try again");
	}

	public JobSeekerException(String errormessage) 
	{
		super(errormessage);
		this.errormessage = errormessage;
	}

	
}
