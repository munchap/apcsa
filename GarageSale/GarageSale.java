import java.util.ArrayList;
import java.util.HashMap;

public class GarageSale {
    // ArrayLists to store objects for sale
    private static ArrayList<Clothes> ClothesList = new ArrayList<>();
    private static ArrayList<Electronics> ElectronicsList = new ArrayList<>();
    private static ArrayList<GeneralItems> GeneralItemsList = new ArrayList<>();

    // HashMaps to store information per seller
    private static HashMap<String, Double> sellerProfit = new HashMap<>();
    private static HashMap<String, Integer> sellerSold = new HashMap<>();

    // Store information for final specifications
    private static double sellerTotalProfit = 0.0;
    private static int sellerTotalSold = 0;
    private static double totalProfit = 0.0;
    
    // Create catalog of items, taking in user input. Returns false if input is "stop", otherwise true
    public static boolean createCatalog(String input) {
        if (input.equalsIgnoreCase("stop"))
            return false;

        // Unnecessary basic error handling
        try {
            // Split input into easy to work with information
            String[] splitInput = input.split(",");
            String category = splitInput[0].toUpperCase().trim();
            String seller = splitInput[1].toUpperCase().trim();
            double price = Double.parseDouble(splitInput[2]);

            // Add objects based on category selected by input, and store them into respective ArrayLists
            switch (category) {
                case "CLOTHES":
                    Clothes clothesEntry = new Clothes(seller, price);
                    ClothesList.add(clothesEntry);
                    break;

                case "ELECTRONICS":
                    Electronics electronicsEntry = new Electronics(seller, price);
                    ElectronicsList.add(electronicsEntry);
                    break;

                case "GENERAL ITEM":
                    GeneralItems generalItemsEntry = new GeneralItems(seller, price);
                    GeneralItemsList.add(generalItemsEntry);
                    break;
                
                // Unnecessary basic error handling
                default:
                    System.out.println("Invalid item type.");
            }
            // Create HashMap keys for name of sellers
            sellerProfit.put(seller, 0.0);
            sellerSold.put(seller, 0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    // Calls private method printDetails for each category
    public static void printCatalog() {
        printDetails(ClothesList, "clothes");
        printDetails(ElectronicsList, "electronics");
        printDetails(GeneralItemsList, "general items");
    }

    // Called by printCatalog() to print catalog info for each category
    private static void printDetails(ArrayList<? extends Entry> entries, String category) {
        System.out.println(category + ": ");
        for (Entry entry : entries) {
            String seller = entry.getSeller();
            double price = entry.getPrice();
            System.out.println(seller + "'s " + category + " for $" + price);
        }
    }

    // Handles transactions prompted by user input, works similarly to createCatalog
    public static boolean calculateTransaction(String input) {
        if (input.equalsIgnoreCase("stop"))
            return false;
        // Plenty of handling incorrect user input, not required but makes me happy
        try {
            String[] splitInput = input.split(",");
            String category = splitInput[0].toUpperCase().trim();
            String seller = splitInput[1].toUpperCase().trim();
            double price = Double.parseDouble(splitInput[2]);

            boolean matched = false;
            // Calculates transactions based on category selection from user input.
            switch (category) {
                case "CLOTHES": 
                    matched = incrementTotals(ClothesList, "clothes", seller, price);
                    break;

                case "ELECTRONICS":
                    matched = incrementTotals(ElectronicsList, "electronics", seller, price);
                    break;

                case "GENERAL ITEMS":
                    matched = incrementTotals(GeneralItemsList, "general items", seller, price);
                    break;
                default:
                    System.out.println("Invalid item type.");
                    break;
            }
            if (!matched)
                System.out.println("Item not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    // Called by calculateTransaction() to increment and print number and profit of items for each category, returns false if no categories match user input
    private static boolean incrementTotals(ArrayList<? extends Entry> entries, String category, String seller, double price) {
        for (Entry entry : entries) {
            if (entry.getSeller().equals(seller) && entry.getPrice() == price) {
                entry.incrementTotalProfit(price);
                entry.incrementTotalSold();

                double totalProfit = entry.getTotalProfit();
                int totalSold = entry.getTotalSold();

                System.out.println("Total " + category + " sold: " + totalSold);
                System.out.println("Total " + category + " profit: $" + totalProfit);
                return true;
            }
        }
        return false;
    }

    // Prints all required final information for specifications
    public static void printFinal() {
        printCategoryInformation(ClothesList, "clothes");
        printCategoryInformation(ElectronicsList, "electronics");
        printCategoryInformation(GeneralItemsList, "general items");

        for (String seller : sellerProfit.keySet()) {
            printPersonInformation(seller);
        }

        System.out.println("Total profit for garage sale: $" + totalProfit);
    }

    // Called by printFinal() to print all information regarding totals for each category
    private static void printCategoryInformation(ArrayList<? extends Entry> entries, String category) {
        double totalCategoryProfit = 0.0;
        int totalCategorySold = 0;
        for (Entry entry : entries) {
            totalCategoryProfit += entry.getTotalProfit();
            totalCategorySold += entry.getTotalSold();
        }
        System.out.println(totalCategorySold + " " + category + " sold for $" + totalCategoryProfit);
    }

    // Called by printFinal() to print all information regarding totals for each seller, as well as calculating total profit from garage sale
    private static void printPersonInformation(String seller) {
        sellerTotalProfit = 0.0;
        sellerTotalSold = 0;

        incrementPersonTotals(ClothesList, seller);
        incrementPersonTotals(ElectronicsList, seller);
        incrementPersonTotals(GeneralItemsList, seller);

        sellerProfit.put(seller, sellerTotalProfit);
        sellerSold.put(seller, sellerTotalSold);
        totalProfit += sellerTotalProfit;
    
        System.out.println(seller + " sold " + sellerTotalSold + " items for $" + sellerTotalProfit);
    }
    
    // Called by printPersonInformation() to increment items sold and profit for each seller
    private static void incrementPersonTotals(ArrayList<? extends Entry> entries, String seller) {
        for (Entry entry : entries) {
            if (entry.getSeller().equals(seller)) {
                sellerTotalProfit += entry.getTotalProfit();
                sellerTotalSold += entry.getTotalSold();
            }
        }
    }
}
