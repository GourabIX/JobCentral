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

import com.zensar.jobcentral.entities.Admin;
import com.zensar.jobcentral.entities.Location;

public interface LocationDao {

	List<Location>getAll();
	Location getById(int locationId);
	void insert(Location location);
	void update(Location location);
	void delete(Location location);
		
}
