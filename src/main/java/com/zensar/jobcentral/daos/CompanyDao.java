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
import com.zensar.jobcentral.entities.Login;

public interface CompanyDao {
	List<Company>getAll();
	Company getById(int companyId);
	void insert(Company company);
	void update(Company company);
	void delete(Company company);
}
