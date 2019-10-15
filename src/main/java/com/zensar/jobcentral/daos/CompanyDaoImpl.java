package com.zensar.jobcentral.daos;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.zensar.jobcentral.entities.Company;


/**
 * @author Priya Mirchandani
 * @creation_date 7 october 2019 6.52pm
 * @modification_date 7 october 2019 6.52pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoimpl class using persistance layer
 *
 */
@Repository
public class CompanyDaoImpl extends DaoAssistant implements CompanyDao {
	
	@Override
	public List<Company> getAllCompanies() {
		try 
		{
			beginTx();
			Query query = getCurrentSession().createQuery("From  Company");
			List<Company> listOfCompanies =  query.list();
			return listOfCompanies;
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
		
	}
	@Override
	public Company getByCompanyId(int companyId) {
		try 
		{
			beginTx();
			return getCurrentSession().get(Company.class, companyId);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}
	@Override
	public void insertCompany(Company company) {
		try
		{
			beginTx();
			getCurrentSession().save(company);
			commitTransaction();
			System.out.println("Debug: company having ID: " + company.getCompanyId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}
	@Override
	public void updateCompany(Company company) {
		try
		{
			beginTx();
			getCurrentSession().update(company);
			commitTransaction();
			System.out.println("Debug: company having ID: " +company.getCompanyId() + " has been updated successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}
	@Override
	public void deleteCompany(int companyId) {
		try
		{
			beginTx();
			getCurrentSession().delete(getByCompanyId(companyId));
			commitTransaction();
			System.out.println("Debug: company having ID: " + companyId + " has been deleted successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}
	
	
	
	
   
}
