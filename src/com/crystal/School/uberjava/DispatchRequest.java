package com.crystal.School.uberjava;

public class DispatchRequest {

    private String RideNumber;
    private String RiderFirstName;
    private String RiderLastName;
    private String numOfPeople;
    private String pickupLocation;
    private String dropoffLocation;
    private Double fare;
    //    Float fareDriverKeep;
//    Float fareSacrficed;
    private String distanceTimeTollUrl;
    private String completionUrl;

    public DispatchRequest() {
    }

    @Override
    public String toString() {
        return "Dispatch Request details { \n" +
                "RideNumber=" + getRideNumber() + "\n" +
                ", RiderFirstName= " + getRiderFirstName() + "\n" +
                ", RiderLastName= " + getRiderLastName() + "\n" +
                ", numOfPeople= " + getNumOfPeople() + "\n" +
                ", pickupLocation= " + getPickupLocation() + "\n" +
                ", dropoffLocation= " + getDropoffLocation() + "\n" +
                ", fare= " + getFare() + "\n" +
                ", distanceTimeTollUrl= " + getDistanceTimeTollUrl() + "\n" +
                ", completionUrl= " + getCompletionUrl() + "\n" +
                '}';
    }

    public String getCompletionUrl() {
        return completionUrl;
    }

    public void setCompletionUrl(String completionUrl) {
        this.completionUrl = completionUrl;
    }

    public String getRideNumber() {
        return RideNumber;
    }

    public void setRideNumber(String rideNumber) {
        RideNumber = rideNumber;
    }

    public String getRiderFirstName() {
        return RiderFirstName;
    }

    public void setRiderFirstName(String riderFirstName) {
        RiderFirstName = riderFirstName;
    }

    public String getRiderLastName() {
        return RiderLastName;
    }

    public void setRiderLastName(String riderLastName) {
        RiderLastName = riderLastName;
    }

    public String getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(String numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getDistanceTimeTollUrl() {
        return distanceTimeTollUrl;
    }

    public void setDistanceTimeTollUrl(String distanceTimeTollUrl) {
        this.distanceTimeTollUrl = distanceTimeTollUrl;
    }
}
