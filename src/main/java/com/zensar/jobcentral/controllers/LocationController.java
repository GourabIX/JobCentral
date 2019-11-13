package com.zensar.jobcentral.controllers;

import java.util.List;

import com.zensar.jobcentral.entities.Location;
import com.zensar.jobcentral.services.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController
{

    @Autowired
    private LocationService locationService;

    @PostMapping("/locations/new")
    public String addNewLocation(@RequestBody Location location)
    {
        try
        {
            if (locationService.findByCityState(location.getCity(), location.getState()) == null)
            {
                locationService.insertLocation(location);
                System.err.println("Debug: New location for state: " + location.getState() + " and city: " + location.getState() + " has been added successfully.");
                return "jobcentral_home";
            }
            else
            {
                System.err.println("Location already exists in database. Match confirmed.");
            }
        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
        }
        return "errorPage";
    }

    @PutMapping("/locations/update")
    public String updateLocation(@RequestBody Location location)
    {
        try
        {
            if (locationService.findByCityState(location.getCity(), location.getState()) != null)
            {
                locationService.updateLocation(location);
                System.err.println("Debug: Location for state: " + location.getState() + " and city: " + location.getCity() + " has been updated successfully.");
                return "jobcentral_home";
            }
            else
            {
                System.err.println("Location does not exist in the database. Location must be added before updating it!");
            }
        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
        }
        return "errorPage";
    }

    @DeleteMapping("/locations/delete")
    public String deleteLocation(@RequestBody Location location)
    {
        try
        {
            if (locationService.findByCityState(location.getCity(), location.getState()) != null)
            {
                locationService.deleteLocation(location);
                System.err.println("Location with state: " + location.getState() + " and city: " + location.getCity() + " has been deleted successfully.");
                return "jobcentral_home";
            }
            else
            {
                System.err.println("No such location with state: " + location.getState() + " and city: " + location.getCity() + " exists in the database!");
            }
        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
        }
        return "errorPage";
    }

    @GetMapping("/locations/getAllLocations")
    public List<Location> findAllLocations()
    {
        try
        {
            return locationService.findAllLocations();
        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
        }
        return null;
    }

    @GetMapping("/locations/cityAndStateFiltered/{state}/{city}")
    public Location findLocationByCityState(@RequestParam("state") String state, @RequestParam("city") String city)
    {
        try
        {
            return locationService.findByCityState(city, state);
        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
        }
        return null;
    }

}