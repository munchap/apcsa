import java.util.Scanner;

public class IPAddress {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int[] octetInts = null;
            String[] octets = null;

            while (true) {
                System.out.print("Enter full IP Address (4 octets): ");
                String address = scanner.nextLine();
        
                String regex = "[.]";  
                octets = address.split(regex);
                octetInts = new int[octets.length];

                if (octets.length != 4) {
                    System.out.println("Error: Must be 4 octets");
                }
                else {
                    break;
                }
            }
    
            for (int i = 0; i < octets.length; i++) {
                octetInts[i] = Integer.parseInt(octets[i]);
                if ((checkValid(octetInts[i])) == false) {
                    System.out.println("Octet " + (i + 1) + " is incorrect");
                }
        }
    }
    
    public static boolean checkValid(int octet) {
        if (octet >= 0 && octet <= 255) {
            return true;
        }
        else {
            return false;
        }
    }
}