package Projects.Palindrome;
import java.util.Scanner;

public class Palindrome {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter string: ");
        String input = scan.nextLine();

        String[] in = input.split("");
        String[] out = input.split("");

        for (int i = 0; i < input.length(); i++) {
            out[i] = in[input.length() - i - 1];
        }

        String output = String.join("", out);
        System.out.println(output);

        if (output.equals(input)) {
            System.out.println("Palindome");
        }
        else {
            System.out.println("Not a palindrome");
        }
    }
}
