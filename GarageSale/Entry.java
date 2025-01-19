// Interface allows for easy reuse of methods by generalizing functions for each class, removing need to run individual for-each loops for each class

public interface Entry {
    String getSeller();
    double getPrice();
    void incrementTotalProfit(double price);
    void incrementTotalSold();
    double getTotalProfit();
    int getTotalSold();

    // Print details for catalog
    default void printDetails(String category) {
        String seller = getSeller();
        double price = getPrice();
        System.out.println(seller + "'s " + category + " for $" + price);
    }

    // Increment values for final specifications
    default void incrementTotals(double price) {
        incrementTotalProfit(price);
        incrementTotalSold();
    }
} 