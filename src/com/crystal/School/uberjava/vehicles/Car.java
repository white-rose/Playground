package com.crystal.School.uberjava.vehicles;

import com.crystal.School.uberjava.Location;
import com.crystal.School.uberjava.LocationEnum;

public class Car extends Vehicle {

    private String name, location, make;
    private int year;
    private LocationEnum currentLocation;
    private Boolean parked;
    private int distance;
    private float carFuel, mileage = 10;

    public Car() {
        currentLocation = LocationEnum.SAN_FRANCISCO;
    }

    public Car (String name, int year, String make) {
        this.name = name;
        this.year = year;
        this.make = make;
        this.location = LocationEnum.SAN_FRANCISCO.getLocation();
        //Each Driver starts in San Francisco
        this.currentLocation = LocationEnum.SAN_FRANCISCO;
    }

    public Car(String name, int year, String make, Location location) {
        this.name = name;
        this.year = year;
        this.make = make;
        this.location = LocationEnum.SAN_FRANCISCO.getLocation();
        //Each Driver starts in San Francisco
        this.currentLocation = LocationEnum.SAN_FRANCISCO;
    }

    //constructor
    public Car (String carName, String carLocation) {
        name = carName;
        location = carLocation;
        parked = true;
        distance = 0;
        carFuel = 0.0f;
    }

    public String getName() {
        return name;
    }

    boolean isParked() {
        return false;
    }

    //refueling car
    void totalFuel(float fl) {
        carFuel = carFuel + fl;
    }

    //show available fuel in the car
    void availableFuel() {
        carFuel = carFuel - (distance / mileage);
        System.out.println("Fuel left in car: "+ carFuel + " gallons");
    }

    @Override
    void driveForward(Location location) {
        parked = false;
        super.driveForward(location);
    }

    //drive car
    private void driveForward(String toWhere, int mile) {
        distance = distance + mile;
        parked = false;
        location = toWhere;
        System.out.println("Driving to " + toWhere + ": " + mile + " miles away");
        super.driveForward(new Location());
    }

    //park car
    private void park() {
        parked = true;
        System.out.println("Parking the car");
    }

    public LocationEnum getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(LocationEnum currentLocation) {
        this.currentLocation = currentLocation;
    }

    static Car[] getCars() {
        return new Car[1];
    }

    @Override
    public String toString() {
        return "Car{" +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", distance=" + distance +
                ", carFuel=" + carFuel +
                ", mileage=" + mileage +
                '}';
    }

}
