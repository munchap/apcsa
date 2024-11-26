import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class GradeSimCopy {
    public static void main(String[] args) {

        final int simulations = 5; // Number of simulations
        final double mean = 75; // Center of the bell curve
        final double standardDeviation = 8.333333333;    // Spread of the bell curve

        int[] grades = {
            0, 0, 0, 0, 0, 0, // A+, A, A-, B+, B, B-
            0, 0, 0, 0, 0, 0, 0 // C+, C, C-, D+, D, D-, F
        };
        String[] gradeLabels = {
            "A+", "A", "A-", "B+", "B", "B-", 
            "C+", "C", "C-", "D+", "D", "D-", "F"
        };

        Random random = new Random();
        double randomGrade = 0;
        double maxGrade = 0;
        ArrayList<Double> savedGrades = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Curve grade? (true or false): ");
        boolean curve = scanner.nextBoolean();

        

        for (int i = 0; i < simulations; i++) {
            randomGrade = Math.max(0, Math.round((mean + standardDeviation * random.nextGaussian()) * 100.0) / 100.0);
            if (randomGrade > maxGrade) {
                maxGrade = randomGrade;
            }
            savedGrades.add(randomGrade);
        }

        double curveValue = 100 - maxGrade;
        curveValue = Math.round(curveValue * 100.0) / 100.0;
        Collections.sort(savedGrades); 

        System.out.println("Uncurved scores: ");
        for (int i = 0; i < simulations; i++) {
            checkGrade(savedGrades.get(i), grades);
        }            
        
        if (curve == true) {
            System.out.println("Curved scores: ");
            for (int i = 0; i < simulations; i++) {
                savedGrades.set(i, Math.round((savedGrades.get(i) + curveValue) * 100.0) / 100.0);
                checkGrade(savedGrades.get(i), grades);
            }
        }
        
        for (int i = 0; i < grades.length; i++) {
            System.out.println(gradeLabels[i] + ": " + grades[i]);
        }
        System.out.println("Curve: " + curveValue);
    }

    public static void checkGrade(double grade, int[] grades) {
        switch (Grade.gradeMain(grade)) {
            case "A+" -> grades[0]++;
            case "A" -> grades[1]++;
            case "A-" -> grades[2]++;
            case "B+" -> grades[3]++;
            case "B" -> grades[4]++;
            case "B-" -> grades[5]++;
            case "C+" -> grades[6]++;
            case "C" -> grades[7]++;
            case "C-" -> grades[8]++;
            case "D+" -> grades[9]++;
            case "D" -> grades[10]++;
            case "D-" -> grades[11]++;
            case "F" -> grades[12]++;       
        }
    }
}
