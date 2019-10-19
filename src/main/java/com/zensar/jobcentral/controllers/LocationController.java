package com.zensar.jobcentral.controllers;

import java.util.List;

import com.zensar.jobcentral.entities.Location;
import com.zensar.jobcentral.services.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController
{

    @Autowired
    private LocationService locationService;

    @PostMapping("/locations/new")
    public String addNewLocation(@RequestParam("city") String city, @RequestParam("state") String state)
    {
        try
        {
            if (locationService.findByCityState(city, state) == null)
            {
                Location location = new Location();
                location.setCity(city);
                location.setState(state);
                locationService.insertLocation(location);
                System.err.println("Debug: New location for state: " + state + " and city: " + city + " has been added successfully.");
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
    public String updateLocation(@RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("city") String newCity, @RequestParam("state") String newState)
    {
        try
        {
            if (locationService.findByCityState(city, state) != null)
            {
                Location location = locationService.findByCityState(city, state);
                location.setCity(newCity);
                location.setState(newState);
                locationService.updateLocation(location);
                System.err.println("Debug: Location for state: " + state + " and city: " + city + " has been updated successfully.");
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
    public String deleteLocation(@RequestParam("locationId") int locationId, @RequestParam("city") String city, @RequestParam("state") String state)
    {
        try
        {
            if (locationService.findByCityState(city, state) != null)
            {
                Location location = locationService.findByCityState(city, state);
                locationService.deleteLocation(location);
                System.err.println("Location with state: " + state + " and city: " + city + " has been deleted successfully.");
                return "jobcentral_home";
            }
            else
            {
                System.err.println("No such location with state: " + state + " and city: " + city + " exists in the database!");
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

    @GetMapping("/locations/cityAndStateFiltered")
    public Location findLocationByCityState(@RequestParam("city") String city, @RequestParam("state") String state)
    {
        try
        {
            locationService.findByCityState(city, state);
        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
        }
        return null;
    }

}