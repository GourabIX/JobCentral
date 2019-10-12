package com.zensar.jobcentral.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Location;

/**
 * @author Priya Mirchandani
 * @creation_date 7 october 2019 6.43pm
 * @modification_date 7 october 2019 6.43pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoimpl class using persistance layer
 *
 */
public class LocationDaoImpl implements LocationDao{
	private Session session;
	public LocationDaoImpl() {
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		session=f.openSession();
}
	@Override
	public List<Location> getAll() {
		Query q=session.createQuery("from Location");
		return q.getResultList();
	}
	@Override
	public Location getById(int locationId) {
		return session.get(Location.class, locationId);
	}
	@Override
	public void insert(Location location) {
		Transaction t=session.beginTransaction();
		session.save(location);
		t.commit();
		
	}
	@Override
	public void update(Location location) {
		Transaction t=session.beginTransaction();
		session.update(location);
		t.commit();
		
	}
	@Override
	public void delete(Location location) {
		Transaction t=session.beginTransaction();
		session.delete(location);
		t.commit();
		
	}
	
	
	
	
	
	
	
}