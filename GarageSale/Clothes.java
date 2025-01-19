// Contains all necessary information for each object, and implements Entry interface for generalized method calling

public class Clothes implements Entry {
    // Instance variables
    private String seller = null;
    private double price = 0.0;

    private double totalProfit = 0.0;
    private int totalSold = 0;

    // Constructor
    public Clothes(String seller, double price) {
        this.seller = seller;
        this.price = price;
    }

    // Getters, setters, and basic incrementation
    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void incrementTotalProfit(double price) {
        totalProfit += price;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void incrementTotalSold() {
        totalSold++;
    }
}
