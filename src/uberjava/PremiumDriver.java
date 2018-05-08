package uberjava;

import uberjava.vehicles.Car;

import java.text.DecimalFormat;

public class PremiumDriver extends Driver {

    public PremiumDriver() {}

    public PremiumDriver(String name, Car car) {

        super(name, car);

    }

    @Override
    public String toString() {

        DecimalFormat df2 = new DecimalFormat(".##");

        return "Driver Completed Session Information (24 hours span) { " + "\n" +
                "Driver Name = " + name + " \n" +
                car + " \n" +
                "This driver IS a UberJavaX Premium: \n" +
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
