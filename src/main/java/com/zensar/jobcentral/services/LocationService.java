package com.zensar.jobcentral.services;
import java.util.List;
import com.zensar.jobcentral.entities.Location;
/**
 * @author: Chaithrodaya B S
 * @creation_date: 12th Oct 2019 12.20 AM
 * @modification_date: 12th Oct 2019 12.20 AM
 * @version: 2.0
 * @copyright Zensar Technologies. All Rights Reserved
 * @description: It is a  locationService Interface used in business layer.
 * 				
 *
 */
public interface LocationService 
{
	List<Location> findAllLocations();
	Location findByLocationId(int locationId);
	void insertLocation(Location location);
	void updateLocation(Location location);
	void deleteLocation(Location location);
	Location findByCityState(String city, String state);
	
	
}
