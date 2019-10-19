package com.zensar.jobcentral.exceptions;

@SuppressWarnings("serial")
public class AdminException extends Exception
{		
		public AdminException() 
		{
			System.out.println("Admin permissions denied.Please try again");
		}

		public AdminException(String errormessage) 
		{
			super(errormessage);
		}
}
