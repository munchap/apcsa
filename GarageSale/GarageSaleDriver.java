import java.util.Scanner;

public class GarageSaleDriver {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Type \"stop\" to continue.");
        String input = null;

        // Obtain user input until input is "stop"
        do {
            System.out.println("Enter type (clothes, electronics, general item), seller, and price.");
            input = scan.nextLine();
        } while (GarageSale.createCatalog(input));

        // Prints information about catalog items
        GarageSale.printCatalog();

        System.out.println("Type \"stop\" to continue.");
        input = null;

        // Obtain user input until input is "stop"
        do {
            System.out.println("Enter type (clothes, electronics, general item), seller, and price.");
            input = scan.nextLine();
        } while (GarageSale.calculateTransaction(input));

        // Prints final information for specifications
        GarageSale.printFinal();
    }
}
