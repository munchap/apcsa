import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class GradeSim {
    public static void main(String[] args) {

        final int simulations = 100; // Number of simulations
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
        double randomGrade;
        double maxGrade = 0;
        double curveValue = 0;
        ArrayList<Double> savedGrades = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Curve options: 1 = none, 2 = linear, 3 = root");
        int curve = scanner.nextInt();
        scanner.close();

        for (int i = 0; i < simulations; i++) {
            randomGrade = Math.max(0, Math.round((mean + standardDeviation * random.nextGaussian()) * 100.0) / 100.0);
            if (randomGrade > 100) {
                randomGrade = 100;
            }
            if (randomGrade > maxGrade) {
                maxGrade = randomGrade;
            }
            savedGrades.add(randomGrade);
        }

        Collections.sort(savedGrades);

        System.out.println("Uncurved scores: ");
        for (int i = 0; i < simulations; i++) {
            if (curve != 2 && curve != 3){
                checkGrade(savedGrades.get(i), grades);
            }
            else {
                System.out.println(savedGrades.get(i) + "%");
            }
        }            

        switch (curve) {
            case 2 -> linearScale(curveValue, maxGrade, simulations, savedGrades, grades);
            case 3 -> rootScale(maxGrade, simulations, savedGrades, grades);
        }

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == 0){
                continue;
            }
            System.out.println(gradeLabels[i] + ": " + grades[i]);
        }
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

    public static void linearScale(double curveValue, double maxGrade, int simulations, ArrayList<Double> savedGrades, int[] grades) {
        curveValue = 100 - maxGrade;
        curveValue = Math.round(curveValue * 100.0) / 100.0;      
        System.out.println("Curved scores: ");
        for (int i = 0; i < simulations; i++) {
            savedGrades.set(i, Math.round((savedGrades.get(i) + curveValue) * 100.0) / 100.0);
            checkGrade(savedGrades.get(i), grades);
        }
    }

    public static void rootScale(double maxGrade, int simulations, ArrayList<Double> savedGrades, int[] grades) {
        System.out.println("Curved scores: ");
        for (int i = 0; i < simulations; i++) {
            savedGrades.set(i, Math.round(Math.sqrt(savedGrades.get(i)) * 1000.0) / 100.0);
            checkGrade(savedGrades.get(i), grades);
        }
    }
}
