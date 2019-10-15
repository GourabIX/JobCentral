package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.entities.Company;

/**
 * @author: Chaithrodaya B S
 * @creation_date: 12th Oct 2019 12.05 AM
 * @modification_date: 12th Oct 2019 12.05 AM
 * @version: 2.0
 * @copyright Zensar Technologies. All Rights Reserved
 * @description: It is a  companyService Interface used in business layer.
 * 				
 *
 */

public interface CompanyService 
{
	List<Company> getAllCompanies();
	Company findById(int companyId);
	void insertCompany(Company company);
	void updateCompany(Company company);
	void deleteCompany(Company company);
}
