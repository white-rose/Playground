package com.crystal.School.uberjava;

public class DistanceRequest {

    private String distance;
    private String tollsAmount;
    private int minutes;
    private int minutesFromStartingToPickup;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTollsAmount() {
        return tollsAmount;
    }

    public void setTollsAmount(String tollsAmount) {
        this.tollsAmount = tollsAmount;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutesFromStartingToPickup() {
        return minutesFromStartingToPickup;
    }

    public void setMinutesFromStartingToPickup(int minutesFromStartingToPickup) {
        this.minutesFromStartingToPickup = minutesFromStartingToPickup;
    }

    @Override
    public String toString() {
        return "DistanceRequest for request ride{" +
                "distance='" + distance + '\'' +
                ", tollsAmount='" + tollsAmount + '\'' +
                ", minutes=" + minutes +
                ", minutesFromStartingToPickup=" + minutesFromStartingToPickup +
                '}';
    }
}
