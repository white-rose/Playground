package uberjava;

public class Rider {

    private String name;
    private int totalFares;
    private double totalAmountPaid;
    private int totalMinutesSpentOnUber;

    public Rider(String name, int totalFares, double totalAmountPaid, int totalMinutesSpentOnUber) {
        this.name = name;
        this.totalFares = totalFares;
        this.totalAmountPaid = totalAmountPaid;
        this.totalMinutesSpentOnUber = totalMinutesSpentOnUber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalFares() {
        return totalFares;
    }

    public void setTotalFares(int totalFares) {
        this.totalFares = totalFares;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public int getTotalMinutesSpentOnUber() {
        return totalMinutesSpentOnUber;
    }

    public void setTotalMinutesSpentOnUber(int totalMinutesSpentOnUber) {
        this.totalMinutesSpentOnUber = totalMinutesSpentOnUber;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "name='" + name + '\'' +
                ", totalFares=" + totalFares +
                ", totalAmountPaid=" + totalAmountPaid +
                ", totalMinutesSpentOnUber=" + totalMinutesSpentOnUber +
                '}';
    }
}
