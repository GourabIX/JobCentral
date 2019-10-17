package com.zensar.jobcentral.daos;

import java.util.List;

import com.zensar.jobcentral.entities.Location;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
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
public class LocationDaoImpl  implements LocationDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Location> getAllLocations() {
		try 
		{
			return (List<Location>) hibernateTemplate.find("from Location");
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
			return hibernateTemplate.get(Location.class, locationId);	
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
			hibernateTemplate.save(location);
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
			hibernateTemplate.update(location);
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
			hibernateTemplate.delete(location);
			System.out.println("Debug: location having ID: " + location.getLocationId() + " has been saved successfully.");
		}
		catch (HibernateException hbexc) 
		{
			hbexc.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}