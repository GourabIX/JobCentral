package com.zensar.jobcentral.daos;
import java.util.List;

/**
 * @author Priya Mirchandani
 * @creation_date 7 october 2019 6.52pm
 * @modification_date 7 october 2019 6.52pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a dao class using persistance layer
 *
 */
import com.zensar.jobcentral.entities.Company;

public interface CompanyDao {
	List<Company>getAllCompanies();
	Company getByCompanyId(int companyId);
	void insertCompany(Company company);
	void updateCompany(Company company);
	void deleteCompany(int companyId);
}
