package com.zensar.jobcentral.entities;

/**
 * @author Gourab Sarkar
 * @modification_date 07 Oct 2019 20:08
 * @creation_date 01 Oct 2019 21:02
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the persistent Admin Class (operates in Persistence layer)
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Login login;
	
	@OneToOne
	@JoinColumn(name = "locationId")
	private Location location;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", login=" + login + ", location=" + location + "]";
	}

}
