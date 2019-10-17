package com.zensar.jobcentral.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
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
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Company> getAllCompanies() {
		try 
		{
			return (List<Company>) hibernateTemplate.find("from Company");
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
			return hibernateTemplate.get(Company.class, companyId);	
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
			hibernateTemplate.save(company);
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
			hibernateTemplate.update(company);
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
			hibernateTemplate.delete(getByCompanyId(companyId));
			System.out.println("Debug: company having ID: " + companyId + " has been deleted successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}

	@Override
	public Company getByCompanyName(String companyName) {
		try 
		{
			return hibernateTemplate.get(Company.class, companyName);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}
	
}
