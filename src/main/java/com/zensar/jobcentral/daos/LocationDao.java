package com.zensar.jobcentral.daos;
/**
 * @author Priya Mirchandani
 * @creation_date 7 october 2019 5.37pm
 * @modification_date 7 october 2019 5.37pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a daoclass using persistance layer
 *
 */
import java.util.List;


import com.zensar.jobcentral.entities.Location;

public interface LocationDao {

	List<Location>getAllLocations();
	Location getByLocationId(int locationId);
	void insertLocation(Location location);
	void updateLocation(Location location);
	void deleteLocation(Location location);
		
}
