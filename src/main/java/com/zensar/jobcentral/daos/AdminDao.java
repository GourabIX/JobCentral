package com.zensar.jobcentral.daos;
/**
 * @author Priya Mirchandani
 * @creation_date 5 october 2019 5.36pm
 * @modification_date 5 october 2019 5.36pm
 * @version 1.0
 * @copyright Zensar Technologies.all rights reserved
 * @description it is a dao class using persistance layer
 *
 */
import java.util.List;

import com.zensar.jobcentral.entities.Admin;

public interface AdminDao {
	
List <Admin>getAll();
Admin getById(int userId);
void insert(Admin admin);
void update(Admin admin);
void delete(Admin admin);
	
	
}
