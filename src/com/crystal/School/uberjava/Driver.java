package com.crystal.School.uberjava;

import com.crystal.School.uberjava.vehicles.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

import static com.crystal.School.uberjava.UberJavaMain.issueRequest;
import static com.crystal.School.uberjava.UberJavaMain.riders;

public class Driver {

    //TODO: Encapsulate to private variables
    UberJavaSession session;
    String name;
    Car car;
    int totalFares;
    int timeTravled;
    float fareEarned;
    int totalMilesDriven;
    Double costs;

    DispatchRequest dispatchRequest;
    DistanceRequest distanceRequest;

    public Driver() {
    }

    public Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    int startSession() throws IllegalStateException {
        UberJavaSession newSession = new UberJavaSession();

        while (this.timeTravled < 1440) {
            try {
                //Get Fare Request
                String reqestedFareResponse = this.requestNewFare();
                //Set Dispatch Request for driver
                parseFareRequest(reqestedFareResponse, this);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Get distance from pickup to dropoff
            parseDistanceCalculation(this);

            if (isRidePossible(this)) {
                //Complete and Record Ride
                completeRide(this);
            } else {
                //Notify Uber the ride could not be completed
                String rejectionUrl = Constants.rejectionUrl + dispatchRequest.getRideNumber();
                issueRequest(rejectionUrl, new String[5]);
                System.out.println("The ride cannot be completed in time, getting another request");
            }

            UberStatistics sessionStatistics = new UberStatistics();
            sessionStatistics.setMilesDriven(this.totalMilesDriven);
        }

        this.session = newSession;
        endSession();
        return newSession.getSessionNumber();

    }

    int endSession() throws IllegalStateException {
        this.session.setActive(false);
        return this.session.getSessionNumber();
    }

    String requestNewFare() throws IOException {

        String[] tokens = new String[18];
        int numLines = 0;
        String fareRequestUrl = Constants.fareRequestsURL + name;
        URL url = new URL(Constants.fareRequestsURL);
        URLConnection connect = url.openConnection();
        InputStream inputStream = connect.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
            tokens[numLines] = line;
            numLines++;
        }

        //Parse for Url requests
        parseDriverFareRequest(tokens);

        return sb.toString();

    }

    void parseFareRequest(String response, Driver driver) {

        int inx = response.indexOf("Ride");
        String rideNumber = response.substring(inx + 6, inx + 16);
        boolean isUberJavaXPremium = response.startsWith("[UberJavaX Premium]", inx + 11);
        inx = response.indexOf("Rider: ", inx + 16);
        int inx2 = response.indexOf("</b>", inx);
        String riderName = response.substring(inx + 7, inx2);
        String riderFirstName = riderName.split(" ")[0];
        String riderLastName = riderName.split(" ")[1];
        inx = response.indexOf("<br/>\n", inx2);
        inx2 = response.indexOf(" people");
        if (inx2 == -1) {
            inx2 = response.indexOf(" person", inx2 - 1);
        }
        String numberOfPeopleRiding = response.substring(inx2 - 1, inx2 + 1);
        inx = response.indexOf("Going FROM ", inx2);
        inx2 = response.indexOf(" to ", inx);
        String from = response.substring(inx + 11, inx2);
        inx = inx2 + 4;
        inx2 = response.indexOf("<br/>", inx);
        String to = response.substring(inx, inx2);
        boolean isDoubleSurgePricing = response.indexOf("DOUBLE SURGE PRICING IN EFFECT", inx2) != -1;
        boolean isSurgePricing = !isDoubleSurgePricing && response.indexOf("SURGE PRICING IN EFFECT", inx2) != -1;
        inx = response.indexOf("Fare is $", inx2);
        inx2 = response.indexOf("<br/>", inx);
        double fare = Double.parseDouble(response.substring(inx + 9, inx2));

        driver.dispatchRequest.setRideNumber(rideNumber);
        driver.dispatchRequest.setNumOfPeople(numberOfPeopleRiding);
        driver.dispatchRequest.setRiderFirstName(riderFirstName);
        driver.dispatchRequest.setRiderLastName(riderLastName);
        driver.dispatchRequest.setPickupLocation(from);
        driver.dispatchRequest.setDropoffLocation(to);
        driver.dispatchRequest.setFare(fare);

        System.out.println(driver.dispatchRequest.toString());

    }

    private void parseDriverFareRequest(String[] response) {

        this.dispatchRequest = new DispatchRequest();
        String distanceUrl = response[11];
        this.dispatchRequest.setCompletionUrl(response[15]);
        this.dispatchRequest.setDistanceTimeTollUrl(distanceUrl.substring(49, 115));
        this.dispatchRequest.setCompletionUrl(this.dispatchRequest.getCompletionUrl().substring(48, 112));

    }


