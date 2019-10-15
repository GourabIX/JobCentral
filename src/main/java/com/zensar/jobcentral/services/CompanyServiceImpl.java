package com.zensar.jobcentral.services;

import java.util.List;
import com.zensar.jobcentral.services.CompanyService;
import com.zensar.jobcentral.daos.CompanyDao;
import com.zensar.jobcentral.entities.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author: Chaithrodaya B S
 * @creation_date: 4th Oct 2019 10.05 AM
 * @modification_date: 12th Oct 2019 12.55 AM
 * @version: 3.0
 * @copyright Zensar Technologies. All Rights Reserved
 * @description: It is a  CompanyService Implementation used in business layer.
 * 				
 *
 */

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> getAllCompanies() {
	
		List<Company> list = companyDao.getAll();
		return list;
	}

	@Override
	public Company findById(int companyId) {
		
		return companyDao.findById(companyId);
		
	}

	@Override
	public void insertCompany(Company company) {
		
		companyDao.insert(company);

	}

	@Override
	public void updateCompany(Company company) {
	
		companyDao.update(company);

	}

	@Override
	public void deleteCompany(Company company) {
	
		companyDao.delete(company);

	}

}
