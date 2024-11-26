import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GradeCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter grade 0-100: ");
                double input = scanner.nextDouble();
                if (input >= 0 && input <= 100) {
                    System.out.println("Percent grade: " + input + "%");
                    System.out.println("Letter grade: " + calculateGrade(input));
                    break;
                }
                else {
                    System.out.println("Error: grade must be between 0 and 100.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: please enter a valid number.");
                scanner.next();
            }
        }
        scanner.close();
    }

    public static String calculateGrade(double percent) {

        ArrayList<String> grade = new ArrayList<>();

        if (percent >= 90) {
            grade.add("A");
        }
        else if (percent >= 80) {
            grade.add("B");
        }
        else if (percent >= 70) {
            grade.add("C");
        }
        else if (percent >= 60) {
            grade.add("D");
        }
        else {
            return "F";
        }

        if ((percent % 10) >= 8 || percent == 100) {
            grade.add("+");
        }
        else if ((percent % 10) < 3 && (percent % 10) != 0) {
            grade.add("-");
        }
        else {
            grade.add("");
        }
        
        return (String.join("", grade.get(0), grade.get(1)));
    }
}
