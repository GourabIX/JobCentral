package com.zensar.jobcentral.services;

import java.util.List;

import com.zensar.jobcentral.daos.LocationDao;
import com.zensar.jobcentral.entities.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author: Chaithrodaya B S
 * @creation_date: 12th Oct 2019 12.20 AM
 * @modification_date: 12th Oct 2019 12.50 AM
 * @version: 2.0
 * @copyright Zensar Technologies. All Rights Reserved
 * @description: It is a  locationService Implementation class used in business layer.
 * 				
 *
 */

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;
	
	@Override
	public List<Location> findAllLocations() {

		List<Location> list = locationDao.getAllLocations();
		return list;
	}

	@Override
	public Location findByLocationId(int locationId) {
		
		return locationDao.getByLocationId(locationId);
	}

	@Override
	public void insertLocation(Location location) {
		
		locationDao.insertLocation(location);

	}

	@Override
	public void updateLocation(Location location) {
		
		locationDao.updateLocation(location);
	}

	@Override
	public void deleteLocation(Location location) {
		
		locationDao.deleteLocation(location);
	}

	@Override
	public Location findByCityState(String city, String state) {
		
		List<Location> allLocations = findAllLocations();
		for (Location location : allLocations)
		{
			if (location.getCity().equals(city) && location.getState().equals(state))
			{
				return location;
			}
		}
		return null;
	}

}