    String[] calculateDistanceFromPickupToDropoff(String distanceUrl) {

        String[] tokens = new String[11];
        return issueRequest(distanceUrl, tokens);

    }

    //Find if Driver is able to pick up passenger in time
    static boolean isRidePossible(Driver driver) {

        String distanceFromStartingPickupUrl = Constants.distanceFromStartingLocation +
                driver.dispatchRequest.getRideNumber() +
                "&start=" + driver.car.getCurrentLocation().getLocation();

        String[] tokens = new String[11];

        int timeFromStartingToPickup;

        try {
            timeFromStartingToPickup = parseStartingToPickupRequest(issueRequest(distanceFromStartingPickupUrl, tokens));
        } catch (NullPointerException ex) {
            //Starting Location is same as Pickup so the ride is possible
            return true;
        }

        if (timeFromStartingToPickup > 300) {
            //Cannot pick up person within 300 minutes
            return false;
        } else {
            driver.distanceRequest.setMinutesFromStartingToPickup(timeFromStartingToPickup);
            return true;
        }

        //Information about distance from starting to pickup
        //System.out.println(sb.toString());

    }

    static int parseStartingToPickupRequest(String[] response) {

        int timeStartingtoPickup = 0;

        //Starting location cannot be same as pickup
        try {
            timeStartingtoPickup = Integer.valueOf(response[10].substring(response[10].indexOf("take ") + 5, response[10].indexOf(" minutes")));
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        return timeStartingtoPickup;

    }

    static DistanceRequest parseDistanceCalculation(Driver driver) {

        String[] response = driver.calculateDistanceFromPickupToDropoff(driver.dispatchRequest.getDistanceTimeTollUrl());
        DistanceRequest distanceRequest = new DistanceRequest();
        distanceRequest.setDistance(response[5].substring(response[5].indexOf("Distance: ") + 9, response[5].indexOf(" miles")).replaceAll(" ", ""));
        distanceRequest.setTollsAmount(response[6].substring(response[6].indexOf("Tolls: $") + 8, response[6].indexOf("<")));
        distanceRequest.setMinutes(Integer.valueOf(response[7].substring(response[7].indexOf("Minutes: ") + 9, response[7].indexOf("<br"))));

        driver.distanceRequest = distanceRequest;

        return driver.distanceRequest;

    }

    static void completeRide(Driver driver) {

        String completionUrl = Constants.completionUrl + driver.dispatchRequest.getRideNumber();
        System.out.println("Completion URL: " + completionUrl);
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(completionUrl);
            URLConnection connect = url.openConnection();
            InputStream inputStream = connect.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Expand details for Driver on completing the ride
        driver.fareEarned += driver.dispatchRequest.getFare() * 0.75;
        driver.timeTravled += driver.distanceRequest.getMinutes();
        driver.timeTravled += driver.distanceRequest.getMinutesFromStartingToPickup();
        driver.totalMilesDriven += Integer.valueOf(driver.distanceRequest.getDistance());
        driver.car.setCurrentLocation(LocationEnum.valueOf(driver.dispatchRequest.getDropoffLocation().toUpperCase().replaceAll(" ", "_")));
//        driver.costs += Integer.valueOf(driver.distanceRequest.getTollsAmount());
        driver.totalFares += 1;

        //Expand details for the rider on completing the rider

        riders.add(new Rider(
                driver.dispatchRequest.getRiderFirstName() + " " + driver.dispatchRequest.getRiderLastName(),
                driver.totalFares,
                driver.dispatchRequest.getFare(),
                driver.distanceRequest.getMinutes()
        ));

//      issueRequest(completionUrl, new String[10]);

    }

    UberStatistics getSessionStatistics() {
        return this.session.getUberStatistics();
    }

    UberStatistics getSesstionStatistics() {
        return new UberStatistics();
    }

    Location getCurrentLocation() {
        return new Location();
    }

    int getSessionMinutes() throws IllegalStateException {
        return 0;
    }

    public int getTotalFares() {
        return totalFares;
    }

    public void setTotalFares(int totalFares) {
        this.totalFares = totalFares;
    }

    @Override
    public String toString() {

        DecimalFormat df2 = new DecimalFormat(".##");

        return "Driver Completed Session Information (24 hours span) { " + "\n" +
                "Driver Name = " + name + " \n" +
                car + " \n" +
                "This driver is NOT UberJavaX Premium: \n" +
                ", Total amount of fares given = " + totalFares + " \n" +
                ", Total fare earned = $" + df2.format(fareEarned) + " \n" +
                ", Total miles driven " + totalMilesDriven + " \n" +
                ", Total time traveled = " + timeTravled + " minutes" + " \n" +
                ", Total costs of operation (with a breakdown by type of costs) \n" +
                ", Average Rider Rating \n" +
                ", Effective Hourly Earnings after all costs are deducted \n" +
                '}';
    }
}

