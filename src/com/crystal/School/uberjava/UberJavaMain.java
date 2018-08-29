package com.crystal.School.uberjava;

import com.crystal.School.uberjava.vehicles.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class UberJavaMain {

    public static ArrayList<Rider> riders = new ArrayList<>();

    public static void main(String... args) {

        //Handles SSL Security
        SSLVerifcationPatch.applyPath();

        Driver driver1 = new Driver("Ben Kumquat", new Car(
                "Civic",
                2018,
                "Honda",
                new Location()));
        PremiumDriver driver2 = new PremiumDriver("Prateek", new Car(
                "Aventador",
                2018,
                "Lamborghini",
                new Location()));
        driver2.car.setMilesPerGallon(11);
        PremiumDriver driver3 = new PremiumDriver("Lauren", new Car(
                "911 Turbo S Cabriole",
                2017,
                "Porsche",
                new Location()));
        //Need tochange MPG to 12.5
        driver3.car.setMilesPerGallon(12);

        //Start a session (24 hours of driving)
        driver1.startSession();
        driver2.startSession();
        driver3.startSession();

        System.out.println(driver1.toString());
        System.out.println(driver2.toString());
        System.out.println(driver3.toString());

        System.out.println("Details on the Riders who rode an Uber: ");
        for (Rider rider : riders) {
            System.out.println(rider.toString());
        }

    }

    public static String[] issueRequest(String requestUrl, String[] tokens) {

        System.out.println("Request url is " + requestUrl);

        int lines = 0;
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(requestUrl);
            URLConnection connect = url.openConnection();
            InputStream inputStream = connect.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                tokens[lines] = line;
                lines++;
            }

//            System.out.println(sb.toString());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return tokens;
    }
}


