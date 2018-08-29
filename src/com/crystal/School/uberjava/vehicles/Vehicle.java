package com.crystal.School.uberjava.vehicles;

import com.crystal.School.uberjava.Location;
import com.crystal.School.uberjava.exceptions.ValueUndefinedException;

public abstract class Vehicle {

    private Location currentLocation;
    //the amount spent to initially buy the Vehicle
    private Integer purchaseCost;
    //how many miles the Vehicle can travel on a gallon of gas.
    private Integer milesPerGallon;

    Vehicle() {

    }


    Vehicle (String make, String model, String year) {
        this.milesPerGallon = null;
        this.purchaseCost = null;
    }

    void driveForward(Location location) {

    }

    public Integer getPurchaseCost() throws ValueUndefinedException {
        if (this.purchaseCost == null) {
            throw new ValueUndefinedException();
        }
        return purchaseCost;
    }

    public void setPurchaseCost(Integer purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Integer getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(Integer milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }
}
