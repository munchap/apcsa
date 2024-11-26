import java.util.Scanner;

public class mathclass {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a number to select a program:");
        System.out.println("0 = abs");
        System.out.println("1 = circle");
        System.out.println("2 = quad");
        System.out.println("3 = round");
        System.out.println("4 = trig");
        int choice = scanner.nextInt();

        switch (choice) {
            case 0 -> abs.absMain();
            case 1 -> circle.circleMain();
            case 2 -> quad.quadMain();
            case 3 -> round.roundMain();
            case 4 -> trig.trigMain();
            default -> System.out.println("Invalid number");    
        }
    }
}
