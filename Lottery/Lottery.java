import java.util.Scanner;
import java.util.Random;

public class Lottery {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) { 
            System.out.print("Enter in a two digit number: ");
            choice = scanner.nextInt();

            if (choice >= 10 && choice <= 99) {
                break;
            }
            else {
                System.out.println("Error: Digit must be 2 digits");
            }
        }

    
        Random random = new Random();
        int lottoNum = (random.nextInt(90) + 10);
        System.out.println("The lotto number is: " + lottoNum);

        if (isEqual(choice, lottoNum) == true) {
            System.out.println("YOU GOT IT!!!");
            System.out.println("You win the Jackpot of $10,000");
        }
        else if (isFlipped(choice, lottoNum) == true) {
            System.out.println("You got both digits correct.");
            System.out.println("You win $2,000");
        }
        else if (isSimilar(choice, lottoNum) == true) {
            System.out.println("You got one digit correct.");
            System.out.println("You win $500");
        }
        else {
            System.out.println("You did not win anything :(");
        }
    }

    public static boolean isEqual(int choice, int lottoNum) {
        if (choice == lottoNum) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isFlipped(int choice, int lottoNum) {
        int flippedNum = 10 * (lottoNum % 10) + (lottoNum / 10);
        if (choice == flippedNum) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isSimilar(int choice, int lottoNum) {
        int digit = choice % 10;
        for (int i = 0; i < 2; i++) {
            if (digit == lottoNum % 10 || digit == lottoNum / 10) {
                return true;
            }
            digit = choice / 10;
        }
        return false;
    }
}

