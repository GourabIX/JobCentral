package com.zensar.jobcentral.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Company;
import com.zensar.jobcentral.entities.Login;

/**
 * @author Priya Mirchandani
 * @creation_date 7 october 2019 6.52pm
 * @modification_date 7 october 2019 6.52pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoimpl class using persistance layer
 *
 */
public class CompanyDaoImpl implements CompanyDao {
	private Session session;
	public CompanyDaoImpl() {
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		session=f.openSession();
	}
	@Override
	public List<Company> getAll() {
		
		Query q=session.createQuery("from Company");
		return q.getResultList();
	}
	@Override
	public Company getById(int companyId) {
		return session.get(Company.class, companyId);
	}
	@Override
	public void insert(Company company) {
		Transaction t=session.beginTransaction();
		session.save(company);
		t.commit();
		
	}
	@Override
	public void update(Company company) {
		Transaction t=session.beginTransaction();
		session.update(company);
		t.commit();
		
	}
	@Override
	public void delete(Company company) {
		Transaction t=session.beginTransaction();
		session.delete(company);
		t.commit();
		
	}
	
	
	
	
   
}
