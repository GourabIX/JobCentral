package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.Location;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Priya Mirchandani
 * @creation_date 7 october 2019 6.43pm
 * @modification_date 7 october 2019 6.43pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoimpl class using persistance layer
 *
 */
@Repository
public class LocationDaoImpl extends DaoAssistant  implements LocationDao{
	
	@Override
	public List<Location> getAllLocations() {
		try 
		{
			beginTx();
			Query query = getCurrentSession().createQuery("From Location");
			List<Location> listOfLocations = query.list();
			return listOfLocations;
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
		
	}
	@Override
	public Location getByLocationId(int locationId) {
		try 
		{
			beginTx();
			return getCurrentSession().get(Location.class, locationId);	
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		return null;
	}
	@Override
	public void insertLocation(Location location) {
		try
		{
			beginTx();
			getCurrentSession().save(location);
			commitTransaction();
			System.out.println("Debug: location  having ID: " + location.getLocationId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}
	@Override
	public void updateLocation(Location location) {
		try
		{
			beginTx();
			getCurrentSession().update(location);
			commitTransaction();
			System.out.println("Debug: location having ID: " + location.getLocationId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
	}
	@Override
	public void deleteLocation(Location location) {
		try
		{
			beginTx();
			getCurrentSession().delete(location);
			commitTransaction();
			System.out.println("Debug: location having ID: " + location.getLocationId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}